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

public class GremlinQueryProcessor extends AbstractQueryProcessor<GremlinQuery> {

	private static final String NAME = "Gremlin Processor";

	public GremlinQueryProcessor() {
		super();
	}

	@Override
	public String getName() {
		return NAME;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public QueryResult process(GremlinQuery query, List<ModelDatastore> datastores,
			Map<String, Object> options) {
		checkArgument(!datastores.isEmpty(), "Cannot process the query: no datastore provided");
		return super.process(query, datastores, options);
	}

	@Override
	public boolean accept(MogwaiQuery query) {
		return !Objects.isNull(query) && query instanceof GremlinQuery;
	}

	@Override
	protected GremlinScript createGremlinScript(GremlinQuery query, Map<String, Object> options) {
		return new GremlinStringWrapper(query.getGremlinScript());
	}

}
