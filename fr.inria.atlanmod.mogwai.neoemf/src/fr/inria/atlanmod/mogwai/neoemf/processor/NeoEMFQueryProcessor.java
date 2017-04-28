package fr.inria.atlanmod.mogwai.neoemf.processor;

import org.eclipse.emf.ecore.EObject;

import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

/**
 * An interface containing the methods a processor has to implement to be
 * compatible with NeoEMF.
 * <p>
 * This interface enables query result reification, allowing to retrieve
 * {@link EObject}s from a computed Mogwai query (see
 * {@link NeoEMFQueryResult#reifyResults(fr.inria.atlanmod.neoemf.resource.PersistentResource)}.
 * 
 * @see NeoEMFQueryResult#reifyResults(fr.inria.atlanmod.neoemf.resource.PersistentResource)
 * 
 * @author Gwendal DANIEL
 *
 */
public interface NeoEMFQueryProcessor {

	/**
	 * Set the {@code backend} used to reify query results.
	 * 
	 * @param backend
	 *            the {@link BlueprintsPersistenceBackend} used to reify query
	 *            results
	 */
	void setBackend(BlueprintsPersistenceBackend backend);

}
