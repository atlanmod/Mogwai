package fr.inria.atlanmod.mogwai.util;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.util.GraphHelper;
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline;

import fr.inria.atlanmod.mogwai.mapping.EMFtoGraphMapping;

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

	/**
	 * The mapping used to compute graph operations.
	 */
	private EMFtoGraphMapping mapping;

	/**
	 * Creates a new {@link TransformationHelper} fusing the provided
	 * {@link EMFtoGraphMapping}.
	 * 
	 * @param mapping
	 *            the mapping used to compute the graph operations
	 */
	public TransformationHelper(EMFtoGraphMapping mapping) {
		this.mapping = mapping;
	}

	/**
	 * Creates a new metaclass {@link Vertex} in the graph
	 * 
	 * @param metaclassName
	 *            the name of the metaclass to create
	 * @param nsURI
	 *            the nsURI of the metaclass to create
	 * @return the created {@link Vertex}
	 */
	// public Vertex createMetaclass(String metaclassName, String nsURI) {
	// checkNotNull(metaclassName, "Cannot create a metaclass with null name");
	// checkNotNull(nsURI, "Cannot create a metaclass with null nsURI");
	// Vertex metaclassVertex = graph.addVertex(metaclassName + '@' + nsURI);
	// metaclassVertex.setProperty("name", metaclassName);
	// metaclassVertex.setProperty("nsURI", nsURI);
	// graph.getIndex("metaclasses", Vertex.class).put("name", metaclassName,
	// metaclassVertex);
	// return metaclassVertex;
	// }

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
	public Vertex createElement(Vertex source, String targetLabel, String metaclassType, String nsURI, String resourceName) {
		checkNotNull(metaclassType, "Cannot create an element from a null metaclass");
		Vertex v = (Vertex) mapping.newInstance(metaclassType, nsURI, resourceName);
		Edge traceLink = source.addEdge(TRACE_LINK_LABEL, v);
		traceLink.setProperty(TRACE_LINK_TARGET_KEY, targetLabel);
		return v;
	}

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
	public Edge link(Vertex v1, Vertex v2, String label, boolean isContainment) {
		checkNotNull(v1, "Cannot create a link from null");
		checkNotNull(v2, "Cannot create a link to null");
		checkNotNull(label, "Cannot create a link with null label");
		return mapping.setRef(v1, label, v2, isContainment);
	}

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
		/*
		 * we assume here that v1 and v2 are in the same graph (it is the case
		 * if inHelper = outHelper, but should not be true all the time) TODO
		 * find a way to deal with cross-graph edges
		 */
		Edge pEdge = link(v1, v2, PROXY_LABEL, false);
		/*
		 * Proxy links cannot be containment feature, this information is holded
		 * in the edge properties to avoid mapping side-effects resulting on
		 * containment handling
		 */
		pEdge.setProperty(BASE_LABEL_KEY, label);
		if (isContainment) {
			pEdge.setProperty(IS_CONTAINMENT_KEY, true);
		}
		return pEdge;
	}

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
			if (isNull(baseLabel)) {
				throw new RuntimeException("[Debug] A proxy link has null as its base label");
			}
			mapping.setRef(outV, baseLabel, target, isContainment);
			// Delete the proxy, it is no longer needed
			mapping.removeRef(outV, PROXY_LABEL, source, false);
		}
	}

	/**
	 * Checks whether the given {@link Vertex} can be resolved.
	 * 
	 * @param source
	 *            the {@link Vertex} to check
	 * @return {@code true} is the {@link Vertex} can be resolved, {@code false}
	 *         otherwise
	 */
	public boolean isResolvable(Vertex source) {
		return mapping.getRef(source, TRACE_LINK_LABEL).iterator().hasNext();
	}

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
		return mapping.getRef(source, TRACE_LINK_LABEL).iterator().next();
		// return source.getVertices(Direction.OUT,
		// TRACE_LINK_LABEL).iterator().next();
	}

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
	public Edge linkReference(Vertex source, Vertex target, String label, boolean isContainment) {
		// TODO resolve inside the method to optimize database accesses
		if (isResolvable(target)) {
			return link(source, resolve(target), label, isContainment);
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
	public List<Edge> linkReference(Vertex source, Iterable<Vertex> target, String label, boolean isContainment) {
		// TODO resolve inside the method to optimize database accesses
		List<Edge> createdEdges = new ArrayList<>();
		for (Vertex vv : target) {
			if (isResolvable(vv)) {
				createdEdges.add(link(source, resolve(vv), label, isContainment));
			} else {
				createdEdges.add(pLink(source, vv, label, isContainment));
			}
		}
		return createdEdges;
	}

}
