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

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.neoemf.util.NeoEMFQueryHandler;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryException;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.DefaultPersistentResource;

public class DefaultMogwaiResource extends DefaultPersistentResource implements MogwaiResource {

	/**
	 * Returns true if an EMF resource can be used by Mogwaï
	 * 
	 * @param resource
	 *            the resource to check
	 * @return true if the resource can be used by Mogwaï, false otherwise
	 */
	public static boolean isMogwaiCompatible(Resource resource) {
		return (resource instanceof MogwaiResource) || resource.getURI().scheme().equals(BlueprintsURI.SCHEME);
	}

	public DefaultMogwaiResource(URI uri) {
		super(uri);
		assert this.backend instanceof BlueprintsPersistenceBackend;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NeoEMFQueryResult transform(MogwaiQuery transformation, Map<String, Object> options) {
		return NeoEMFQueryHandler.getInstance().transform(transformation, getBackend(), options);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public <D> NeoEMFQueryResult transform(MogwaiQuery transformation, D datastore, ModelDatastore mapping,
			Map<String, Object> options) {
		throw new MogwaiQueryException("Multi-backend transformations are not supported for the moment");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NeoEMFQueryResult query(MogwaiQuery query, Object arg, Map<String, Object> options) {
		return NeoEMFQueryHandler.getInstance().query(query, arg, getBackend(), options);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlueprintsPersistenceBackend getBackend() {
		return (BlueprintsPersistenceBackend) backend;
	}

}
