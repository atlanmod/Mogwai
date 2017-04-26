package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.query.GremlinQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.QueryResult;

/**
 * A simple processor that executes a {@link GremlinQuery}.
 * 
 * @see AbstractQueryProcessor
 * 
 * @author Gwendal DANIEL
 *
 */
public class GremlinQueryProcessor extends AbstractQueryProcessor<GremlinQuery> {

	/**
	 * The name of the processor.
	 */
	private static final String NAME = "Gremlin Processor";

	/**
	 * Constructs a new {@link GremlinQueryProcessor}.
	 */
	public GremlinQueryProcessor() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * 
	 * @throws IllegalArgumentException
	 *             if no datastore is provided
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public QueryResult process(GremlinQuery query, List<ModelDatastore> datastores, Map<String, Object> options) {
		checkArgument(!datastores.isEmpty(), "Cannot process the query: no datastore provided");
		return super.process(query, datastores, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return {@code true} if {@code query} is an instance of
	 *         {@link GremlinQuery}, {@code false} otherwise
	 */
	@Override
	public boolean accept(MogwaiQuery query) {
		return !Objects.isNull(query) && query instanceof GremlinQuery;
	}

	/**
	 * Wraps the provided textual {@link GremlinQuery} in a
	 * {@link GremlinStringWrapper}.
	 * 
	 * @param query
	 *            the input {@link GremlinQuery} to generate the
	 *            {@link GremlinScript} from
	 * @param options
	 *            a {@link Map} containing query translation options
	 */
	@Override
	protected GremlinScript createGremlinScript(GremlinQuery query, Map<String, Object> options) {
		return new GremlinStringWrapper(query.getInput());
	}

}
