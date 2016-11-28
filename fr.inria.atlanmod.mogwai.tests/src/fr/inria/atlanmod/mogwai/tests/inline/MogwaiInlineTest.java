package fr.inria.atlanmod.mogwai.tests.inline;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.java.neoemf.meta.JavaPackage;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.Before;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.transformation.files.OCL2Gremlin;
import fr.inria.atlanmod.mogwai.util.MogwaiUtil;

/**
 * Test the translation of OCL inline expressions which are only
 * defined by their OCLExpression
 *
 */
public abstract class MogwaiInlineTest {

	private EcoreFactory eFactory = EcoreFactory.eINSTANCE;
	protected JavaPackage jPackage = JavaPackage.eINSTANCE;
	protected GremlinScript gScript;
	protected String inlineOCL;
	protected EClassifier context;
	
	@Before
	public void setUp() throws IOException {
		String className = this.getClass().getSimpleName();
		String testName = className.substring(0, className.length()-4);
		testName = Character.toLowerCase(testName.charAt(0)) + testName.substring(1);
		OCLExpression expression = null;
		try {
			expression = MogwaiUtil.parseInlineOCL(inlineOCL, context);
		} catch (MogwaiException e) {
			e.printStackTrace();
		}
		assert expression != null;
		System.out.println("Input OCL:" + expression.toString());
		Constraint mockConstraint = eFactory.createConstraint();
		/* 
		 * MogwaïResource uses UUID to generate unique identifiers for
		 * constraints. In the test we need to have a common name to
		 * allow comparison with expected GremlinScript.
		 */
		mockConstraint.setName(testName);
		ExpressionInOCL mockExp = eFactory.createExpressionInOCL();
		mockConstraint.setSpecification(mockExp);
		mockExp.setBodyExpression(expression);
		
		ResourceSet rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",  new XMIResourceFactoryImpl());
		Resource oclResource = rSet.createResource(URI.createURI("xmi/inline/ocl/" + testName + ".xmi"));
		oclResource.getContents().add(mockConstraint);
		oclResource.save(Collections.emptyMap());
		
		OCL2Gremlin runner = new OCL2Gremlin();
		gScript = (GremlinScript)runner.transform(JavaPackage.eINSTANCE, mockConstraint);
		assert gScript != null;
		
		Resource gremlinResource = rSet.createResource(URI.createURI("xmi/inline/gremlin/" + testName + "_gremlin.xmi"));
		gremlinResource.getContents().add(gScript);
		gremlinResource.save(Collections.emptyMap());
		
		System.out.println("Translated Expression: " + gScript.toString());
		
		Resource expectedResource = rSet.createResource(URI.createURI("expected/inline/" + testName + "_gremlin.xmi"));
		try {
			expectedResource.load(Collections.emptyMap());
		} catch (IOException e) {
			System.err.println("Cannot load expected result, first time executing the tests?");
		}
		
		IComparisonScope scope = new DefaultComparisonScope(gremlinResource, expectedResource, null);
		Comparison comparison = EMFCompare.builder().build().compare(scope);
		
		List<Diff> differences = comparison.getDifferences();
		assert differences.size() == 0 : "Comparison with expected translation created " + differences.size() + " diffs";
	}
	
}
