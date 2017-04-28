package fr.inria.atlanmod.mogwai.neoemf.processor;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.datastore.blueprints.NeoEMFGraphDatastore;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.processor.OCLQueryProcessor;
import fr.inria.atlanmod.mogwai.query.OCLQuery;
import fr.inria.atlanmod.mogwai.query.QueryResult;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

/**
 * A NeoEMF-specific {@link OCLQueryProcessor} that computes {@link OCLQuery} on
 * top of a NeoEMF resource.
 * <p>
 * This class implements {@link NeoEMFQueryProcessor} and returns
 * {@link NeoEMFQueryResult}s that can be reified as regular {@link EObject}s.
 * 
 * @see OCLQuery
 * @see OCLQueryProcessor
 * @see NeoEMFQueryProcessor
 * @see NeoEMFQueryResult
 * 
 * @author Gwendal DANIEL
 *
 */
public class NeoEMFOCLQueryProcessor extends OCLQueryProcessor implements NeoEMFQueryProcessor {

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
	 * 
	 * @throws IllegalArgumentException
	 *             if {@code datastore} is empty or contains more than one
	 *             datastore, and if the provided {@link ModelDatastore} is not
	 *             an instance of {@link NeoEMFGraphDatastore}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public QueryResult process(OCLQuery query, List<ModelDatastore> datastores, Map<String, Object> options) {
		checkArgument(datastores.size() == 1, "Cannot process the query: expected 1 datastore, found {0}",
				datastores.size());
		checkArgument(datastores.get(0) instanceof NeoEMFGraphDatastore,
				"Cannot process the query: expected NeoEMFGraphDatastore instance, found {0}", datastores.get(0)
						.getClass().getName());
		return super.process(query, datastores, options);
	}

	/**
	 * Adaptes the raw Gremlin engine result and wraps it in a reifiable
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
	 *            a {@link Map} containing execution options
	 * @return a {@link NeoEMFQueryResult} wrapping the output of the executed
	 *         {@code script} and allowing {@link EObject}s reification
	 * 
	 * @see NeoEMFQueryResult#reifyResults(fr.inria.atlanmod.neoemf.resource.PersistentResource)
	 * @see QueryResult
	 */
	@Override
	protected NeoEMFQueryResult adaptResult(Object result, GremlinScript gremlinScript, Map<String, Object> options) {
		return new NeoEMFQueryResult(result, backend, gremlinScript);
	}

}
