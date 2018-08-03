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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.builder.OCLQueryBuilder;
import fr.inria.atlanmod.neoemf.util.logging.NeoLogger;

public class InvisibleMethodsQuery extends MogwaiQueryTest {
    
    public InvisibleMethodsQuery(String resourceName) {
        super(resourceName);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void run() {
		MogwaiQuery query = OCLQueryBuilder.newBuilder().fromURI(URI.createURI("ocl/RCIS/InvisibleMethods.ocl"))
				.build();
		NeoLogger.info("Input Query: {0}", query.getInput());
        startTimer();
        MogwaiResource mogwaiResource = (MogwaiResource)resource;
        NeoEMFQueryResult result = mogwaiResource.query(query);
        endTimer();
        NeoLogger.info("Result size: {0}", result.resultSize());
    }

}
