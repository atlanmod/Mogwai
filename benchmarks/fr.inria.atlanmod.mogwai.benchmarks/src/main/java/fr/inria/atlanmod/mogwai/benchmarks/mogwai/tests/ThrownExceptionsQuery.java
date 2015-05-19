package fr.inria.atlanmod.mogwai.benchmarks.mogwai.tests;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.core.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.resources.MogwaiResource;
import fr.inria.atlanmod.mogwai.util.MogwaiUtil;

public class ThrownExceptionsQuery extends MogwaiQueryTest {

	public ThrownExceptionsQuery(String resourceName) {
		super(resourceName);
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		oclConstraint = MogwaiUtil.parseOCL(URI.createURI("ocl/ASE15/ThrownExceptions.ocl"), resource);
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
