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
import org.eclipse.ocl.ecore.Constraint;

import fr.inria.atlanmod.mogwai.core.Mogwai;
import fr.inria.atlanmod.mogwai.core.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.util.MogwaiUtil;
import fr.inria.atlanmod.neoemf.graph.blueprints.datastore.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceImpl;

public class MogwaiResourceImpl extends PersistentResourceImpl implements MogwaiResource {

    public MogwaiResourceImpl(URI uri) {
        super(uri);
        assert this.persistenceBackend instanceof BlueprintsPersistenceBackend;
    }

    @Override
    public MogwaiQueryResult query(URI oclFileURI, Object obj) {
        Constraint exp = MogwaiUtil.parseOCL(oclFileURI,this);
        return this.query(exp,obj);
    }
    
    @Override
    public MogwaiQueryResult query(Constraint exp, Object obj) {
        Mogwai mogwai = new Mogwai();
        return mogwai.performQuery(exp, obj, this, (BlueprintsPersistenceBackend)persistenceBackend);
    }
    
    @Override
    public MogwaiQueryResult query(URI oclFileURI) {
        Constraint exp = MogwaiUtil.parseOCL(oclFileURI, this);
        return this.query(exp,null);
    }
    
    @Override
    public MogwaiQueryResult query(Constraint exp) {
        return this.query(exp,null);
    }

}
