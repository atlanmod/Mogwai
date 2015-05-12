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

import java.util.Collection;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.incquery.queries.Grabats09Match;
import fr.inria.atlanmod.mogwai.incquery.queries.Grabats09Matcher;

public class Grabats09Query extends IncQueryTest {

    public Grabats09Query(String resourceName) {
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
    public void run() throws IncQueryException {
        try {
            startTimer();
            Grabats09Matcher matcher = Grabats09Matcher.on(engine);
            Collection<Grabats09Match> matches = matcher.getAllMatches();
            System.out.println("Result set size : " + matches.size());
            endTimer();
        }catch(IncQueryException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
