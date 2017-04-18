package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import fr.inria.atlanmod.mogwai.query.MogwaiGremlinQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;

public class MogwaiGremlinProcessor<D> extends MogwaiProcessor<MogwaiGremlinQuery<D>, D> {

	private static final String NAME = "Gremlin Processor";
	
	public MogwaiGremlinProcessor() {
		super();
	}
	
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public MogwaiQueryResult internalProcess(MogwaiGremlinQuery<D> query, D datastore, Object arg) {
		checkNotNull(datastore, "Cannot compute a query without a graph");
		Object result = GremlinScriptRunner.getInstance().runGremlinScript(query.getGremlinScript(), arg, datastore, query.getBindings());
		return adaptResult(result, query.getGremlinScript());
	}

	@Override
	public boolean accept(MogwaiQuery<D> query) {
		return !Objects.isNull(query) && query instanceof MogwaiGremlinQuery;
	}
	
	@Override
	protected MogwaiQueryResult adaptResult(Object result, String gremlinQuery) {
		return new MogwaiQueryResult(result, gremlinQuery);
	}

}
