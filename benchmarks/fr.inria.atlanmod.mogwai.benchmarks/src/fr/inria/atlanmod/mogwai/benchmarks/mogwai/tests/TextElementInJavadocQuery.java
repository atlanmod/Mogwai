package fr.inria.atlanmod.mogwai.benchmarks.mogwai.tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.core.exception.MogwaiCoreException;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.processor.GremlinScriptRunner;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.builder.OCLQueryBuilder;
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
		MogwaiQuery query = OCLQueryBuilder.newBuilder()
				.fromURI(URI.createURI("ocl/RCIS/TextElementInJavadoc.ocl")).build();
		NeoLogger.info("Input Query: {0}" + query.getInput());
		startTimer();
        MogwaiResource mogwaiResource = (MogwaiResource)resource;
        Map<String, Object> options = new HashMap<>();
        options.put(GremlinScriptRunner.PRINT_SCRIPT_OPTION, true);
        NeoEMFQueryResult result = mogwaiResource.query(query,mogwaiResource.getContents().get(0), options);
        try {
        	NeoLogger.info("Reifying results");
        	long begin = System.currentTimeMillis();
			List<EObject> res = result.reifyResults((MogwaiResource)resource);
			long end = System.currentTimeMillis();
			NeoLogger.info("Reification time: {0}ms", (end-begin));
		} catch (MogwaiCoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        endTimer();
        NeoLogger.info("Result size: {0}", result.resultSize());
	}

}
