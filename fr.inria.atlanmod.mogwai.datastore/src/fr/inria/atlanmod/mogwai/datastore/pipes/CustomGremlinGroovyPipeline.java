package fr.inria.atlanmod.mogwai.datastore.pipes;

import java.util.Iterator;

import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline;
import com.tinkerpop.pipes.IdentityPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.transform.TransformPipe;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;

/**
 * An implementation of {@link GremlinGroovyPipeline} that provides additional
 * utility methods to navigate a model.
 * <p>
 * This class relies on an internal {@link PipesDatastore} that is used to
 * compute model-level operations. Utility methods retrieve (i) pipe-based
 * methods that create a new {@link Pipe} and append it in the current pipeline,
 * and (ii) utility method that compute a value from the entire pipeline and
 * return it. The formers return an instance of the current pipeline that can be
 * extended with additional Gremlin steps, while the later ends the traversal
 * (typically by iterating its content), and return the computed value.
 * <p>
 * <b>Note:</b> some methods are provided for performance (Groovy vs. Java) and
 * historical (existing translations) reasons, however, their semantic is often
 * not clear and may be changed in the future. These concerns are discussed in
 * the following project's issues:
 * <ul>
 * <li>https://github.com/atlanmod/Mogwai/issues/36</li>
 * <li>https://github.com/atlanmod/Mogwai/issues/37</li>
 * </ul>
 * 
 * @author Gwendal DANIEL
 *
 * @param <S>
 *            the type of the elements that start the pipeline
 * @param <E>
 *            the type of the elements that end the pipeline
 */
public class CustomGremlinGroovyPipeline<S, E> extends GremlinGroovyPipeline<S, E> {

	/**
	 * The underlying {@link PipesDatastore} used to access the data-store
	 */
	private PipesDatastore datastore;

	/**
	 * Constructs a new {@link CustomGremlinGroovyPipeline} that can be used as
	 * a regular {@link GremlinGroovyPipeline} to create a traversal.
	 * <p>
	 * The created pipeline provides additional, model-related, operations that
	 * allows to access elements' attributes, references, and provides efficient
	 * implementations of modeling operations such as {@code oclIsUndefined()}
	 * and {@code toString()}.
	 * <p>
	 * TODO: check if this constructor is needed (see
	 * https://github.com/atlanmod/Mogwai/issues/35)
	 */
	public CustomGremlinGroovyPipeline() {
		super();
	}

	/**
	 * Constructs a new {@link CustomGremlinGroovyPipeline} containing the input
	 * {@code starts} elements that can be used as a regular
	 * {@link GremlinGroovyPipeline} to create a traversal.
	 * <p>
	 * The created pipeline provides additional, model-related, operations that
	 * allows to access elements' attributes, references, and provides efficient
	 * implementations of modeling operations such as {@code oclIsUndefined()}
	 * and {@code toString()}.
	 * <p>
	 * TODO: check if this constructor is needed (see
	 * https://github.com/atlanmod/Mogwai/issues/35)
	 * 
	 * @param starts
	 *            the input elements of the pipeline to create
	 */
	public CustomGremlinGroovyPipeline(final Object starts) {
		super(starts);
	}

	/**
	 * Constructs a new {@link CustomGremlinGroovyPipeline} containing the input
	 * {@code starts} elements from the provided {@code datastore} that can be
	 * used as a regular {@link GremlinGroovyPipeline} to create a traversal.
	 * <p>
	 * The created pipeline provides additional, model-related, operations that
	 * allows to access elements' attributes, references, and provides efficient
	 * implementations of modeling operations such as {@code oclIsUndefined()}
	 * and {@code toString()}.
	 * 
	 * @param starts
	 *            the input elements of the pipeline to create
	 * @param datastore
	 *            the {@link PipesDatastore} to use to access the model
	 */
	public CustomGremlinGroovyPipeline(final Object starts, PipesDatastore datastore) {
		super(starts);
		this.datastore = datastore;
	}

	/**
	 * A dedicated implementation of the Gremlin {@link IdentityPipe} that
	 * returns an instance of {@link CustomGremlinGroovyPipeline}.
	 * <p>
	 * This method allows to chain identity steps with model-specific methods
	 * such as {@code getAtt} and {@code getRef}.
	 */
	public CustomGremlinGroovyPipeline<S, E> _() {
		return this;
	}

