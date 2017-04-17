package fr.inria.atlanmod.mogwai.neoemf.processor;

import static com.google.common.base.Preconditions.checkNotNull;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.processor.GremlinScriptRunner;
import fr.inria.atlanmod.mogwai.processor.MogwaiOCLProcessor;
import fr.inria.atlanmod.mogwai.query.MogwaiOCLQuery;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

public class NeoEMFOCLProcessor extends MogwaiOCLProcessor<BlueprintsPersistenceBackend> {

	@Override
	public NeoEMFQueryResult internalProcess(MogwaiOCLQuery<BlueprintsPersistenceBackend> query,
			BlueprintsPersistenceBackend datastore, Object arg) {
		checkNotNull(datastore, "Cannot compute a query without a graph");
		GremlinScript gScript = createGremlinScript(query);
		Object result = GremlinScriptRunner.getInstance().runGremlinScript(gScript, arg, datastore.getGraph(), null);
		return adaptResult(result, gScript.toString());
	}
	
	@Override
	protected NeoEMFQueryResult adaptResult(Object result, String gremlinQuery) {
		return new NeoEMFQueryResult(result, lastDatastore, gremlinQuery);
	}
	
}
