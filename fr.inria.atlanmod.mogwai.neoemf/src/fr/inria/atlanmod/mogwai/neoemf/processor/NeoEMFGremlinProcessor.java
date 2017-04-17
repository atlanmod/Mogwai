package fr.inria.atlanmod.mogwai.neoemf.processor;

import static com.google.common.base.Preconditions.checkNotNull;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.processor.GremlinScriptRunner;
import fr.inria.atlanmod.mogwai.processor.MogwaiGremlinProcessor;
import fr.inria.atlanmod.mogwai.query.MogwaiGremlinQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

public class NeoEMFGremlinProcessor extends MogwaiGremlinProcessor<BlueprintsPersistenceBackend> {

	@Override
	public NeoEMFQueryResult internalProcess(MogwaiGremlinQuery query, BlueprintsPersistenceBackend datastore, Object arg) {
		checkNotNull(datastore, "Cannot compute a query without a graph");
		Object result = GremlinScriptRunner.getInstance().runGremlinScript(query.getGremlinScript(), arg, datastore.getGraph(), query.getBindings());
		return adaptResult(result, query.getGremlinScript());
	}
	
	@Override
	protected NeoEMFQueryResult adaptResult(Object result, String gremlinQuery) {
		return new NeoEMFQueryResult(result, lastDatastore, gremlinQuery);
	}

}
