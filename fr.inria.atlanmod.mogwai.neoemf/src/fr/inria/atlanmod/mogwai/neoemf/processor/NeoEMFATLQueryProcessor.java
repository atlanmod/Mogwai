package fr.inria.atlanmod.mogwai.neoemf.processor;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

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

/**
 * An NeoEMF-specific {@link ATLQueryProcessor} that computes {@link ATLQuery}
 * on top of a NeoEMF resource.
 * <p>
 * This processor automatically sets default query execution options that are
 * optimized for the NeoEMF model mapping.
 * <p>
 * This class implements {@link NeoEMFQueryProcessor} and returns
 * {@link NeoEMFQueryResult}s that can be reified as regular {@link EObject}s
 * 
 * @see ATLQuery
 * @see ATLQueryProcessor
 * @see NeoEMFQueryProcessor
 * @see NeoEMFQueryResult
 * 
 * @author Gwendal DANIEL
 *
 */
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

	/**
	 * {@inheritDoc}
	 * 
	 * @return a {@link NeoEMFQueryResult} wrapping the output of the executed
	 *         {@code query} and allowing {@link EObject}s reification
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public NeoEMFQueryResult process(ATLQuery query, List<ModelDatastore> datastores, Map<String, Object> options) {
		if (!options.containsKey(TRANSFORMATION_HELPER_KEY)) {
			options.put(TRANSFORMATION_HELPER_KEY, new InPlaceBlueprintsTransformationHelper(
					(ModelDatastore<?, Vertex, Edge, ?>) datastores.get(0)));
		}
		/*
		 * We can safely cast here, the engine results are adapted by
		 * NeoEMFATLQueryProcessor#adaptResult, which returns a
		 * NeoEMFQueryResult.
		 */
		return (NeoEMFQueryResult) super.process(query, datastores, options);
	}

	/**
	 * Adapts the raw Gremlin engine result and wraps it in a reifiable
	 * {@link NeoEMFQueryResult}.
	 * <p>
	 * {@link NeoEMFQueryResult} can be reified to {@link EObject}s if the query
	 * returns graph elements corresponding to {@link EObject}s (see
	 * {@link NeoEMFQueryResult#reifyResults(fr.inria.atlanmod.neoemf.resource.PersistentResource)}
	 * ). Standard {@link QueryResult} methods can be used to access the raw
	 * query results.
	 * 
	 * @param result
	 *            the {@link Object} representing the output of the Gremlin
	 *            engine
	 * @param script
	 *            the computed {@link GremlinScript}
	 * @param options
	 *            {@link Map} containing execution options
	 * @return a {@link NeoEMFQueryResult} wrapping the output of the executed
	 *         {@code script} and allowing {@link EObject}s reification
	 * 
	 * @see NeoEMFQueryResult#reifyResults(fr.inria.atlanmod.neoemf.resource.PersistentResource)
	 * @see QueryResult
	 */
	@Override
	protected NeoEMFQueryResult adaptResult(Object result, GremlinScript script, Map<String, Object> options) {
		return new NeoEMFQueryResult(result, backend, script);
	}
}
