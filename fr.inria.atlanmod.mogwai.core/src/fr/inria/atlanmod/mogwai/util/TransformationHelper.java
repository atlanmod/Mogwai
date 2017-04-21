package fr.inria.atlanmod.mogwai.util;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Iterables;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.util.GraphHelper;
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;

/**
 * A helper used in generated script to execute transformation-related
 * instructions.
 * <p>
 * The methods provided in this class are called by the transformation to avoid
 * complex (and inefficient) gremlin instructions. This helper is independent of
 * the implicit schema used to represent the model, and delegate all the graph
 * database accesses to its embedded {@link EMFtoGraphMapping}.
 * 
 * @see EMFtoGraphMapping
 * 
 * @author Gwendal DANIEL
 *
 */
public class TransformationHelper {

	/**
	 * The label used to represent proxy links.
	 */
	private final static String PROXY_LABEL = "#atl2gremlinProxy";

	/**
	 * The label used to represent trace links.
	 */
	private final static String TRACE_LINK_LABEL = "#trace";

	/**
	 * The attribute key used to store the base label of a proxy link.
	 */
	private final static String BASE_LABEL_KEY = "baseLabel";

	/**
	 * The attribute key used to store trace link targets.
	 */
	private final static String TRACE_LINK_TARGET_KEY = "target";

	private final static String IS_CONTAINMENT_KEY = "isContainment";

	private final static String IS_TARGET_KEY = "is_target";

	/**
	 * The mapping used to compute graph operations.
	 */
	private ModelDatastore<Graph, Vertex, Edge, Object> mapping;

	/**
	 * Creates a new {@link TransformationHelper} fusing the provided
	 * {@link EMFtoGraphMapping}.
	 * 
	 * @param mapping
	 *            the mapping used to compute the graph operations
	 */
	public TransformationHelper(ModelDatastore<?, ?, ?, ?> mapping) {
		// TODO remove this with an interface for the transformation helper that accepts any kind of mapping
		// + an abstraction that doesn't use a mapping
		this.mapping = (ModelDatastore<Graph, Vertex, Edge, Object>) mapping;
	}

	/**
	 * Creates a new element mapped from the provided {@code source}.
	 * <p>
	 * The {@code source} element and the {@code targetLabel} are provided to
	 * allow trace link creation. Element creation is delegated to the
	 * underlying {@link EMFtoGraphMapping}, that processes the
	 * {@code metaclassType} and {@code nsURI} to create a new instance of the
	 * given type.
	 * 
	 * @param source
	 *            the element mapped by the transformation
	 * @param targetLabel
	 *            the label used in the transformation for the created element
	 * @param metaclassType
	 *            the type of the element to create
	 * @param nsURI
	 *            the {@code uri} of the EPackage containing the metaclass to
	 *            instantiate
	 * @return the created {@link Vertex}
	 * 
	 * @throws NullPointerException
	 *             if the provided {@code metaclassType} is null
	 */
	public Vertex createElement(Vertex source, String targetLabel, String metaclassType, String nsURI,
			String resourceName) {
		long begin = System.currentTimeMillis();
		checkNotNull(metaclassType, "Cannot create an element from a null metaclass");
		Vertex v = (Vertex) mapping.newInstance(metaclassType, nsURI, resourceName);
		/*
		 * Set the element as a target element to avoid not resolvable proxies
		 * for target-specific model elements
		 */
		v.setProperty(IS_TARGET_KEY, true);
		Edge traceLink = source.addEdge(TRACE_LINK_LABEL, v);
		traceLink.setProperty(TRACE_LINK_TARGET_KEY, targetLabel);
		long end = System.currentTimeMillis();
		createTime += (end-begin);
		return v;
	}
	
	public static long createTime = 0;

	/**
	 * Creates a link between {@code v1} and {@code v2} with the given
	 * {@code label}.
	 * <p>
	 * <b>Note:</b> {@code isContainment} parameter is used by the underlying
	 * {@link EMFtoGraphMapping} to store container specific information
	 * 
	 * @param v1
	 *            the tail {@link Vertex}
	 * @param v2
	 *            the head {@link Vertex}
	 * @param label
	 *            the label of the link
	 * @param isContainment
	 *            {@code true} if the link is a containment, {@code false}
	 *            otherwise
	 * @return the created {@link Edge}
	 * 
	 * @throws NullPointerException
	 *             if {@code v1}, {@code v2}, or {@code label} is null
	 */
	public Edge link(Vertex v1, Vertex v2, String label, String oppositeLabel, boolean isContainment) {
		long begin = System.currentTimeMillis();
		checkNotNull(v1, "Cannot create a link from null");
		checkNotNull(v2, "Cannot create a link to null");
		checkNotNull(label, "Cannot create a link with null label");
		Edge result = mapping.setRef(v1, label, oppositeLabel, v2, isContainment);
		long end = System.currentTimeMillis();
		linkTime += (end-begin);
		return result;
	}
	
