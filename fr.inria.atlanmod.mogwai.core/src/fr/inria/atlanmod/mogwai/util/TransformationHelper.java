package fr.inria.atlanmod.mogwai.util;

import java.util.Collection;

import com.tinkerpop.blueprints.Vertex;

/**
 * Defines the methods that should be implemented to use Mogwaï-ATL with a
 * specific EMF to Graph mapping.
 * <p>
 * The methods defined in this interface are called within the generated script
 * and are responsible of retrieving EMF-related information inside a graph
 * database. These method are inspired from the ones defined in the ATL API.
 * <p>
 * A custom {@link TransformationHelper} can be provided to the Mogwai-ATL engine using the following code:
 * <pre>
 * {@code
 * TransformationHelper myHelper = new // an implementation of this interface
 * 
 * MogwaiQuery query = MogwaiATLQueryBuilder.newBuilder()
 *		.fromFile(new File("myScript.gremlin"))
 *		.bind(TransformationHelper.BINDING_NAME, helper)
 *		.build();
 * }
 * </pre>
 * 
 * @author Gwendal DANIEL
 *
 */
public interface TransformationHelper {
	
	public final static String BINDING_NAME = "transformationHelper";

	/*
	 * Should we define method with Pipes in the signature? Not sure if it makes
	 * sense or not maybe an abstract class that uses the vertex based methods
	 */

	// Collection vs. Iterable vs. Iterator?
	public Collection<Vertex> allOfType(String typeName);

	// Collection vs. Iterable vs. Iterator?
	public Collection<Vertex> allOfKind(String typeName);

	// Object?
	public Object newInstance(String typeName);

	// Collection vs. Iterable vs. Iterator?
	public Collection<Vertex> getRef(Vertex from, String refName);

	// Collection vs. Iterable vs. Iterator?
	public Collection<Object> getAtt(Vertex from, String attName);

	public String getType(Vertex from);

	public boolean isTypeOf(Vertex from, String type);

	public boolean isKindOf(Vertex from, String type);
}
