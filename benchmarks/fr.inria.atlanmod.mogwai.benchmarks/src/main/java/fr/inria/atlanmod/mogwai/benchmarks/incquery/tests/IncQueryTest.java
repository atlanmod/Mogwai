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
package fr.inria.atlanmod.mogwai.benchmarks.incquery.tests;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.After;
import org.junit.Before;

import fr.inria.atlanmod.mogwai.benchmarks.AbstractQueryTest;

public class IncQueryTest extends AbstractQueryTest {
    
    protected AdvancedIncQueryEngine engine;
    
    public IncQueryTest(String resourceName) {
        super(resourceName);
    }
    
    @Before
    public void setUp() throws Exception {
        super.setUp();
        if(resource != null) {
            try {
                engine = AdvancedIncQueryEngine.createUnmanagedEngine(resource, false,false);
            }catch(IncQueryException e) {
                System.out.println("Can not initialize IncQuery engine");
                e.printStackTrace();
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
        engine.dispose();
        engine = null;
        Runtime.getRuntime().gc();
    }

}
