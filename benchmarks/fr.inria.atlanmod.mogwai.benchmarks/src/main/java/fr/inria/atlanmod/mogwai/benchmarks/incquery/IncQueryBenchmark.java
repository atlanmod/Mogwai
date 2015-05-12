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
package fr.inria.atlanmod.mogwai.benchmarks.incquery;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.inria.atlanmod.mogwai.benchmarks.incquery.tests.Grabats09Query;
import fr.inria.atlanmod.mogwai.benchmarks.incquery.tests.InvisibleMethodsQuery;
import fr.inria.atlanmod.mogwai.benchmarks.incquery.tests.ThrownExceptionsQuery;

@RunWith(Suite.class)
@SuiteClasses({
    InvisibleMethodsQuery.class,
    Grabats09Query.class,
    ThrownExceptionsQuery.class
    })
public class IncQueryBenchmark {

}
