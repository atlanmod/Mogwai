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

import java.util.Collections;
import java.util.Map;

import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;

public interface MogwaiResource extends PersistentResource {
    
	default NeoEMFQueryResult query(MogwaiQuery query) {
		return this.query(query, null, Collections.emptyMap());
	}
	
	default NeoEMFQueryResult query(MogwaiQuery query, Object arg) {
		return this.query(query, arg, Collections.emptyMap());
	}
	
	default NeoEMFQueryResult query(MogwaiQuery query, Map<String, Object> options) {
		return this.query(query, null, options);
	}
	
    NeoEMFQueryResult query(MogwaiQuery query, Object arg, Map<String, Object> options);
    
    /**
     * Convenient method for development purpose, should not be used to modify the underlying
     * backend directly 
     * @return the backend held by the {@link MogwaiResource}
     */
    public BlueprintsPersistenceBackend getBackend();
    
}
