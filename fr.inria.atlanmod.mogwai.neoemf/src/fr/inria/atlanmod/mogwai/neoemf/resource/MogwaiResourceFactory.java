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

import fr.inria.atlanmod.mogwai.core.MogwaiCoreException;
import fr.inria.atlanmod.mogwai.neoemf.util.MogwaiURI;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

public class MogwaiResourceFactory extends PersistentResourceFactory {

	protected MogwaiResourceFactory() {
		
	}
	
	public static MogwaiResourceFactory getInstance() {
		return Holder.INSTANCE;
	}
	
    @Override
    public Resource createResource(URI uri) {
        if(uri.scheme().equals(MogwaiURI.MOGWAI_SCHEME) || uri.scheme().equals(BlueprintsURI.SCHEME)) {
            return new DefaultMogwaiResource(uri);
        }
        else {
            return super.createResource(uri);
        }
    }

	public MogwaiResource decoratePersistentResource(PersistentResource persistentResource)
			throws MogwaiCoreException {
		if(DefaultMogwaiResource.isMogwaiCompatible(persistentResource)) {
			return new MogwaiResourceDecorator(persistentResource);
		} else {
			throw new MogwaiCoreException("Resource " + persistentResource.toString() + " is not compatible with Mogwaï");
		}
	}
	
	private static class Holder {
		
		private static final MogwaiResourceFactory INSTANCE = new MogwaiResourceFactory();
	}
    
}
