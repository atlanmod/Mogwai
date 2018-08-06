package fr.inria.atlanmod.mogwai.benchmark.validation;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmt.modisco.java.neoemf.meta.JavaPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.benchmarks.mogwai.tests.MogwaiQueryTest;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFValidationResult;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.builder.OCLQueryBuilder;

public class ValidJavadocTagsOptimizedMogwai extends MogwaiQueryTest {
	
	private EClass context;
	
	public ValidJavadocTagsOptimizedMogwai(String resourceName) {
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
    	MogwaiQuery query = OCLQueryBuilder.newBuilder().fromURI(URI.createURI("ocl/validation/validJavadocTags.ocl")).build();
        startTimer();
        MogwaiResource mogResource = (MogwaiResource)resource;
        NeoEMFValidationResult result = mogResource.validate(query, new HashMap<>());
        List<EObject> violatingInstances = result.getViolatingInstances(mogResource);
        endTimer();
        System.out.println("Result set size : " + violatingInstances.size());
        System.out.println(violatingInstances);
    }

}
