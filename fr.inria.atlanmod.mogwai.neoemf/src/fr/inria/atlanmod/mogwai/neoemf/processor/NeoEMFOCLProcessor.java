package fr.inria.atlanmod.mogwai.neoemf.processor;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.Map;

import com.tinkerpop.blueprints.Graph;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.datastore.blueprints.NeoEMFGraphDatastore;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.processor.MogwaiOCLProcessor;
import fr.inria.atlanmod.mogwai.query.MogwaiOCLQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

public class NeoEMFOCLProcessor extends MogwaiOCLProcessor<Graph> implements NeoEMFProcessor {

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
	public MogwaiQueryResult process(MogwaiOCLQuery query, List<Graph> datastores,
			List<ModelDatastore> mappings, Map<String, Object> options) {
		checkArgument(datastores.size() == 1, "Cannot process the query: expected 1 datastore, found {0}",
				datastores.size());
		checkArgument(mappings.size() == 1, "Cannot process the query: expected 1 mapping, found {0}", mappings.size());
		checkArgument(mappings.get(0) instanceof NeoEMFGraphDatastore,
				"Cannot process the query: expected NeoEMFMapping instance, found {0}", mappings.get(0).getClass()
						.getName());
		return super.process(query, datastores, mappings, options);
	}
	
	@Override
	protected NeoEMFQueryResult adaptResult(Object result, String gremlinScript, Map<String, Object> options) {
		return new NeoEMFQueryResult(result, backend, gremlinScript);
	}

}
