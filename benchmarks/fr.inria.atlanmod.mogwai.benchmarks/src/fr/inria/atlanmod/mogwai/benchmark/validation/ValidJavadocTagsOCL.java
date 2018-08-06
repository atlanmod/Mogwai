package fr.inria.atlanmod.mogwai.benchmark.validation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmt.modisco.java.neoemf.meta.JavaPackage;
import org.eclipse.ocl.ParserException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.benchmarks.ocl.tests.OclQueryTest;
import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;

public class ValidJavadocTagsOCL extends OclQueryTest {
	
	private EClass context;
	
	public ValidJavadocTagsOCL(String resourceName) {
		super(resourceName);
	}
	
	@Before
    public void setUp() throws Exception {
        super.setUp();
        context = JavaPackage.eINSTANCE.getCompilationUnit();
        oclHelper.setContext(context);
        try {
            expression = oclHelper.createQuery("	self.commentList->forAll(comment | " + 
            		"comment.oclIsTypeOf(Javadoc) implies " + 
            		"comment.oclAsType(Javadoc).tags->collect(fragments)->forAll(frag | " + 
            		"frag.oclIsTypeOf(TextElement) implies frag.oclAsType(TextElement).text <> ''))");
        } catch (ParserException e) {
            e.printStackTrace();
            throw e;
        }
        
        this.query = ocl.createQuery(expression);
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void test() {
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
        Object res = query.evaluate(instances);
        endTimer();
        System.out.println("Result set size : " + ((List)res).size());
        System.out.println(res);
    }

}
