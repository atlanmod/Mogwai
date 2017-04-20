/*******************************************************************************
 * Copyright (c) 2013 Atlanmod INRIA LINA Mines Nantes
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Atlanmod INRIA LINA Mines Nantes - initial API and implementation
 *******************************************************************************/
package fr.inria.atlanmod.mogwai.neoemf.resource;

import java.util.HashMap;
import java.util.Map;

import fr.inria.atlanmod.mogwai.data.mapping.ModelMapping;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryException;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;

/**
 * Extends the {@link PersistentResource} interface with Mogwai query
 * capabilities.
 * <p>
 * The provided API allows to query and transform a {@link PersistentResource}
 * using {@link MogwaiQuery} objects.
 * 
 * @author Gwendal DANIEL
 *
 */
public interface MogwaiResource extends PersistentResource {

	/**
	 * Computes the provided {@code transformation} with the given
	 * {@code options}.
	 * <p>
	 * The provided {@code transformation} is computed in-place, meaning that
	 * the underlying database storing the NeoEMF resource is directly updated
	 * with the result of the transformation. To compute a transformation that
	 * stores its output in another datastore see 
	 * {@link #transform(MogwaiQuery, Object, ModelMapping, Map)}.
	 * 
	 * @param transformation
	 *            the {@link MogwaiQuery} representing the transformation to
	 *            compute
	 * @param options
	 *            the execution options used to parameterize the underlying
	 *            engine
	 * @return a {@link NeoEMFQueryResult} representing the result of the
	 *         transformation execution
	 * @throws MogwaiQueryException
	 *             if the resource is not able to compute the provided
	 *             {@code query}
	 * 
	 * @see #transform(MogwaiQuery, Object, ModelMapping, Map)
	 */
	NeoEMFQueryResult transform(MogwaiQuery transformation, Map<String, Object> options) throws MogwaiQueryException;

	/**
	 * Computes the provided {@code transformation} with the provided
	 * {@code options} and stores its output in the given {@code datastore}
	 * according to the given {@code mapping}.
	 * <p>
	 * The provided {@code transformation} is stored in the provided
	 * {@code datastore}, meaning that the underlying database storing the
	 * NeoEMF resource is not updated with the result of the transformation. To
	 * compute a transformation in-place see
	 * {@link #transform(MogwaiQuery, Map)}.
	 * 
	 * @param transformation
	 *            the {@link MogwaiQuery} representing the transformation to
	 *            compute
	 * @param datastore
	 *            the datastore containing the ouptut of the transformation
	 * @param mapping
	 *            the {@link ModelMapping} used to access the ouput
	 *            {@code datastore}
	 * @param options
	 *            the execution options used to parameterize the underlying
	 *            engine
	 * @return a {@link NeoEMFQueryResult} representing the result of the
	 *         transformation execution
	 * @throws MogwaiQueryException
	 *             if the resource is not able to compute the provided
	 *             {@code query}
	 * 
	 * @see #transform(MogwaiQuery, Map)
	 */
	@SuppressWarnings("rawtypes")
	<D> NeoEMFQueryResult transform(MogwaiQuery transformation, D datastore, ModelMapping mapping,
			Map<String, Object> options) throws MogwaiQueryException;

	/**
	 * Computes the provided {@code query}.
	 * <p>
	 * This method is a convenience wrapper for
	 * {@code query(query, null, new HashMap<>())}.
	 * 
	 * @param query
	 *            the {@link MogwaiQuery} to compute
	 * @return a {@link NeoEMFQueryResult} representing the result of the query
	 *         execution
	 * @throws MogwaiQueryException
	 *             if the resource is not able to compute the provided
	 *             {@code query}
	 * 
	 * @see #query(MogwaiQuery, Object, Map)
	 */
	default NeoEMFQueryResult query(MogwaiQuery query) throws MogwaiQueryException {
		return this.query(query, null, new HashMap<>());
	}

	/**
	 * Computes the provided {@code query} with the given {@code parameters}.
	 * <p>
	 * This method is a convenience wrapper for
	 * {@code query(query, parameters, new HashMap<>())}.
	 * 
	 * @param query
	 *            the {@link MogwaiQuery} to compute
	 * @param parameters
	 *            the values to bind to the query parameters
	 * @return a {@link NeoEMFQueryResult} representing the result of the query
	 *         execution
	 * @throws MogwaiQueryException
	 *             if the resource is not able to compute the provided
	 *             {@code query}
	 * 
	 * @see #query(MogwaiQuery, Object, Map)
	 */
	default NeoEMFQueryResult query(MogwaiQuery query, Object parameters) throws MogwaiQueryException {
		return this.query(query, parameters, new HashMap<>());
	}

	/**
	 * Computes the provided {@code query} with the given {@code options}.
	 * <p>
	 * This method is a convenience wrapper for
	 * {@code query(query, null, options)}.
	 * 
	 * @param query
	 *            the {@link MogwaiQuery} to compute
	 * @param options
	 *            the execution options used to parameterize the underlying
	 *            engine
	 * @return a {@link NeoEMFQueryResult} representing the result of the query
	 *         execution
	 * @throws MogwaiQueryException
	 *             if the resource is not able to compute the provided
	 *             {@code query}
	 * 
	 * @see #query(MogwaiQuery, Object, Map)
	 */
	default NeoEMFQueryResult query(MogwaiQuery query, Map<String, Object> options) throws MogwaiQueryException {
		return this.query(query, null, options);
	}

	/**
	 * Computes the provided {@code query} with the given input
	 * {@code parameters} and {@code options}.
	 * 
	 * @param query
	 *            the {@link MogwaiQuery} to compute
	 * @param parameters
	 *            the values to bind to the query parameters
	 * @param options
	 *            the execution options used to parameterize the underlying
	 *            engine
	 * @return a {@link NeoEMFQueryResult} representing the result of the query
	 *         execution
	 * @throws MogwaiQueryException
	 *             if the resource is not able to compute the provided
	 *             {@code query}
	 */
	NeoEMFQueryResult query(MogwaiQuery query, Object parameters, Map<String, Object> options)
			throws MogwaiQueryException;

	/**
	 * Convenient method for development purpose, should not be used to modify
	 * the underlying backend directly
	 * 
	 * @return the backend held by the {@link MogwaiResource}
	 */
	public BlueprintsPersistenceBackend getBackend();

}
