package fr.inria.atlanmod.mogwai.query.builder;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.processor.GremlinQueryProcessor;
import fr.inria.atlanmod.mogwai.query.GremlinQuery;

/**
 * A simple implementation of {@link AbstractMogwaiQueryBuilder} that allows to
 * create {@link GremlinQuery} instances.
 * <p>
 * This builder accepts all the input type of {@link AbstractMogwaiQueryBuilder}
 * (File, String, and URI).
 * <p>
 * The created {@link GremlinQuery} can be processed by a
 * {@link GremlinQueryProcessor} on top of any {@link ModelDatastore}
 * implementation.
 * 
 * @see GremlinQuery
 * @see GremlinQueryProcessor
 * 
 * @author Gwendal DANIEL
 *
 */
public class GremlinQueryBuilder extends AbstractMogwaiQueryBuilder<GremlinQueryBuilder> {

	/**
	 * Creates a new instance of this builder.
	 * <p>
	 * <b>Note:</b> this method is not public, use the static method
	 * {@link #newBuilder()} that allows to chain build operations instead.
	 */
	protected GremlinQueryBuilder() {

	}

	/**
	 * Creates a new instance of this builder that can be chained with build
	 * operations.
	 * 
	 * @return a new instance of this builder that can be chained with build
	 *         operations
	 */
	public static GremlinQueryBuilder newBuilder() {
		return new GremlinQueryBuilder();
	}

	/**
	 * Constructs a new {@link GremlinQuery} instance from the provided
	 * parameters.
	 * 
	 * @return the created {@link GremlinQuery}
	 */
	@Override
	protected GremlinQuery buildQuery() {
		return new GremlinQuery(input);
	}

}
