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
package fr.inria.atlanmod.mogwai.resources;

import fr.inria.atlanmod.neoemf.resources.PersistentResourceFactory;
import fr.inria.atlanmod.neoemf.resources.PersistentResource;
import fr.inria.atlanmod.mogwai.core.MogwaiException;

public interface MogwaiResourceFactory extends PersistentResourceFactory {
    
    public static MogwaiResourceFactory eINSTANCE = new MogwaiResourceFactoryImpl();
    
    /**
     * Create a Mogwai Resource that wraps up the existing {@see PersistentResource}
     * <p>
     * This method is typically called by client applications that want to use an existing 
     * {@see PersistentResource} without closing it and reopen it has a {@see MogwaiResource}.
     * Caches of the underlying database are still available, and loaded elements remains in memory
     * </p>
     * @param persistentResource the resource to wrap
     * @return a MogwaiResource wrapping the provided resource
     * @throws {@see MogwaiException} if the given resource is not compatible with Mogwaï
     */
    public MogwaiResource decoratePersistentResource(PersistentResource persistentResource) throws MogwaiException;

}
