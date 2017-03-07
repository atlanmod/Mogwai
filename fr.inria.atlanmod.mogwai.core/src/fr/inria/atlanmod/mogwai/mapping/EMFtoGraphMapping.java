package fr.inria.atlanmod.mogwai.mapping;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.Pipeline;

/**
 * Defines the methods that should be implemented to use Mogwaï-ATL with a
 * specific EMF to Graph mapping.
 * <p>
 * The methods defined in this interface are called within the generated script
 * and are responsible of retrieving EMF-related information inside a graph
 * database. They are inspired from the ones defined in the ATL API.
 * <p>
 * Most of the method have two implementations: one that takes the current
 * element in its parameters and returns the computed value from this element,
 * and another that only takes additional parameters and compute the value for
 * all the element in the current {@link GremlinPipeline}, returning a
 * {@link Pipe} or a {@link Pipeline} (see <a
 * href="https://github.com/tinkerpop/pipes">Pipe website for further
 * information</a>). Note that these method are implemented as simple wrappers
 * in {@link AbstractMapping}, which can be extended by concrete
 * mapping subclasses.
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

	final static String BINDING_NAME = "mappingHelper";

	/**
	 * Sets the {@link Graph} to apply this mapping on.
	 * <p>
	 * <b>Note:</b> this method has to be called before any graph manipulation
	 * method.
	 * 
	 * @param graph
	 *            the graph to apply this mapping on
	 */
	void setGraph(Graph graph);

	/**
	 * Returns an {@link Iterable} containing all the instances of the type
	 * {@code typeName}.
	 * <p>
	 * <b>Note:</b> result only contains strict instances of the given type. To
	 * get all the instances of {@code typeName} and its subclasses see
	 * {@link #allOfKind(String)} and {@link #allOfKindPipeline(String)}.
	 * 
	 * @param typeName
	 *            the name of the metaclass to get the instances of
	 * @return an {@link Iterable} containing all the instances of the type
	 *         {@code typeName}
	 *         
	 * @see #allOfTypePipeline(String)
	 */
	Iterable<Vertex> allOfType(String typeName);

	/**
	 * Returns a {@link Pipeline} initialized with all the instances of the type
	 * {@code typeName}.
	 * <p>
	 * <b>Note:</b> result only contains strict instances of the given type. To
	 * get all the instances of {@code typeName} and its subclasses see
	 * {@link #allOfKind(String)} and {@link #allOfKindPipeline(String)}.
	 * 
	 * @param typeName
	 *            the name of the metaclass to get the instances of
	 * @return a {@link Pipeline} initialized with all the instances of the type
	 *         {@code typeName}
	 *         
	 * @see #allOfType(String)
	 */
	Pipeline<Vertex, ?> allOfTypePipeline(String typeName);

	/**
	 * Returns an {@link Iterable} containing all the instances of the type
	 * {@code typeName} and its subclasses.
	 * 
	 * @param typeName
	 *            the name of the metaclass to get the instances of
	 * @return an {@link Iterable} containing all the instances of the type
	 *         {@code typeName} and its subclasses
	 *         
	 * @see #allOfKindPipeline(String)
	 */
	Iterable<Vertex> allOfKind(String typeName);

	/**
	 * Returns a {@link Pipeline} initialized with all the instances of the type
	 * {@code typeName} and its subclasses.
	 * 
	 * @param typeName
	 *            the name of the metaclass to get the instances of
	 * @return a {@link Pipeline} initialized with all the instances of the type
	 *         {@code typeName} and its subclasses
	 * 
	 * @see #allOfKind(String)
	 */
	Pipeline<Vertex, ?> allOfKindPipeline(String typeName);

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
	 *         
	 */
	Object newInstance(String typeName, String typePackageNsURI);

	/**
	 * Returns an {@link Iterable} containing the {@link Vertex} elements
	 * connected to {@code from} with an {@link Edge} labeled {@code refName}.
	 * 
	 * @param from
	 *            the {@link Vertex} to get the reference from
	 * @param refName
	 *            the name of the reference to navigate
	 * @return an {@link Iterable} containing the {@link Vertex} elements
	 *         connected to {@code from}
	 *         
	 * @see #getRef(String)
	 */
	Iterable<Vertex> getRef(Vertex from, String refName);

	/**
	 * Returns a {@link Pipe} that computes the vertices connected to its input
	 * elements with an {@link Edge} labeled {@code refName}.
	 * 
	 * @param refName
	 *            the name of the reference to navigate
	 * @return a {@link Pipe} that computes the vertices connected to its input
	 *         elements with an {@link Edge} labeled {@code refName}
	 *         
	 * @see #getRef(Vertex, String)
	 */
	Pipe<Vertex, Iterable<Vertex>> getRef(String refName);

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
	 *         
	 * @see #getAtt(String)
	 */
	Object getAtt(Vertex from, String attName);

	/**
	 * Returns a {@link Pipe} that computes the attribute(s) {@code attName} of
	 * its input elements.
	 * 
	 * @param attName
	 *            the name of the attribute to retrieve
	 * @return a {@link Pipe} that computes the attribute(s) {@code attName} of
	 *         its input elements
	 *         
	 * @see #getAtt(Vertex, String)
	 */
	Pipe<Vertex, Object> getAtt(String attName);

	/**
	 * Set the value of the attribute {@code attName} of {@code from} to
	 * {@code attValue}.
	 * 
	 * @param from
	 *            the {@link Vertex} to set the attribute of
	 * @param attName
	 *            the name of the attribute to set
	 * @param attValue
	 *            the value of the attribute to set
	 * @return the updated {@link Vertex}
	 * 
	 * @see #setAtt(String, Object)
	 */
	Vertex setAtt(Vertex from, String attName, Object attValue);

	/**
	 * Returns a {@link Pipe} that sets the attribute {@code attName} of its
	 * input elements to {@code attValue}.
	 * 
	 * @param attName
	 *            the name of the attribute to set
	 * @param attValue
	 *            the value of the attribute to set
	 * @return a {@link Pipe} that sets the attribute {@code attName} of its
	 *         input elements to {@code attValue}
	 *         
	 * @see #setAtt(Vertex, String, Object)
	 */
	Pipe<Vertex, Vertex> setAtt(String attName, Object attValue);

	/**
	 * Returns the type of the {@code from} element.
	 * 
	 * @param from
	 *            the {@link Vertex} to get the type of
	 * @return a String representation of the metaclass associated to
	 *         {@code from}
	 *         
	 * @see #getType()
	 */
	String getType(Vertex from);

	/**
	 * Returns a {@link Pipe} that computes the type of its input elements.
	 * 
	 * @return a {@link Pipe} that computes the type of its input elements
	 * 
	 * @see #getType(Vertex)
	 */
	Pipe<Vertex, String> getType();

	/**
	 * Returns whether {@code from} is an instance of {@code type}.
	 * <p>
	 * <b>Note:</b> this method only checks if {@code from} is a strict instance
	 * of the {@code type}. To check if {@code from} is an instance of
	 * {@code type} or any of its subclasses see
	 * {@link #isKindOf(Vertex, String)} and {@link #isKindOf(String)}.
	 * 
	 * @param from
	 *            the {@link Vertex} to check the type of
	 * @param type
	 *            the type to check
	 * @return {@code true} if {@code from} is an instance of {@code type},
	 *         {@code false} otherwise
	 *         
	 * @see #isTypeOf(String)
	 */
	boolean isTypeOf(Vertex from, String type);

	/**
	 * Returns a {@link Pipe} that computes for each input element whether it is
	 * an instance of {@code type}.
	 * <p>
	 * <b>Note:</b> the created {@link Pipe} only checks if its input elements
	 * are strict instances of {@code type}. To check if they are instances of
	 * {@code type} or any of its subclasses see
	 * {@link #isKindOf(Vertex, String)} and {@link #isKindOf(String)}.
	 * 
	 * @param type
	 *            the type to check
	 * @return a {@link Pipe} that computes for each input element whether it is
	 *         an instance of {@code type} or any of its subclasses
	 *         
	 * @see #isTypeOf(Vertex, String)
	 */
	Pipe<Vertex, Boolean> isTypeOf(String type);

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
	 *         
	 * @see #isKindOf(String)
	 */
	boolean isKindOf(Vertex from, String type);

	/**
	 * Returns a {@link Pipe} that computes for each input element whether it is
	 * an instance of {@code type} or any of its subclasses.
	 * 
	 * @param type
	 *            the type to check
	 * @return a {@link Pipe} that computes for each input element whether is is
	 *         an instance of {@code type} or any of its subclasses
	 *         
	 * @see #isKindOf(Vertex, String)
	 */
	Pipe<Vertex, Boolean> isKindOf(String type);
}