	/**
	 * Allows to chain a new {@link Pipe} in the pipeline that accesses the
	 * attribute {@code attName} of its input model elements.
	 * <p>
	 * The {@link Pipe} that accesses the elements' attributes is created by
	 * using the {@link PipesDatastore} associated to the current
	 * {@link CustomGremlinGroovyPipeline}.
	 * <p>
	 * TODO: this method may return a NullPointerException if no
	 * {@link PipesDatastore} are associated to the current
	 * {@link CustomGremlinGroovyPipeline} (see
	 * https://github.com/atlanmod/Mogwai/issues/35)
	 * 
	 * @param attName
	 *            the name of the elements' attribute to access
	 * @return the {@link CustomGremlinGroovyPipeline} containing an additional
	 *         pipe that accesses the attributes {@code attName} of its input
	 *         elements
	 * 
	 * @see PipesDatastore#getAtt(String)
	 */
	public CustomGremlinGroovyPipeline<S, E> getAtt(String attName) {
		return (CustomGremlinGroovyPipeline<S, E>) this.add(datastore.getAtt(attName));
	}

	/**
	 * Allows to chain a new {@link Pipe} in the pipeline that navigates the
	 * reference labeled {@code refName} of its input model elements.
	 * <p>
	 * The {@link Pipe} that navigates the elements' references is created by
	 * using the {@link PipesDatastore} associated to the current
	 * {@link CustomGremlinGroovyPipeline}.
	 * <p>
	 * <b>Note</b>: the method can also check if the reference is a
	 * {@code containment} reference, and if it's opposite is labeled
	 * {@code oppositeName} before navigating it. These specific checks are
	 * documented in the concrete {@link ModelDatastore} implementations used to
	 * access the model.
	 * <p>
	 * TODO: this method may return a NullPointerException if no
	 * {@link PipesDatastore} are associated to the current
	 * {@link CustomGremlinGroovyPipeline} (see
	 * https://github.com/atlanmod/Mogwai/issues/35)
	 * 
	 * @param refName
	 *            the name of the reference to navigate
	 * @param oppositeName
	 *            the name of the reference's opposite if it exists
	 * @param isContainer
	 *            {@code true} if {@code refName} is a containment,
	 *            {@code false} otherwise
	 * @return the {@link CustomGremlinGroovyPipeline} containing an additional
	 *         pipe that accesses the reference labeled {@code refName} of its
	 *         input elements.
	 * 
	 * @see PipesDatastore#getRef(String, String, boolean)
	 */
	public CustomGremlinGroovyPipeline<S, E> getRef(String refName, String oppositeName, boolean isContainer) {
		return (CustomGremlinGroovyPipeline<S, E>) this.add(datastore.getRef(refName, oppositeName, isContainer));
	}

	/**
	 * Provides a pretty printing operation that can be called on a
	 * {@link CustomGremlinGroovyPipeline}.
	 * <p>
	 * This method calls the {@code toString()} method of the pipeline's content
	 * and returns it as a {@link String}.
	 * <p>
	 * <b>Note</b>: this method does not return the current instance of the
	 * {@link CustomGremlinGroovyPipeline}, and therefore it cannot be chained
	 * with other pipes. You can create a {@link TransformPipe} and append it in
	 * the pipeline to perform this kind of transformation.
	 * 
	 * @return the {@link String} representation of the pipeline's results
	 * 
	 * @throws IllegalStateException
	 *             if the current {@link CustomGremlinGroovyPipeline} contains
	 *             more than one element (see
	 *             https://github.com/atlanmod/Mogwai/issues/36)
	 */
	public String getString() {
		Iterator<E> content = iterator();
		String value = content.next().toString();
		if (content.hasNext()) {
			throw new IllegalStateException("Calling toString on an Iterable that contain more than one element");
		}
		return value;
	}

	/**
	 * Checks if the content of the current {@link CustomGremlinGroovyPipeline}
	 * is undefined (according to the OCL specification).
	 * <p>
	 * The current implementation of the OCL undefined operation simply compares
	 * the pipeline's value against {@code null}. If the pipeline does not
	 * contain any element then its content is considered {@code undefined}.
	 * <p>
	 * <b>Note</b>: this method does not return the current instance of the
	 * {@link CustomGremlinGroovyPipeline}, and therefore it cannot be chained
	 * with other pipes. You can create a {@link TransformPipe} and append it in
	 * the pipeline to perform this kind of operation.
	 * <p>
	 * <b>Note:</b>: this method only checks whether the first element of the
	 * pipeline (if any) is undefined (see
	 * https://github.com/atlanmod/Mogwai/issues/37).
	 * 
	 * @return {@code true} if the content of the current
	 *         {@link CustomGremlinGroovyPipeline} is undefined, {@code false}
	 *         otherwise
	 */
	public boolean undefined() {
		Iterator<E> content = iterator();
		boolean result = true;
		if (content.hasNext()) {
			result = (content.next() == null);
		}
		return result;
	}

}
