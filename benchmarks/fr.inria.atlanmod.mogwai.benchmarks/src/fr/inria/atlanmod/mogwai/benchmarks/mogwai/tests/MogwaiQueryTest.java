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

import org.junit.Before;

import fr.inria.atlanmod.mogwai.benchmarks.AbstractQueryTest;
import fr.inria.atlanmod.mogwai.resources.MogwaiResourceFactory;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;

public class MogwaiQueryTest extends AbstractQueryTest{

    public MogwaiQueryTest(String resourceName) {
        super(resourceName);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        resource = MogwaiResourceFactory.getInstance().decoratePersistentResource((PersistentResource)resource);
    }

}
