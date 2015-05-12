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
package fr.inria.atlanmod.mogwai.benchmarks;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.inria.atlanmod.mogwai.benchmarks.incquery.IncQueryBenchmark;
import fr.inria.atlanmod.mogwai.benchmarks.ocl.OclBenchmark;

@RunWith(Suite.class)
@SuiteClasses({
//    OclBenchmark.class
    IncQueryBenchmark.class
    })
public class MogwaiBenchmark {

}
