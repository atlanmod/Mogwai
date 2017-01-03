package fr.inria.atlanmod.mogwai.util;

import com.tinkerpop.blueprints.KeyIndexableGraph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.util.wrappers.id.IdGraph;
import static com.google.common.base.Preconditions.checkNotNull;


/**
 * A helper used in generated script to manipulate the graph efficiently and
 * avoid complex instruction creation.
 * 
 * @author Gwendal DANIEL
 *
 */
public class GraphHelper {

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

}
