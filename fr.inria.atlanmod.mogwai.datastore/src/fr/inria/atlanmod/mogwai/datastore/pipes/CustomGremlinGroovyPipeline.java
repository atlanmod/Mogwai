package fr.inria.atlanmod.mogwai.datastore.pipes;

import java.util.Iterator;

import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline;

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
	 * 
	 * @param starts the input elements of the pipeline to create
	 */
	public CustomGremlinGroovyPipeline(final Object starts) {
		super(starts);
	}

	/**
	 * Constructs a new {@link CustomGremlinGroovyPipeline} containing the input
	 * {@code starts} elements from the provided {@code datastore} that can be used as a regular
	 * {@link GremlinGroovyPipeline} to create a traversal.
	 * <p>
	 * The created pipeline provides additional, model-related, operations that
	 * allows to access elements' attributes, references, and provides efficient
	 * implementations of modeling operations such as {@code oclIsUndefined()}
	 * and {@code toString()}.
	 * 
	 * @param starts the input elements of the pipeline to create
	 * @param datastore the {@link PipesDatastore} to use to access the model
	 */
	public CustomGremlinGroovyPipeline(final Object starts, PipesDatastore datastore) {
		super(starts);
		this.datastore = datastore;
	}

	public CustomGremlinGroovyPipeline<S, E> _() {
		return this;
	}

	public CustomGremlinGroovyPipeline<S, E> getAtt(String attName) {
		return (CustomGremlinGroovyPipeline<S, E>) this.add(datastore.getAtt(attName));
	}

	public CustomGremlinGroovyPipeline<S, E> getRef(String refName, String oppositeName, boolean isContainer) {
		return (CustomGremlinGroovyPipeline<S, E>) this.add(datastore.getRef(refName, oppositeName, isContainer));
	}

	public String getString() {
		Iterator<E> content = iterator();
		String value = content.next().toString();
		if (content.hasNext()) {
			throw new IllegalStateException("Calling toString on an Iterable that contain more than one element");
		}
		return value;
	}

	public boolean undefined() {
		Iterator<E> content = iterator();
		boolean result = true;
		if (content.hasNext()) {
			result = (content.next() == null);
		}
		return result;
	}

}
