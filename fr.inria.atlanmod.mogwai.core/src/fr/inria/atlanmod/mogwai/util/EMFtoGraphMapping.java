package fr.inria.atlanmod.mogwai.util;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;

/**
 * Defines the methods that should be implemented to use Mogwaï-ATL with a
 * specific EMF to Graph mapping.
 * <p>
 * The methods defined in this interface are called within the generated script
 * and are responsible of retrieving EMF-related information inside a graph
 * database. These method are inspired from the ones defined in the ATL API.
 * <p>
 * A custom {@link EMFtoGraphMapping} can be provided to the Mogwai-ATL engine
 * using the following code:
 * 
 * <pre>
 * {@code
 * EMFtoGraphMapping myHelper = new // an implementation of this interface
 * 
 * MogwaiQuery query = MogwaiATLQueryBuilder.newBuilder()
 * 	.fromFile(new File("myScript.gremlin"))
 * 	.bind(TransformationHelper.BINDING_NAME, helper)
 * 	.build();
 * }
 * </pre>
 * 
 * @author Gwendal DANIEL
 *
 */
public interface EMFtoGraphMapping {

	public final static String BINDING_NAME = "mappingHelper";

	/**
	 * Sets the {@link Graph} to apply this mapping on.
	 * <p>
	 * <b>Note:</b> this method has to be called before any graph manipulation
	 * method.
	 * 
	 * @param graph
	 *            the graph to apply this mapping on
	 */
	public void setGraph(Graph graph);

	/**
	 * Returns an {@link Iterable} containing all the instances of the type
	 * {@code typeName}.
	 * <p>
	 * <b>Note:</b> result only contains strict instances of the given type. To
	 * get all the instances of {@code typeName} and its subclasses see
	 * {@link #allOfKind(String)}.
	 * 
	 * @param typeName
	 *            the name of the metaclass to get the instances of
	 * @return an {@link Iterable} containing all the instances of the type
	 *         {@code typeName}
	 */
	public Iterable<Vertex> allOfType(String typeName);

	/**
	 * Returns an {@link Iterable} containing all the instances of the type
	 * {@code typeName} and its subclasses.
	 * 
	 * @param typeName
	 *            the name of the metaclass to get the instances of
	 * @return an {@link Iterable} containing all the instances of the type
	 *         {@code typeName} and its subclasses
	 */
	public Iterable<Vertex> allOfKind(String typeName);

	/**
	 * Creates a new instance of the type {@code typeName}.
	 * <p>
	 * {@code typePackageNsURI} can be provided for mappings that support
	 * metaclasses defined in multiple EPackages. Note that this information may
	 * be optional or mandatory, depending on the mapping used.
	 * 
	 * @param typeName
	 *            the name of the metaclass to create an instance of
	 * @param typePackageNsURI
	 *            the URI of the EPackage that defines the metaclass
	 *            {@code typeName}
	 * @return an {@link Object} representing the created instance of
	 *         {@code typeName}
	 */
	public Object newInstance(String typeName, String typePackageNsURI);

	/**
	 * Returns an {@link Iterable} containing the {@link Vertex} elements
	 * connected to {@code from} with an {@link Edge} labelled {@code refName}.
	 * 
	 * @param from
	 *            the {@link Vertex} to get the reference from
	 * @param refName
	 *            the name of the reference to navigate
	 * @return an {@link Iterable} containing the {@link Vertex} elements
	 *         connected to {@code from}
	 */
	public Iterable<Vertex> getRef(Vertex from, String refName);

	/**
	 * Returns an {@link Object} containing the attribute(s) {@code attName} of
	 * {@code from}.
	 * 
	 * @param from
	 *            the {@link Vertex} to get the attribute from
	 * @param attName
	 *            the name of the attribute to retrieve
	 * @return an {@link Object} containing the attribute(s) {@code attName} of
	 *         {@code from}
	 */
	public Object getAtt(Vertex from, String attName);

	/**
	 * Returns the type of the {@code from} element.
	 * 
	 * @param from
	 *            the {@link Vertex} to get the type of
	 * @return a String representation of the metaclass associated to
	 *         {@code from}
	 */
	public String getType(Vertex from);

	/**
	 * Returns whether {@code from} is an instance of {@code type}.
	 * <p>
	 * <b>Note:</b> this method only checks if {@code from} is a strict instance
	 * of the {@code type}. To check if {@code from} is an instance of
	 * {@code type} or any of its subclasses see
	 * {@link #isKindOf(Vertex, String)}.
	 * 
	 * @param from
	 *            the {@link Vertex} to check the type of
	 * @param type
	 *            the type to check
	 * @return {@code true} if {@code from} is an instance of {@code type},
	 *         {@code false} otherwise
	 */
	public boolean isTypeOf(Vertex from, String type);

	/**
	 * Returns whether {@code from} is an instance of {@code type} or any of its
	 * subclasses.
	 * 
	 * @param from
	 *            the {@link Vertex} to check the type of
	 * @param type
	 *            the type to check
	 * @return {@code true} if {@code from} is an instance of {@code type} or
	 *         any of its subclasses, {@code false} otherwise
	 */
	public boolean isKindOf(Vertex from, String type);
}
