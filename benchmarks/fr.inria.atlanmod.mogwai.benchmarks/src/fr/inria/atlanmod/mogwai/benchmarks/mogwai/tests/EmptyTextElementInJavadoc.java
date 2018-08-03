package fr.inria.atlanmod.mogwai.benchmarks.mogwai.tests;

import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.builder.OCLQueryBuilder;
import fr.inria.atlanmod.neoemf.util.logging.NeoLogger;

public class EmptyTextElementInJavadoc extends MogwaiQueryTest {

	public EmptyTextElementInJavadoc(String resourceName) {
		super(resourceName);
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void run() {
		MogwaiQuery query = OCLQueryBuilder.newBuilder()
				.fromURI(URI.createURI("ocl/RCIS/EmptyTextElementInJavadoc.ocl")).build();
		NeoLogger.info("Input Query: {0}" + query.getInput());
        startTimer();
        MogwaiResource mogwaiResource = (MogwaiResource)resource;
        NeoEMFQueryResult result = mogwaiResource.query(query, mogwaiResource.getContents().get(0));
        endTimer();
        NeoLogger.info("Result size: {0}", result.resultSize());
	}

}
