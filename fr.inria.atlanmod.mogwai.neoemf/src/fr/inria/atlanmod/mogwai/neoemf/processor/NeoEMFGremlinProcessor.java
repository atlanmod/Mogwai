package fr.inria.atlanmod.mogwai.neoemf.processor;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.Map;

import com.tinkerpop.blueprints.Graph;

import fr.inria.atlanmod.mogwai.data.mapping.ModelMapping;
import fr.inria.atlanmod.mogwai.data.mapping.blueprints.NeoEMFMapping;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.processor.MogwaiGremlinProcessor;
import fr.inria.atlanmod.mogwai.query.MogwaiGremlinQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.util.TransformationHelper;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

public class NeoEMFGremlinProcessor extends MogwaiGremlinProcessor<Graph> implements NeoEMFProcessor {

	/**
	 * The {@code backend} used to reify query results.
	 */
	private BlueprintsPersistenceBackend backend;
	
	/**
	 * {@inheritDoc}
	 * @param backend
	 */
	@Override
	public void setBackend(BlueprintsPersistenceBackend backend) {
		this.backend = backend;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public MogwaiQueryResult process(MogwaiGremlinQuery query, List<Graph> datastores,
			List<ModelMapping> mappings, Map<String, Object> options) {
		checkArgument(datastores.size() == 1, "Cannot process the query: expected 1 datastore, found {0}",
				datastores.size());
		checkArgument(mappings.size() == 1, "Cannot process the query: expected 1 mapping, found {0}", mappings.size());
		checkArgument(mappings.get(0) instanceof NeoEMFMapping,
				"Cannot process the query: expected NeoEMFMapping instance, found {0}", mappings.get(0).getClass()
						.getName());
		return super.process(query, datastores, mappings, options);
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Map<String, Object> createDefaultBindings(List<Graph> datastores,
			List<ModelMapping> mappings) {
		Map<String, Object> bindings = super.createDefaultBindings(datastores, mappings);
		/*
		 *  This should be removed: a part of the TransformationHelper API is needed by all the 
		 *  implementations (in the init Gremlin script).
		 *  We have to externalize it and use it when the init script is run
		 *  (we only need union / intersection / difference in the init phase)
		 *  The TransformationHelper itself should be a parameter for ATL transformations only
		 */
		bindings.put("graphHelper", new TransformationHelper(mappings.get(0)));
		return bindings;
	}

	@Override
	protected NeoEMFQueryResult adaptResult(Object result, String gremlinScript, Map<String, Object> options) {
		return new NeoEMFQueryResult(result, backend, gremlinScript);
	}

}
