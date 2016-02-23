package fr.inria.atlanmod.mogwai.benchmarks.mogwai.tests;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.core.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.resources.MogwaiResource;
import fr.inria.atlanmod.mogwai.util.MogwaiUtil;

public class TextElementInJavadocQuery extends MogwaiQueryTest {

	public TextElementInJavadocQuery(String resourceName) {
		super(resourceName);
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		oclConstraint = MogwaiUtil.parseOCL(URI.createURI("ocl/RCIS/TextElementInJavadoc.ocl"), resource);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void run() {
		System.out.println(oclConstraint.toString());
        startTimer();
        MogwaiResource mogwaiResource = (MogwaiResource)resource;
        MogwaiQueryResult result = mogwaiResource.query(oclConstraint,mogwaiResource.getContents().get(0));
        try {
        	long begin = System.currentTimeMillis();
			EList<EObject> res = result.reifyResults((MogwaiResource)resource);
			System.out.println(res.size());
			long end = System.currentTimeMillis();
			System.out.println("reification time: " + (end-begin)+" ms");
		} catch (MogwaiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        endTimer();
        System.out.println(result.resultSize());
	}

}
