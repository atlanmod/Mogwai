package fr.inria.atlanmod.mogwai.benchmark.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmt.modisco.java.neoemf.meta.JavaPackage;
import org.eclipse.ocl.ParserException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.benchmarks.mogwai.tests.MogwaiQueryTest;
import fr.inria.atlanmod.mogwai.benchmarks.ocl.tests.OclQueryTest;
import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.builder.OCLQueryBuilder;

public class NotEmptyClassNameStandardMogwai extends MogwaiQueryTest {
	
	private EClass context;
	
	public NotEmptyClassNameStandardMogwai(String resourceName) {
		super(resourceName);
	}
	
	@Before
    public void setUp() throws Exception {
        super.setUp();
        context = JavaPackage.eINSTANCE.getClassDeclaration();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void test() {
    	MogwaiQuery query = OCLQueryBuilder.newBuilder().fromURI(URI.createURI("ocl/validation/notEmptyClassName.ocl")).build();
        startTimer();
        MogwaiLogger.info("Retrieving instances to validate");
        long beginAllInstances = System.currentTimeMillis();
        List<EObject> instances = new ArrayList<>();
        Iterator<EObject> it = resource.getAllContents();
        while(it.hasNext()) {
        	EObject e = it.next();
        	if(context.isInstance(e)) {
        		instances.add(e);
        	}
        }
        long endAllInstances = System.currentTimeMillis();
        MogwaiLogger.info("AllInstances time: {0}ms", (endAllInstances-beginAllInstances));
        MogwaiResource mogResource = (MogwaiResource)resource;
        List<Object> results = new ArrayList<Object>();
		for(EObject e : instances) {
			results.add(mogResource.query(query, e, new HashMap<>()).getResult());
		}
        endTimer();
        System.out.println("Result set size : " + results.size());
        System.out.println(results);
    }

}
