package fr.inria.atlanmod.mogwai.mapping;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline;
import com.tinkerpop.gremlin.java.GremlinStartPipe;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.PipeHelper;
import com.tinkerpop.pipes.util.Pipeline;

/**
 * An implementation of {@link EMFtoGraphMapping} that defines all
 * {@link Pipeline} and {@link Pipe} related methods as wrapper of existing
 * methods.
 * <p>
 * This class can be extended by concrete mappings to provide the logic of the
 * mapping, avoiding the definition of Gremlin related concepts such as
 * {@link Pipe}s. Note that it is still possible to redifine {@link Pipe}
 * related methods to provide additional behavior within a traversal.
 * 
 * @see EMFtoGraphMapping
 * 
 * @author Gwendal DANIEL
 *
 */
public abstract class AbstractMapping implements EMFtoGraphMapping {

	protected Graph graph;

	@Override
	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	@Override
	public abstract Iterable<Vertex> allOfType(String typeName);

	/**
	 * {@inheritDoc}
	 * <p>
	 * This method uses {@link #allOfType(String)} to initialize the created
	 * {@link Pipeline}.
	 */
	@Override
	public Pipeline<Vertex, ?> allOfTypePipeline(String typeName) {
		return pipelineOf(allOfType(typeName));
	}

	@Override
	public abstract Iterable<Vertex> allOfKind(String typeName);

	/**
	 * {@inheritDoc}
	 * <p>
	 * This method uses {@link #allOfKind(String)} to initialize the created
	 * {@link Pipeline}.
	 */
	@Override
	public Pipeline<Vertex, ?> allOfKindPipeline(String typeName) {
		return pipelineOf(allOfKind(typeName));
	}

	@Override
	public abstract Object newInstance(String typeName, String typePackageNsURI);

	@Override
	public abstract Iterable<Vertex> getRef(Vertex from, String refName);

	/**
	 * {@inheritDoc}
	 * <p>
	 * The created {@link Pipe} uses {@link #getRef(Vertex, String)} to retrieve
	 * the {@link Vertex} elements associated to its input elements.
	 */
	@Override
	public Pipe<Vertex, Vertex> getRef(final String refName) {
		return new AbstractPipe<Vertex, Vertex>() {

			private Iterator<Vertex> nextRefs = PipeHelper.emptyIterator();

			@Override
			protected Vertex processNextStart() throws NoSuchElementException {
				while (true) {
					if (this.nextRefs.hasNext()) {
						return this.nextRefs.next();
					} else {
						this.nextRefs = getRef(this.starts.next(), refName).iterator();
					}
				}
			}
		};
	}

	@Override
	public abstract Edge setRef(Vertex from, String refName, Vertex to);

	/**
	 * {@inheritDoc}
	 * <p>
	 * The created {@link Pipe} uses {@link #setRef(Vertex, String, Vertex)} to
	 * set the reference between its input elements and {@code to}.
	 */
	@Override
	public Pipe<Vertex, Edge> setRef(final String refName, final Vertex to) {
		return new AbstractPipe<Vertex, Edge>() {

			@Override
			protected Edge processNextStart() throws NoSuchElementException {
				return setRef(this.starts.next(), refName, to);
			}
		};
	}

	@Override
	public abstract Object getAtt(Vertex from, String attName);

	/**
	 * {@inheritDoc}
	 * <p>
	 * The created {@link Pipe} uses {@link #getAtt(String)} to retrieve the
	 * attribute(s) associated to its input elements.
	 */
	@Override
	public Pipe<Vertex, Object> getAtt(final String attName) {
		return new AbstractPipe<Vertex, Object>() {

			@Override
			protected Object processNextStart() throws NoSuchElementException {
				return getAtt(this.starts.next(), attName);
			}
		};
	}

	@Override
	public abstract Vertex setAtt(Vertex from, String attName, Object attValue);

	/**
	 * {@inheritDoc}
	 * <p>
	 * The created {@link Pipe} uses {@link #setAtt(Vertex, String, Object)} to
	 * set the attribute of its input elements.
	 */
	@Override
	public Pipe<Vertex, Vertex> setAtt(final String attName, final Object attValue) {
		return new AbstractPipe<Vertex, Vertex>() {

			@Override
			protected Vertex processNextStart() throws NoSuchElementException {
				return setAtt(this.starts.next(), attName, attValue);
			}
		};
	}

	@Override
	public abstract String getType(Vertex from);

	/**
	 * {@inheritDoc}
	 * <p>
	 * The created {@link Pipe} uses {@link #getType(Vertex)} to retrieve the
	 * type of its input elements.
	 */
	@Override
	public Pipe<Vertex, String> getType() {
		return new AbstractPipe<Vertex, String>() {

			@Override
			protected String processNextStart() throws NoSuchElementException {
				return getType(this.starts.next());
			}
		};
	}

	@Override
	public abstract boolean isTypeOf(Vertex from, String type);

	/**
	 * {@inheritDoc}
	 * <p>
	 * The created {@link Pipe} uses {@link #isTypeOf(Vertex, String)} to
	 * compute whether its input elements are instances of {@code type}.
	 */
	@Override
	public Pipe<Vertex, Boolean> isTypeOf(final String type) {
		return new AbstractPipe<Vertex, Boolean>() {

			@Override
			protected Boolean processNextStart() throws NoSuchElementException {
				return isTypeOf(this.starts.next(), type);
			}
		};
	}

	@Override
	public abstract boolean isKindOf(Vertex from, String type);

	/**
	 * {@inheritDoc}
	 * <p>
	 * The created {@link Pipe} uses {@link #isKindOf(Vertex, String)} to
	 * compute whether its input elements are instances of {@code type} or one
	 * of its subclasses.
	 */
	@Override
	public Pipe<Vertex, Boolean> isKindOf(final String type) {
		return new AbstractPipe<Vertex, Boolean>() {

			@Override
			protected Boolean processNextStart() throws NoSuchElementException {
				return isKindOf(this.starts.next(), type);
			}
		};
	}

	/**
	 * Creates a {@link Pipeline} an sets its start elements to {@code elements}
	 * .
	 * 
	 * @param elements
	 *            the elements starting the {@link Pipeline}
	 * @return the create {@link Pipeline} initialized with the given
	 *         {@code elements}
	 */
	protected Pipeline<Vertex, ?> pipelineOf(Iterable<Vertex> elements) {
		Pipeline<Vertex, ?> pipeline = new GremlinGroovyPipeline<>(new GremlinStartPipe(elements));
		pipeline.setStarts(elements);
		return pipeline;
	}

}
