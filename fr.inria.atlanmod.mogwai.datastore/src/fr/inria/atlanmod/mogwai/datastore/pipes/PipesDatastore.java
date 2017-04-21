package fr.inria.atlanmod.mogwai.datastore.pipes;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.Pipeline;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;

/**
 * Refines {@link ModelDatastore} by providing methods that should be implemented
 * to manipulate a {@code data source} as a model streamed in the <a
 * href="https://github.com/tinkerpop/pipes">Pipes framework</a>.
 * <p>
 * This mapping is used by the Mogwaï-ATL engine to navigate a model and compute
 * ATL transformations based on the <a
 * href="https://github.com/tinkerpop/gremlin">Gremlin traversal query
 * language</a>
 * <p>
 * Methods of this mapping are Pipes' wrappers around the low-level API defined
 * in {@link ModelDatastore}. This API does not define the current element
 * (labeled {@code from} in {@link ModelDatastore}) as a method parameter, and
 * compute the associated operation on all the element in the current
 * {@link GremlinPipeline}, returning a {@link Pipe} or a {@link Pipeline} (see
 * <a href="https://github.com/tinkerpop/pipes">Pipe website</a> for further
 * information).
 * 
 * @author Gwendal DANIEL
 *
 * @param <D>
 *            the type of the {@code data source} to use
 * @param <T>
 *            the type representing {@code model elements}
 * @param <L>
 *            the type representing {@code references}
 * @param <P>
 *            the type representing {@code attributes' value}
 * 
 * @see ModelDatastore
 */
public interface PipesDatastore<D, E, R, A> extends ModelDatastore<D, E, R, A> {

	/**
	 * Returns a {@link Pipeline} initialized with all the elements of the type
	 * {@code typeName}.
	 * <p>
	 * <b>Note:</b> result only contains strict instances of the given type. To
	 * get all the instances of {@code typeName} and its subclasses see
	 * {@link ModelDatastore#allOfKind(String)} and
	 * {@link #allOfKindPipeline(String)}.
	 * 
	 * @param typeName
	 *            the name of the metaclass to get the instances of
	 * @return a {@link Pipeline} initialized with all the elements of the type
	 *         {@code typeName}
	 * 
	 * @see ModelDatastore#allOfType(String)
	 */
	default Pipeline<E, ?> allOfTypePipeline(String typeName) {
		return PipesUtils.pipelineOf(allOfType(typeName));
	}

	/**
	 * Returns a {@link Pipeline} initialized with all the elements of the type
	 * {@code typeName} and its subclasses.
	 * 
	 * @param typeName
	 *            the name of the metaclass to get the instances of
	 * @return a {@link Pipeline} initialized with all the instances of the type
	 *         {@code typeName} and its subclasses
	 * 
	 * @see ModelDatastore#allOfKind(String)
	 */
	default Pipeline<E, ?> allOfKindPipeline(String typeName) {
		return PipesUtils.pipelineOf(allOfKind(typeName));
	}

	/**
	 * Returns a {@link Pipe} that computes the parent elements connected to its
	 * input elements.
	 * 
	 * @return a {@link Pipe} that computes the parent elements connected to its
	 *         input elements
	 * @see ModelDatastore#getParent(Object)
	 */
	default Pipe<E, E> getParent() {
		return PipesUtils.pipeFor((el) -> this.getParent(el));
	}

	/**
	 * Returns a {@link Pipe} that computes the elements connected to its input
	 * elements with a reference labeled {@code refName}.
	 * 
	 * @param refName
	 *            the name of the reference to navigate
	 * @param oppositeName
	 *            the name of the reference's opposite if it exists
	 * @param isContainer
	 *            {@code true} if {@code refName} is a containment,
	 *            {@code false} otherwise
	 * @return a {@link Pipe} that computes the elements connected to its input
	 *         elements with a reference labeled {@code refName}
	 * 
	 * @see ModelDatastore#getRef(Object, String, String, boolean)
	 */
	default Pipe<E, E> getRef(String refName, String oppositeName, boolean isContainer) {
		return PipesUtils.flattenPipeFor((el) -> this.getRef(el, refName, oppositeName, isContainer));
	}

