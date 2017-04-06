package fr.inria.atlanmod.mogwai.benchmarks.mogwai.tests;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.query.builder.MogwaiOCLQueryBuilder;
import fr.inria.atlanmod.mogwai.resources.MogwaiResource;
import fr.inria.atlanmod.neoemf.util.logging.NeoLogger;

public class TextElementInJavadocQuery extends MogwaiQueryTest {

	public TextElementInJavadocQuery(String resourceName) {
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
	public void run() {
		MogwaiQuery query = MogwaiOCLQueryBuilder.newBuilder()
				.fromURI(URI.createURI("ocl/RCIS/TextElementInJavadoc.ocl")).build();
		NeoLogger.info("Input Query: {0}" + query.getInput());
		startTimer();
        MogwaiResource mogwaiResource = (MogwaiResource)resource;
        MogwaiQueryResult result = mogwaiResource.query(query,mogwaiResource.getContents().get(0));
        try {
        	NeoLogger.info("Reifying results");
        	long begin = System.currentTimeMillis();
			EList<EObject> res = result.reifyResults((MogwaiResource)resource);
			long end = System.currentTimeMillis();
			NeoLogger.info("Reification time: {0}ms", (end-begin));
		} catch (MogwaiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        endTimer();
        NeoLogger.info("Result size: {0}", result.resultSize());
	}

}
