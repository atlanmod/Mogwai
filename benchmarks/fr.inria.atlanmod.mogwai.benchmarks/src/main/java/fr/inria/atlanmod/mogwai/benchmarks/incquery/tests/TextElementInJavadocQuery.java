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

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.incquery.queries.CommentTextMatch;
import fr.inria.atlanmod.mogwai.incquery.queries.CommentTextMatcher;
import fr.inria.atlanmod.mogwai.incquery.queries.InvisibleMethodsMatch;
import fr.inria.atlanmod.mogwai.incquery.queries.InvisibleMethodsMatcher;

public class TextElementInJavadocQuery extends IncQueryTest {

    public TextElementInJavadocQuery(String resourceName) {
        super(resourceName);
    }

    @Override
    protected Notifier getStartPoint() {
        return this.resource.getContents().get(0);
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
            CommentTextMatcher matcher = CommentTextMatcher.on(engine);
            Collection<CommentTextMatch> matches = matcher.getAllMatches();
            System.out.println("Result set size : " + matches.size());
            endTimer();
        }catch(IncQueryException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
