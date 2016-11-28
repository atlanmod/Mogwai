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
package fr.inria.atlanmod.mogwai.benchmarks.ocl.tests;

import java.util.List;

import org.eclipse.gmt.modisco.java.neoemf.meta.JavaPackage;
import org.eclipse.ocl.ParserException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Grabats09Query extends OclQueryTest {

    public Grabats09Query(String resourceName) {
        super(resourceName);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        oclHelper.setContext(JavaPackage.eINSTANCE.getModel());
        try {
            expression = oclHelper.createQuery("TypeDeclaration.allInstances()->"
                    + "select(each | each.bodyDeclarations->"
                    + "exists(bd | bd.oclIsTypeOf(MethodDeclaration) "
                    + "and (not bd.modifier.oclIsUndefined()) " + "and bd.modifier._static "
                    + "and (not bd.oclAsType(MethodDeclaration).returnType.oclIsUndefined()) "
                    + "and bd.oclAsType(MethodDeclaration).returnType.type = each))->"
                    + "asSequence()");
        } catch (ParserException e) {
            e.printStackTrace();
            throw e;
        }
        this.query = ocl.createQuery(expression);
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void test() {
        startTimer();
        Object res = query.evaluate(resource.getContents().get(0));
        endTimer();
        System.out.println("Result set size : " + ((List)res).size());
    }

}
