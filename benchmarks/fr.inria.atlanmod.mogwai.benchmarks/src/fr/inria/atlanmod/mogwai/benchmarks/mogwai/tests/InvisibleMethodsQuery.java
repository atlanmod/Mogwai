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
package fr.inria.atlanmod.mogwai.benchmarks.mogwai.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.ecore.Constraint;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.core.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.resources.MogwaiResource;
import fr.inria.atlanmod.mogwai.util.MogwaiUtil;

public class InvisibleMethodsQuery extends MogwaiQueryTest {
    
    public InvisibleMethodsQuery(String resourceName) {
        super(resourceName);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        oclConstraint = MogwaiUtil.parseOCL(URI.createURI("ocl/RCIS/InvisibleMethods.ocl"), resource);
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
        oclConstraint = null;
    }

    @Test
    public void run() {
        System.out.println(oclConstraint.toString());
        startTimer();
        MogwaiResource mogwaiResource = (MogwaiResource)resource;
        MogwaiQueryResult result = mogwaiResource.query(oclConstraint);
        endTimer();
        System.out.println(result.resultSize());
    }

}
