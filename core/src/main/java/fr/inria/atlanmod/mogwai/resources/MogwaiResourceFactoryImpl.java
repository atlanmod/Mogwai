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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.atlanmod.mogwai.util.MogwaiURI;
import fr.inria.atlanmod.neoemf.graph.blueprints.util.NeoBlueprintsURI;
import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceFactoryImpl;

public class MogwaiResourceFactoryImpl extends PersistentResourceFactoryImpl implements
        MogwaiResourceFactory {

    @Override
    public Resource createResource(URI uri) {
        if(uri.scheme().equals(MogwaiURI.MOGWAI_SCHEME) || uri.scheme().equals(NeoBlueprintsURI.NEO_GRAPH_SCHEME)) {
            return new MogwaiResourceImpl(uri);
        }
        else {
            return super.createResource(uri);
        }
    }
    
}
