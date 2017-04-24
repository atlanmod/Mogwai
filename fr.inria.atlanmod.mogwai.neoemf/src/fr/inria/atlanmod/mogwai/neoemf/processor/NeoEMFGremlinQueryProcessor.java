package fr.inria.atlanmod.mogwai.neoemf.processor;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.Map;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.datastore.blueprints.NeoEMFGraphDatastore;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.processor.GremlinQueryProcessor;
import fr.inria.atlanmod.mogwai.query.GremlinQuery;
import fr.inria.atlanmod.mogwai.query.QueryResult;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

public class NeoEMFGremlinQueryProcessor extends GremlinQueryProcessor implements NeoEMFQueryProcessor {

	/**
	 * The {@code backend} used to reify query results.
	 */
	private BlueprintsPersistenceBackend backend;

	/**
	 * {@inheritDoc}
	 * 
	 * @param backend
	 *            the {@link BlueprintsPersistenceBackend} used to reify the
	 *            results
	 */
	@Override
	public void setBackend(BlueprintsPersistenceBackend backend) {
		this.backend = backend;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public QueryResult process(GremlinQuery query, List<ModelDatastore> datastores, Map<String, Object> options) {
		checkArgument(datastores.size() == 1, "Cannot process the query: expected 1 datastore, found {0}",
				datastores.size());
		checkArgument(datastores.get(0) instanceof NeoEMFGraphDatastore,
				"Cannot process the query: expected NeoEMFGraphDatastore instance, found {0}", datastores.get(0)
						.getClass().getName());
		return super.process(query, datastores, options);
	}

	@Override
	protected NeoEMFQueryResult adaptResult(Object result, GremlinScript gremlinScript, Map<String, Object> options) {
		return new NeoEMFQueryResult(result, backend, gremlinScript);
	}

}
