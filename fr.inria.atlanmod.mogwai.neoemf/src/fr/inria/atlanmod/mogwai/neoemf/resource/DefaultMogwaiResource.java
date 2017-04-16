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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import com.sun.istack.internal.Nullable;

import fr.inria.atlanmod.mogwai.processor.MogwaiGremlinProcessor;
import fr.inria.atlanmod.mogwai.processor.MogwaiOCLProcessor;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryException;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.DefaultPersistentResource;

public class DefaultMogwaiResource extends DefaultPersistentResource implements MogwaiResource {

	/**
	 * Returns true if an EMF resource can be used by Mogwaï
	 * @param resource the resource to check
	 * @return true if the resource can be used by Mogwaï, false otherwise
	 */
	public static boolean isMogwaiCompatible(Resource resource) {
		return (resource instanceof MogwaiResource) || resource.getURI().scheme().equals(BlueprintsURI.SCHEME);
	}
	
	private static final ThreadLocal<MogwaiOCLProcessor> oclProcessor = 
		new ThreadLocal<MogwaiOCLProcessor>() {
			
			@Override
			protected MogwaiOCLProcessor initialValue() {
				return new MogwaiOCLProcessor();
			}
		};
		
	private static final ThreadLocal<MogwaiGremlinProcessor> gremlinProcessor = 
		new ThreadLocal<MogwaiGremlinProcessor>() {
			
			@Override
			protected MogwaiGremlinProcessor initialValue() {
				return new MogwaiGremlinProcessor();
			}
		};
		
    public DefaultMogwaiResource(URI uri) {
        super(uri);
        assert this.backend instanceof BlueprintsPersistenceBackend;
        oclProcessor.get().setGraphBackend((BlueprintsPersistenceBackend) this.backend);
        gremlinProcessor.get().setGraphBackend((BlueprintsPersistenceBackend) this.backend);
    }
    
    public MogwaiQueryResult query(MogwaiQuery query) {
    	return this.query(query, null);
    }
    
    @Override
    public MogwaiQueryResult query(MogwaiQuery query, @Nullable Object arg) {
    	if(oclProcessor.get().accept(query)) {
    		return query.process(oclProcessor.get(), arg);
    	} else if(gremlinProcessor.get().accept(query)) {
    		return query.process(gremlinProcessor.get(), arg);
    	}
    	throw new MogwaiQueryException("Cannot find a processor for " + query);
    }
    
    @Override
    public BlueprintsPersistenceBackend getBackend() {
    	return (BlueprintsPersistenceBackend)backend;
    }
    
    // TODO check if this should be moved
    @Override
    public void enableATLDebug() {
    	oclProcessor.get().enableATLDebug();
    }
    
    @Override
    public void disableATLDebug() {
    	oclProcessor.get().disableATLDebug();
    }
    
}
