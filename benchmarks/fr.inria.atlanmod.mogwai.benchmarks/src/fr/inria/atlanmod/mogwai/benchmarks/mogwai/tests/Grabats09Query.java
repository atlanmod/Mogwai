package fr.inria.atlanmod.mogwai.benchmarks.mogwai.tests;

import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.query.builder.MogwaiOCLQueryBuilder;
import fr.inria.atlanmod.mogwai.resources.MogwaiResource;
import fr.inria.atlanmod.neoemf.util.logging.NeoLogger;

public class Grabats09Query extends MogwaiQueryTest {

	public Grabats09Query(String resourceName) {
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
		MogwaiQuery query = MogwaiOCLQueryBuilder.newBuilder().fromURI(URI.createURI("ocl/RCIS/Grabats09.ocl")).build();
		NeoLogger.info("Input Query: {0}" + query.getInput());
        startTimer();
        MogwaiResource mogwaiResource = (MogwaiResource)resource;
        MogwaiQueryResult result = mogwaiResource.query(query);
        endTimer();
        NeoLogger.info("Result size: {0}", result.resultSize());
	}

}
