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
import org.eclipse.ocl.ecore.OCLExpression;

import fr.inria.atlanmod.mogwai.core.MogwaiQueryResult;
import fr.inria.atlanmod.neoemf.resources.PersistentResource;

public interface MogwaiResource extends PersistentResource {
    
    MogwaiQueryResult query(URI oclFileURI, Object obj);
    
    MogwaiQueryResult query(Constraint exp, Object obj);
    
    MogwaiQueryResult query(OCLExpression exp, Object obj);
    
    MogwaiQueryResult query(URI oclFileURI);

    MogwaiQueryResult query(Constraint exp);
    
    MogwaiQueryResult query(OCLExpression exp);
}
