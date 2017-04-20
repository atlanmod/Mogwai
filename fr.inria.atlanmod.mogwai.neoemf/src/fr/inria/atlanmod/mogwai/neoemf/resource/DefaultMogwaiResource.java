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

import static java.util.Objects.isNull;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.atlanmod.mogwai.data.mapping.blueprints.NeoEMFMapping;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFGremlinProcessor;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFOCLProcessor;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
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

	private static final ThreadLocal<NeoEMFOCLProcessor> oclProcessor = new ThreadLocal<NeoEMFOCLProcessor>() {

		@Override
		protected NeoEMFOCLProcessor initialValue() {
			return new NeoEMFOCLProcessor();
		}
	};

	private static final ThreadLocal<NeoEMFGremlinProcessor> gremlinProcessor = new ThreadLocal<NeoEMFGremlinProcessor>() {

		@Override
		protected NeoEMFGremlinProcessor initialValue() {
			return new NeoEMFGremlinProcessor();
		}
	};

	public DefaultMogwaiResource(URI uri) {
		super(uri);
		assert this.backend instanceof BlueprintsPersistenceBackend;
	}

	@Override
	public NeoEMFQueryResult query(MogwaiQuery query, Map<String, Object> options) {
		return this.query(query, null, options);
	}

	@Override
	public NeoEMFQueryResult query(MogwaiQuery query, Object arg, Map<String, Object> options) {
		Map<String, Object> theOptions = options;
		if (isNull(theOptions)) {
			theOptions = Collections.emptyMap();
		}
		if (oclProcessor.get().accept(query)) {
			return (NeoEMFQueryResult) query.process(oclProcessor.get(), getBackend(), new NeoEMFMapping(), theOptions);
		} else if (gremlinProcessor.get().accept(query)) {
			return (NeoEMFQueryResult) query.process(gremlinProcessor.get(), getBackend(), new NeoEMFMapping(),
					theOptions);
		}
		throw new MogwaiQueryException("Cannot find a processor for " + query);
	}

	@Override
	public BlueprintsPersistenceBackend getBackend() {
		return (BlueprintsPersistenceBackend) backend;
	}

}