	/**
	 * Returns a {@link Pipe} that creates a reference link between its input
	 * elements and {@code to} with the label {@code refName}.
	 * 
	 * @param refName
	 *            the label of the reference
	 * @param oppositeName
	 *            the name of the reference's opposite if it exists
	 * @param to
	 *            the outgoing {@link Vertex} of the reference
	 * @param isContainment
	 *            {@code true} if the reference is a containment, {@code false}
	 *            otherwise
	 * @return a {@link Pipe} that creates a reference link between its input
	 *         elements and {@code to} with the label {@code refName}
	 * 
	 * @see ModelDatastore#setRef(Object, String, String, Object, boolean)
	 */
	default Pipe<E, R> setRef(String refName, String oppositeName, E to, boolean isContainment) {
		return PipesUtils.pipeFor((el) -> this.setRef(el, refName, oppositeName, to, isContainment));
	}

	/**
	 * Returns a {@link Pipe} that removes a reference link between its input
	 * elements and {@code to} with the label {@code refName}.
	 * 
	 * @param refName
	 *            the label of the reference
	 * @param to
	 *            the outgoing element of the reference
	 * @param isContainment
	 *            {@code true} if the reference is a containment, {@code false}
	 *            otherwise
	 * @return a {@link Pipe} that creates a reference link between its input
	 *         elements and {@code to} with the label {@code refName}
	 * 
	 * @see ModelDatastore#removeRef(Object, String, Object, boolean)
	 */
	default Pipe<E, E> removeRef(String refName, E to, boolean isContainment) {
		return PipesUtils.pipeFor((el) -> this.removeRef(el, refName, to, isContainment));
	}

	/**
	 * Returns a {@link Pipe} that computes the attribute(s) {@code attName} of
	 * its input elements.
	 * 
	 * @param attName
	 *            the name of the attribute to retrieve
	 * @return a {@link Pipe} that computes the attribute(s) {@code attName} of
	 *         its input elements
	 * 
	 * @see ModelDatastore#getAtt(Object, String)
	 */
	default Pipe<E, A> getAtt(String attName) {
		return PipesUtils.flattenPipeFor((el) -> this.getAtt(el, attName));
	}

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
	 * @see ModelDatastore#setAtt(Object, String, Object)
	 */
	default Pipe<E, E> setAtt(String attName, A attValue) {
		return PipesUtils.pipeFor((el) -> this.setAtt(el, attName, attValue));
	}

	/**
	 * Returns a {@link Pipe} that computes the type of its input elements.
	 * 
	 * @return a {@link Pipe} that computes the type of its input elements
	 * 
	 * @see ModelDatastore#getType(Object)
	 */
	default Pipe<E, String> getType() {
		return PipesUtils.pipeFor((el) -> this.getType(el));
	}

	/**
	 * Returns a {@link Pipe} that computes for each input element whether it is
	 * an instance of {@code type}.
	 * <p>
	 * <b>Note:</b> the created {@link Pipe} only checks if its input elements
	 * are strict instances of {@code type}. To check if they are instances of
	 * {@code type} or any of its subclasses see
	 * {@link ModelDatastore#isKindOf(Object, String)} and
	 * {@link #isKindOf(String)}.
	 * 
	 * @param type
	 *            the type to check
	 * @return a {@link Pipe} that computes for each input element whether it is
	 *         an instance of {@code type} or any of its subclasses
	 * 
	 * @see ModelDatastore#isKindOf(Object, String)
	 */
	default Pipe<E, Boolean> isTypeOf(String type) {
		return PipesUtils.pipeFor((el) -> this.isTypeOf(el, type));
	}

	/**
	 * Returns a {@link Pipe} that computes for each input element whether it is
	 * an instance of {@code type} or any of its subclasses.
	 * 
	 * @param type
	 *            the type to check
	 * @return a {@link Pipe} that computes for each input element whether is is
	 *         an instance of {@code type} or any of its subclasses
	 * 
	 * @see ModelDatastore#isKindOf(Object, String)
	 */
	default Pipe<E, Boolean> isKindOf(String type) {
		return PipesUtils.pipeFor((el) -> this.isKindOf(el, type));
	}

}
