package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.gremlin.impl.GremlinScriptImpl;
import fr.inria.atlanmod.mogwai.query.MogwaiGremlinQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;

public class MogwaiGremlinProcessor extends AbstractMogwaiProcessor<MogwaiGremlinQuery> {

	private static final String NAME = "Gremlin Processor";

	public MogwaiGremlinProcessor() {
		super();
	}

	@Override
	public String getName() {
		return NAME;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public MogwaiQueryResult process(MogwaiGremlinQuery query, List<ModelDatastore> datastores,
			Map<String, Object> options) {
		checkArgument(!datastores.isEmpty(), "Cannot process the query: no datastore provided");
		return super.process(query, datastores, options);
	}

	@Override
	public boolean accept(MogwaiQuery query) {
		return !Objects.isNull(query) && query instanceof MogwaiGremlinQuery;
	}

	@Override
	protected GremlinScript createGremlinScript(MogwaiGremlinQuery query, Map<String, Object> options) {
		return new GremlinStringWrapper(query.getGremlinScript());
	}

}
