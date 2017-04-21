package fr.inria.atlanmod.mogwai.neoemf.processor;

import java.util.List;
import java.util.Map;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.processor.MogwaiATLProcessor;
import fr.inria.atlanmod.mogwai.query.MogwaiATLQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.util.TransformationHelper;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

public class NeoEMFATLProcessor extends MogwaiATLProcessor implements NeoEMFProcessor {

	/**
	 * The {@code backend} used to reify query results.
	 */
	private BlueprintsPersistenceBackend backend;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setBackend(BlueprintsPersistenceBackend backend) {
		this.backend = backend;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public MogwaiQueryResult process(MogwaiATLQuery query, List<ModelDatastore> datastores, Map<String, Object> options) {
		if (!options.containsKey(TRANSFORMATION_HELPER_KEY)) {
			options.put(TRANSFORMATION_HELPER_KEY, new TransformationHelper(datastores.get(0)));
		}
		return super.process(query, datastores, options);
	}

	@Override
	protected NeoEMFQueryResult adaptResult(Object result, GremlinScript gremlinScript, Map<String, Object> options) {
		return new NeoEMFQueryResult(result, backend, gremlinScript);
	}
}
