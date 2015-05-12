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

import static org.junit.Assert.*;

import java.util.Collection;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.incquery.queries.ThrownExceptionsMatch;
import fr.inria.atlanmod.mogwai.incquery.queries.ThrownExceptionsMatcher;

public class ThrownExceptionsQuery extends IncQueryTest {

    public ThrownExceptionsQuery(String resourceName) {
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
        try {
            startTimer();
            ThrownExceptionsMatcher matcher = ThrownExceptionsMatcher.on(engine);
            Collection<ThrownExceptionsMatch> matches = matcher.getAllMatches();
            endTimer();
            System.out.println("Result set size : " + matches.size());
        }catch(IncQueryException e) {
            fail("Can not initialize the matcher");
        }
    }

}
