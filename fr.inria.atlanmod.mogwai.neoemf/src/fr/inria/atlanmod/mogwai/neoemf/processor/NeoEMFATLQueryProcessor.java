package fr.inria.atlanmod.mogwai.neoemf.processor;

import java.util.List;
import java.util.Map;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.processor.ATLQueryProcessor;
import fr.inria.atlanmod.mogwai.query.ATLQuery;
import fr.inria.atlanmod.mogwai.query.QueryResult;
import fr.inria.atlanmod.mogwai.transformation.atl.helper.blueprints.InPlaceBlueprintsTransformationHelper;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

public class NeoEMFATLQueryProcessor extends ATLQueryProcessor implements NeoEMFQueryProcessor {

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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public QueryResult process(ATLQuery query, List<ModelDatastore> datastores, Map<String, Object> options) {
		if (!options.containsKey(TRANSFORMATION_HELPER_KEY)) {
			options.put(TRANSFORMATION_HELPER_KEY, new InPlaceBlueprintsTransformationHelper(
					(ModelDatastore<?, Vertex, Edge, ?>) datastores.get(0)));
		}
		return super.process(query, datastores, options);
	}

	@Override
	protected NeoEMFQueryResult adaptResult(Object result, GremlinScript gremlinScript, Map<String, Object> options) {
		return new NeoEMFQueryResult(result, backend, gremlinScript);
	}
}
