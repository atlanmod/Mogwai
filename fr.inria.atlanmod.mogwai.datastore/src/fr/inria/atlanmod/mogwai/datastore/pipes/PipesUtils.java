package fr.inria.atlanmod.mogwai.datastore.pipes;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

import com.google.common.collect.Iterables;
import com.tinkerpop.gremlin.java.GremlinStartPipe;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.PipeHelper;
import com.tinkerpop.pipes.util.Pipeline;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;

/**
 * An utility class that creates new {@link Pipeline}s from {@link Iterables},
 * and initialize {@link Pipe}s with a given {@link Function}.
 * <p>
 * This class is used by {@link PipesDatastore} to create Pipes' construct
 * wrapping the default {@link ModelDatastore} interface.
 * 
 * @author Gwendal DANIEL
 *
 */
public class PipesUtils {

	/**
	 * Creates a new {@link Pipeline} initialized with the provided
	 * {@code elements}.
	 * 
	 * @param elements
	 *            an {@link Iterable} containing the input elements of the
	 *            {@link Pipeline}
	 * @return the created {@link Pipeline} initialized with the provided
	 *         {@code elements}.
	 */
	public static <E> Pipeline<E, ?> pipelineOf(Iterable<E> elements) {
		Pipeline<E, ?> pipeline = new CustomGremlinGroovyPipeline<>(new GremlinStartPipe(elements));
		pipeline.setStarts(elements);
		return pipeline;
	}
	
	public static <E> Pipeline<E, ?> pipelineOf(Iterable<E> elements, PipesDatastore datastore) {
		Pipeline<E, ?> pipeline = new CustomGremlinGroovyPipeline<>(new GremlinStartPipe(elements), datastore);
		pipeline.setStarts(elements);
		return pipeline;
	}

	/**
	 * Creates a new {@link Pipe} computing the given {@code function} on its
	 * input elements.
	 * 
	 * @param function
	 *            the {@link Function} to compute on the {@link Pipe}'s input
	 *            elements
	 * @return the created {@link Pipe}
	 */
	public static <E1, E2> Pipe<E1, E2> pipeFor(Function<E1, E2> function) {
		return new AbstractPipe<E1, E2>() {

			@Override
			protected E2 processNextStart() throws NoSuchElementException {
				return function.apply(this.starts.next());
			}

		};
	}

	/**
	 * Creates a new {@link Pipe} computing the given {@code function} on its
	 * input element.
	 * <p>
	 * The created {@link Pipe} flattens output when {@code function} is applied
	 * on multiple inputs.
	 * 
	 * @param function
	 *            the {@link Function} to compute on the {@link Pipe}'s input
	 *            elements
	 * @return the created {@link Pipe}
	 */
	public static <E1, E2> Pipe<E1, E2> flattenPipeFor(Function<E1, Iterable<E2>> function) {
		return new AbstractPipe<E1, E2>() {

			private Iterator<E2> nextRefs = PipeHelper.emptyIterator();

			@Override
			protected E2 processNextStart() throws NoSuchElementException {
				while (true) {
					if (this.nextRefs.hasNext()) {
						return this.nextRefs.next();
					} else {
						this.nextRefs = function.apply(this.starts.next()).iterator();
					}
				}
			}
		};
	}

}
