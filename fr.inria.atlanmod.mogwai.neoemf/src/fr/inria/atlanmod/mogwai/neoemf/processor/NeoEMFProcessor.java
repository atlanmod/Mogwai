package fr.inria.atlanmod.mogwai.neoemf.processor;

import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

/**
 * An interface containing the methods a processor has to implement to be
 * compatible with NeoEMF.
 * 
 * @author Gwendal DANIEL
 *
 */
public interface NeoEMFProcessor {

	/**
	 * Set the {@code backend} used to reify query results.
	 * 
	 * @param backend
	 *            the {@link BlueprintsPersistenceBackend} used to reify query
	 *            results
	 */
	void setBackend(BlueprintsPersistenceBackend backend);

}
