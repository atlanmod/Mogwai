package fr.inria.atlanmod.mogwai.util;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline;

import fr.inria.atlanmod.mogwai.mapping.EMFtoGraphMapping;

/**
 * A helper used in generated script to manipulate the graph efficiently and
 * avoid complex instruction creation.
 * 
 * @author Gwendal DANIEL
 *
 */
public class GraphHelper {

	private final static String PROXY_LABEL = "#atl2gremlinProxy";
	private final static String BASE_LABEL_KEY = "baseLabel";
	private final static String TRACE_LINK_LABEL = "#trace";
	private final static String TRACE_LINK_TARGET_KEY = "target";

	private Graph graph;
	private EMFtoGraphMapping mapping;

	/**
	 * Creates a new {@link GraphHelper} wrapping the given graph
	 * 
	 * @param baseGraph
	 *            the graph to manipulate using the helper
	 */
	public GraphHelper(Graph baseGraph, EMFtoGraphMapping mapping) {
		this.graph = baseGraph;
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
//	public Vertex createMetaclass(String metaclassName, String nsURI) {
//		checkNotNull(metaclassName, "Cannot create a metaclass with null name");
//		checkNotNull(nsURI, "Cannot create a metaclass with null nsURI");
//		Vertex metaclassVertex = graph.addVertex(metaclassName + '@' + nsURI);
//		metaclassVertex.setProperty("name", metaclassName);
//		metaclassVertex.setProperty("nsURI", nsURI);
//		graph.getIndex("metaclasses", Vertex.class).put("name", metaclassName, metaclassVertex);
//		return metaclassVertex;
//	}

	public Vertex createElement(Vertex source, String targetLabel, String metaclassType, String nsURI) {
		checkNotNull(metaclassType, "Cannot create an element from a null metaclass");
		Vertex v = (Vertex)mapping.newInstance(metaclassType, nsURI);
		Edge traceLink = source.addEdge(TRACE_LINK_LABEL, v);
		traceLink.setProperty(TRACE_LINK_TARGET_KEY, targetLabel);
		return v;
	}

	/**
	 * Creates a link between {@code v1} and {@code v2} with the given
	 * {@code label}
	 * 
	 * @param v1
	 *            the tail {@link Vertex}
	 * @param v2
	 *            the head {@link Vertex}
	 * @param label
	 *            the label of the link
	 * @return the created {@link Edge}
	 */
	public Edge link(Vertex v1, Vertex v2, String label) {
		checkNotNull(v1, "Cannot create a link from null");
		checkNotNull(v2, "Cannot create a link to null");
		checkNotNull(label, "Cannot create a link with null label");
		return mapping.setRef(v1, label, v2);
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
	 * @return the created {@link Edge}
	 */
	public Edge pLink(Vertex v1, Vertex v2, String label) {
		checkNotNull(v1, "Cannot create a pLink from null");
		checkNotNull(v2, "Cannot create a pLink to null");
		checkNotNull(label, "Cannot create a pLink with null label");
		// we assume here that v1 and v2 are in the same graph (it is the case
		// if inHelper = outHelper, but should not be true all the time
		// TODO find a way to deal with cross-graph edges
		Edge pEdge = mapping.setRef(v1, PROXY_LABEL, v2);
		pEdge.setProperty(BASE_LABEL_KEY, label);
		return pEdge;
	}

	/**
	 * Resolve the proxy links connected to {@code source} by setting their tail
	 * to {@code target}. Proxy links are removed from the graph, and resolved
	 * {@link Edge} are created using {@code target}
	 * 
	 * @param source
	 *            the {@link Vertex} that is connected to proxy links
	 * @param target
	 *            the {@link Vertex} that resolves the proxies
	 */
	public void resolveProxies(Vertex source, Vertex target) {
		int resolvedCount = 0;
		// Should be put in mapping 
		Iterator<Edge> pEdges = source.getEdges(Direction.IN, PROXY_LABEL).iterator();
		while (pEdges.hasNext()) {
			Edge pEdge = pEdges.next();
			Vertex outV = pEdge.getVertex(Direction.OUT);
			if (outV.getId().equals(source.getId())) {
				throw new RuntimeException("[Debug] Invalid traversal: in = out");
			}
			String baseLabel = pEdge.<String> getProperty(BASE_LABEL_KEY);
			if (baseLabel == null) {
				throw new RuntimeException("[Debug] A proxy link has null as its base label");
			}
			resolvedCount++;
			mapping.setRef(outV, baseLabel, target);
//			outV.addEdge(baseLabel, target);
			// Delete the proxy, it is no longer needed
			pEdge.remove();
		}
//		System.out.println("[DEBUG] Resolved " + resolvedCount + " proxies for " + source.getId());
	}

	/**
	 * @param source
	 *            the {@link Vertex} to check
	 * @return {@code true} is the {@link Vertex} can be resolved, {@code false}
	 *         otherwise
	 */
	public boolean isResolvable(Vertex source) {
		return mapping.getRef(source, TRACE_LINK_LABEL).iterator().hasNext();
//		return source.getEdges(Direction.OUT, TRACE_LINK_LABEL).iterator().hasNext();
	}

	/**
	 * Resolves the {@code source} {@link Vertex} by inspecting trace links
	 * 
	 * @param source
	 *            the {@link Vertex} to resolve
	 * @return the {@link Vertex} corresponding to the resolved element
	 */
	public Vertex resolve(Vertex source) {
		return mapping.getRef(source, TRACE_LINK_LABEL).iterator().next();
//		return source.getVertices(Direction.OUT, TRACE_LINK_LABEL).iterator().next();
	}

	/**
	 * Links two elements by creating an edge between the corresponding
	 * {@link Vertex}. Note that {@code target} is an element in the source
	 * model that has to be resolved. If {@code target} cannot be resolved
	 * (because the corresponding {@link Vertex} has not been created yet) a
	 * proxy link (see @link{GraphHelper#pLink(Vertex, Vertex, String)}) is created
	 * that will be resolved later.
	 * 
	 * @param source
	 *            the tail of the link
	 * @param target
	 *            a source element that is resolved and set as the head of the
	 *            link. If it cannot be resolved a proxy link is created instead
	 * @param label
	 *            the label of the link
	 * @return the created {@link Edge}
	 */
	public Edge linkReference(Vertex source, Vertex target, String label) {
		// TODO resolve inside the method to optimize database accesses
		if (isResolvable(target)) {
			return link(source, resolve(target), label);
		} else {
			return pLink(source, target, label);
		}
	}

	/**
	 * Links all the elements of {@code target} to {@code source} by creating
	 * edges between the corresponding {@link Vertex}. Note that {@code target}
	 * are elements in the source model that have to be resolved. If
	 * {@code target} elements cannot be resolved (because corresponding
	 * {@link Vertex} have not been created yet) a proxy link {see
	 * GraphHelper#pLink(Vertex, Vertex, String)} is created that will be
	 * resolved later.
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
	 * @return a list containing the created {@link Edge}s
	 */
	public List<Edge> linkReference(Vertex source, Iterable<Vertex> target, String label) {
		// TODO resolve inside the method to optimize database accesses
		List<Edge> createdEdges = new ArrayList<>();
		for(Vertex vv : target) {
			if(isResolvable(vv)) {
				createdEdges.add(link(source, resolve(vv), label));
			}
			else {
				createdEdges.add(pLink(source, vv, label));
			}
		}
		return createdEdges;
	}

}