	public static long linkTime = 0;

	/**
	 * Creates a proxy link between {@code v1} and {@code v2} with the given
	 * {@code label}
	 * 
	 * @param v1
	 *            the tail {@link Vertex}
	 * @param v2
	 *            the head {@link Vertex}
	 * @param label
	 *            the label of the proxy link
	 * @param isContainment
	 *            {@code true} if the proxy link is a containment, {@code false}
	 *            otherwise
	 * @return the created {@link Edge}
	 * @throws NullPointerException
	 *             if {@code v1}, {@code v2}, or {@code label} is null
	 */
	public Edge pLink(Vertex v1, Vertex v2, String label, boolean isContainment) {
		long begin = System.currentTimeMillis();
		/*
		 * we assume here that v1 and v2 are in the same graph (it is the case
		 * if inHelper = outHelper, but should not be true all the time) TODO
		 * find a way to deal with cross-graph edges
		 */
		Edge pEdge = link(v1, v2, PROXY_LABEL, null, false);
		/*
		 * Proxy links cannot be containment feature, this information is holded
		 * in the edge properties to avoid mapping side-effects resulting on
		 * containment handling
		 */
		pEdge.setProperty(BASE_LABEL_KEY, label);
		if (isContainment) {
			pEdge.setProperty(IS_CONTAINMENT_KEY, true);
		}
		long end = System.currentTimeMillis();
		pLinkTime += (end-begin);
		return pEdge;
	}
	
	public static long pLinkTime = 0;

	/**
	 * Resolve the proxy links connected to {@code source} by setting their tail
	 * to {@code target}.
	 * <p>
	 * Resolved proxy links are removed from the graph.
	 * 
	 * @param source
	 *            the {@link Vertex} that is connected to proxy links
	 * @param target
	 *            the {@link Vertex} that resolves the proxies
	 */
	public void resolveProxies(Vertex source, Vertex target) {
		long begin = System.currentTimeMillis();
		// Should be put in mapping
		Iterator<Edge> pEdges = source.getEdges(Direction.IN, PROXY_LABEL).iterator();
		while (pEdges.hasNext()) {
			Edge pEdge = pEdges.next();
			Vertex outV = pEdge.getVertex(Direction.OUT);
			if (outV.getId().equals(source.getId())) {
				throw new RuntimeException("[Debug] Invalid traversal: in = out");
			}
			String baseLabel = pEdge.getProperty(BASE_LABEL_KEY);
			Boolean isContainment = pEdge.getProperty(IS_CONTAINMENT_KEY);
			if(isNull(isContainment)) {
				/*
				 * False is not set in the database to reduce its size
				 */
				isContainment = false;
			}
			if (isNull(baseLabel)) {
				throw new RuntimeException("[Debug] A proxy link has null as its base label");
			}
			mapping.setRef(outV, baseLabel, null, target, isContainment);
			// Delete the proxy, it is no longer needed
			mapping.removeRef(outV, PROXY_LABEL, source, false);
		}
		long end = System.currentTimeMillis();
		resolveProxyTime += (end-begin);
	}
	
	public static long resolveProxyTime = 0;

	/**
	 * Checks whether the given {@link Vertex} can be resolved.
	 * 
	 * @param source
	 *            the {@link Vertex} to check
	 * @return {@code true} is the {@link Vertex} can be resolved, {@code false}
	 *         otherwise
	 */
	public boolean isResolvable(Vertex source) {
		long begin = System.currentTimeMillis();
		boolean result = mapping.getRef(source, TRACE_LINK_LABEL, null, false).iterator().hasNext();
		long end = System.currentTimeMillis();
		isResolvableTime += (end-begin);
		return result;
	}
	
	public static long isResolvableTime = 0;

	/**
	 * Resolves the {@code source} {@link Vertex} by inspecting trace links.
	 * <p>
	 * This method returns the {@link Vertex} linked to {@code source} by a
	 * trace link if it exists. This allows to handle multiple reference of the
	 * same element in the ATL transformation.
	 * 
	 * @param source
	 *            the {@link Vertex} to resolve
	 * @return the {@link Vertex} corresponding to the resolved element
	 */
	public Vertex resolve(Vertex source) {
		long begin = System.currentTimeMillis();
		Vertex result = mapping.getRef(source, TRACE_LINK_LABEL, null, false).iterator().next();
		long end = System.currentTimeMillis();
		resolveTime += (end - begin);
		return result;
	}

