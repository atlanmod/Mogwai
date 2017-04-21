package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.query.MogwaiGremlinQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;

public class MogwaiGremlinProcessor<D> extends MogwaiProcessor<MogwaiGremlinQuery, D> {

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
	public MogwaiQueryResult process(MogwaiGremlinQuery query, List<D> datastores, List<ModelDatastore> mappings,
			Map<String, Object> options) {
		checkArgument(!datastores.isEmpty(), "Cannot process the query: no datastore provided");
		checkArgument(!mappings.isEmpty(), "Cannot process the query: no mapping provided");
		return super.process(query, datastores, mappings, options);
	}

	@Override
	public boolean accept(MogwaiQuery query) {
		return !Objects.isNull(query) && query instanceof MogwaiGremlinQuery;
	}

	@Override
	protected String createGremlinScript(MogwaiGremlinQuery query, Map<String, Object> options) {
		return query.getGremlinScript();
	}

}
