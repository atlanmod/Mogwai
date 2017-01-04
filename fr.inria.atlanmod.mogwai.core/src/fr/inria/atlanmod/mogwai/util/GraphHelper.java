package fr.inria.atlanmod.mogwai.util;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Iterator;

import org.eclipse.emf.ecore.util.EcoreUtil;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.KeyIndexableGraph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.util.wrappers.id.IdGraph;


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
	
	private IdGraph<KeyIndexableGraph> graph;

	/**
	 * Creates a new {@link GraphHelper} wrapping the given graph
	 * @param baseGraph the graph to manipulate using the helper
	 */
	public GraphHelper(IdGraph<KeyIndexableGraph> baseGraph) {
		this.graph = baseGraph;
	}

	/**
	 * Creates a new metaclass {@link Vertex} in the graph
	 * @param metaclassName the name of the metaclass to create
	 * @param nsURI the nsURI of the metaclass to create
	 * @return the created {@link Vertex}
	 */
	public Vertex createMetaclass(String metaclassName, String nsURI) {
		checkNotNull(metaclassName, "Cannot create a metaclass with null name");
		checkNotNull(nsURI, "Cannot create a metaclass with null nsURI");
		Vertex metaclassVertex = graph.addVertex(metaclassName + '@' + nsURI);
		metaclassVertex.setProperty("name", metaclassName);
		metaclassVertex.setProperty("nsURI", nsURI);
		graph.getIndex("metaclasses", Vertex.class).put("name", metaclassName, metaclassVertex);
		return metaclassVertex;
	}
	
	/**
	 * Creates a new element {@link Vertex} and connects it to its metaclass. A trace link is also generated between the
	 * source element and the created one to ensure transformation consistency
	 * @param source the {@link Vertex} that triggered the element creation (i.e. the source element in the transformation)
	 * @param targetLabel the label of the created element in the transformation (i.e. the name in the binding)
	 * @param metaclassVertex the {@link Vertex} representing the metaclass
	 * @return the created {@link Vertex}
	 */
	public Vertex createElement(Vertex source, String targetLabel, Vertex metaclassVertex) {
		checkNotNull(metaclassVertex, "Cannot create an element from a null metaclass");
		Vertex elementVertex = graph.addVertex(EcoreUtil.generateUUID());
		elementVertex.addEdge("kyanosInstanceOf", metaclassVertex);
		Edge traceLink = source.addEdge(TRACE_LINK_LABEL, elementVertex);
		traceLink.setProperty(TRACE_LINK_TARGET_KEY, targetLabel);
		return elementVertex;
	}
	
	/**
	 * Creates a link between {@code v1} and {@code v2} with the given {@code label}
	 * @param v1 the tail {@link Vertex}
	 * @param v2 the head {@link Vertex}
	 * @param label the label of the link
	 * @return the created {@link Edge}
	 */
	public Edge link(Vertex v1, Vertex v2, String label) {
		checkNotNull(v1, "Cannot create a link from null");
		checkNotNull(v2, "Cannot create a link to null");
		checkNotNull(label, "Cannot create a link with null label");
		return v1.addEdge(label, v2);
	}
	
	/**
	 * Creates a proxy link between {@code v1} and {@code v2} with the given {@code label}
	 * @param v1 the tail {@link Vertex}
	 * @param v2 the head {@link Vertex}
	 * @param label the label of the proxy link
	 * @return the created {@link Edge}
	 */
	public Edge pLink(Vertex v1, Vertex v2, String label) {
		checkNotNull(v1, "Cannot create a pLink from null");
		checkNotNull(v2, "Cannot create a pLink to null");
		checkNotNull(label, "Cannot create a pLink with null label");
		// we assume here that v1 and v2 are in the same graph (it is the case
		// if inHelper = outHelper, but should not be true all the time
		// TODO find a way to deal with cross-graph edges
		Edge pEdge = v1.addEdge(PROXY_LABEL, v2);
		pEdge.setProperty(BASE_LABEL_KEY, label);
		return pEdge;
	}
	
	/**
	 * Resolve the proxy links connected to {@code source} by setting their tail to {@code target}.
	 * Proxy links are removed from the graph, and resolved {@link Edge} are created using {@code target}
	 * @param source the {@link Vertex} that is connected to proxy links
	 * @param target the {@link Vertex} that resolves the proxies
	 */
	public void resolveProxies(Vertex source, Vertex target) {
		int resolvedCount = 0;
		Iterator<Edge> pEdges = source.getEdges(Direction.IN, PROXY_LABEL).iterator();
		while(pEdges.hasNext()) {
			Edge pEdge = pEdges.next();
			Vertex outV = pEdge.getVertex(Direction.OUT);
			if(outV.getId().equals(source.getId())) {
				throw new RuntimeException("[Debug] Invalid traversal: in = out");
			}
			String baseLabel = pEdge.<String>getProperty(BASE_LABEL_KEY);
			if(baseLabel == null) {
				throw new RuntimeException("[Debug] A proxy link has null as its base label");
			}
			resolvedCount++;
			outV.addEdge(baseLabel, target);
			// Delete the proxy, it is no longer needed
			pEdge.remove();
		}
		System.out.println("[DEBUG] Resolved " + resolvedCount + " proxies for " + source.getId());
	}
	
	/**
	 * @param source the {@link Vertex} to check
	 * @return {@code true} is the {@link Vertex} can be resolved, {@code false} otherwise
	 */
	public boolean isResolvable(Vertex source) {
		return source.getEdges(Direction.OUT, TRACE_LINK_LABEL).iterator().hasNext();
	}
	
	/**
	 * Resolves the {@code source} {@link Vertex} by inspecting trace links
	 * @param source the {@link Vertex} to resolve
	 * @return the {@link Vertex} corresponding to the resolved element
	 */
	public Vertex resolve(Vertex source) {
		return source.getVertices(Direction.OUT, TRACE_LINK_LABEL).iterator().next();
	}

}
