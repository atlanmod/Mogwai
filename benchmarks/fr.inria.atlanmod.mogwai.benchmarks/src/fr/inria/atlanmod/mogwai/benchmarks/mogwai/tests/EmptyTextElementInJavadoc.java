package fr.inria.atlanmod.mogwai.benchmarks.mogwai.tests;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmt.modisco.java.TextElement;
import org.junit.Before;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.benchmarks.util.JavaQueries;
import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.core.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.resources.MogwaiResource;
import fr.inria.atlanmod.mogwai.util.MogwaiUtil;

public class EmptyTextElementInJavadoc extends MogwaiQueryTest {

	public EmptyTextElementInJavadoc(String resourceName) {
		super(resourceName);
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		oclConstraint = MogwaiUtil.parseOCL(URI.createURI("ocl/RCIS/EmptyTextElementInJavadoc.ocl"), resource);
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
		oclConstraint = null;
	}
	
	@Test
	public void run() {
//		try {
//			synchronized (this) {
//				
//			System.out.println("waiting");
//			wait(20000);
//			System.out.println("done");
//			}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("TextElementInJavadoc Warm");
		System.out.println(oclConstraint.toString());
        startTimer();
        MogwaiResource mogwaiResource = (MogwaiResource)resource;
        MogwaiQueryResult result = mogwaiResource.query(oclConstraint,mogwaiResource.getContents().get(0));
//        System.out.println("done");
//        MogwaiQueryResult result2 = mogwaiResource.query(oclConstraint,mogwaiResource.getContents().get(0));
        
//        EList<TextElement> warmResult = JavaQueries.textElementInJavadoc(resource);
        endTimer();
        System.out.println(result.resultSize());
//        try {
//			System.out.println(result.getResults().iterator().next());
//		} catch (MogwaiException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println(result2.resultSize());
	}

}