	public static long resolveTime = 0;
	
	/**
	 * Links two elements by creating an edge between the corresponding
	 * {@link Vertex} elements.
	 * <p>
	 * Note that {@code target} is an element in the source model that has to be
	 * resolved. If {@code target} cannot be resolved (because the corresponding
	 * {@link Vertex} has not been created yet) a proxy link (see
	 * {@link GraphHelper#pLink(Vertex, Vertex, String)}) is created that will
	 * be resolved later.
	 * 
	 * @param source
	 *            the tail of the link
	 * @param target
	 *            a source element that is resolved and set as the head of the
	 *            link. If it cannot be resolved a proxy link is created instead
	 * @param label
	 *            the label of the link
	 * @param isContainment
	 *            {@code true} if the reference is a containment, {@code false}
	 *            otherwise
	 * @return the created {@link Edge}
	 * 
	 * @see #linkReference(Vertex, Iterable, String)
	 */
	public Edge linkReference(Vertex source, Vertex target, String label, String oppositeLabel, boolean isContainment) {
		// TODO resolve inside the method to optimize database accesses
		if (isResolvable(target)) {
			return link(source, resolve(target), label, oppositeLabel, isContainment);
		} else {
			return pLink(source, target, label, isContainment);
		}
	}

	/**
	 * Links all the elements of {@code target} to {@code source} by creating
	 * edges between the corresponding {@link Vertex} elements.
	 * <p>
	 * Note that {@code target} contains elements in the source model that have
	 * to be resolved. If {@code target} elements cannot be resolved (because
	 * corresponding {@link Vertex} have not been created yet) a proxy link (see
	 * {@link GraphHelper#pLink(Vertex, Vertex, String)}) is created that will
	 * be resolved later.
	 * 
	 * @param source
	 *            the tail of the links
	 * @param target
	 *            a {@link GremlinGroovyPipeline} containing the elements that
	 *            have to be resolved and set as the head of the created links.
	 *            If some of them cannot be resolved a proxy link is created
	 *            instead
	 * @param label
	 *            the label of the link
	 * @param isContainment
	 *            {@code true} if the reference is a containment, {@code false}
	 *            otherwise
	 * @return a list containing the created {@link Edge}s
	 * 
	 * @see #linkReference(Vertex, Vertex, String)
	 */
	public List<Edge> linkReference(Vertex source, Iterable<Vertex> target, String label, String oppositeLabel, boolean isContainment) {
		// TODO resolve inside the method to optimize database accesses
		List<Edge> createdEdges = new ArrayList<>();
		for (Vertex vv : target) {
			if (isTargetElement(vv)) {
				createdEdges.add(link(source, vv, label, oppositeLabel, isContainment));
			} else {
				if (isResolvable(vv)) {
					createdEdges.add(link(source, resolve(vv), label, oppositeLabel, isContainment));
				} else {
					createdEdges.add(pLink(source, vv, label, isContainment));
				}
			}
		}
		return createdEdges;
	}

	

	/**
	 * Casts the provided {@code object} to a {@code boolean}.
	 * 
	 * @param object
	 *            the {@link Object} to cast
	 * @return the {@code boolean} value representing {@code object}
	 * @throws IllegalArgumentException
	 *             if {@code object} cannot be cast
	 */
	public boolean booleanFrom(Object object) {
		if (object instanceof String) {
			return Boolean.parseBoolean((String) object);
		} else if (object instanceof Boolean) {
			return ((Boolean) object).booleanValue();
		} else {
			throw new IllegalArgumentException(object + " cannot be cast to Boolean");
		}
	}

	/**
	 * Returns whether a {@link Vertex} is in the target model or not.
	 * 
	 * @param vv
	 *            the {@link Vertex}
	 * @return {@code true} if the {@link Vertex} is in the target model,
	 *         {@code false} otherwise
	 */
	private boolean isTargetElement(Vertex vv) {
		Object isTargetProp = vv.getProperty(IS_TARGET_KEY);
		if(nonNull(isTargetProp)) {
			return (boolean)isTargetProp;
		}
		/*
		 * The property isn't set, this means that the object hasn't been
		 * created by the transformation.
		 */
		return false;
	}

}
