package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.query.MogwaiGremlinQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiOCLQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

public class MogwaiGremlinProcessor extends MogwaiProcessor<MogwaiGremlinQuery> {

	private static final String NAME = "Gremlin Processor";
	
	private BlueprintsPersistenceBackend graphBackend;
	
	public MogwaiGremlinProcessor() {

	}
	
	public MogwaiGremlinProcessor(BlueprintsPersistenceBackend graphBackend) {
		this();
		checkNotNull(graphBackend, "Cannot instanciate a processor without a graph");
		this.graphBackend = graphBackend;
	}
	
	public void setGraphBackend(BlueprintsPersistenceBackend graphBackend) {
		this.graphBackend = graphBackend;
	}
	
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public MogwaiQueryResult internalProcess(MogwaiGremlinQuery query, Object arg) {
		checkNotNull(graphBackend, "Cannot compute a query without a graph");
		Object result = GremlinScriptRunner.getInstance().runGremlinScript(query.getGremlinScript(), arg, graphBackend);
		return adaptResult(result, query.getGremlinScript());
	}

	@Override
	public boolean accept(MogwaiQuery query) {
		return !Objects.isNull(query) && query instanceof MogwaiGremlinQuery;
	}
	
	private MogwaiQueryResult adaptResult(Object result, String gremlinQuery) {
		return new MogwaiQueryResult(result, graphBackend, gremlinQuery);
	}

}
