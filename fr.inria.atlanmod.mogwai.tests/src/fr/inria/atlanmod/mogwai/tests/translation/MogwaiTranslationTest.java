package fr.inria.atlanmod.mogwai.tests.translation;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.java.neoemf.meta.JavaPackage;
import org.eclipse.ocl.ecore.Constraint;
import org.junit.Before;

import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.transformation.files.OCL2Gremlin;
import fr.inria.atlanmod.mogwai.util.MogwaiUtil;

public abstract class MogwaiTranslationTest {

	protected GremlinScript gScript;
	
	@Before
	public void setUp() throws IOException {
		String className = this.getClass().getSimpleName();
		String oclFileName = className.substring(0, className.length()-4);
		oclFileName = Character.toLowerCase(oclFileName.charAt(0))+oclFileName.substring(1);
		System.out.println("Processing " + oclFileName);
		Constraint c = null;
		try {
			c = MogwaiUtil.parseOCL(URI.createURI("ocl/translation/"+oclFileName+".ocl"), JavaPackage.eINSTANCE);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println("Input OCL: " + c.toString());
		
		ResourceSet rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource oclResource = rSet.createResource(URI.createURI("xmi/translation/ocl/" + oclFileName + ".xmi"));
		oclResource.getContents().add(c);
		oclResource.save(Collections.emptyMap());
		
		OCL2Gremlin runner = new OCL2Gremlin();
		gScript = (GremlinScript)runner.transform(JavaPackage.eINSTANCE, c);
		assert gScript != null;
		
		Resource gremlinResource = rSet.createResource(URI.createURI("xmi/translation/gremlin/" + oclFileName + "_gremlin.xmi"));
		gremlinResource.getContents().add(gScript);
		gremlinResource.save(Collections.emptyMap());
		
		System.out.println("Translated Expression: " + gScript.toString());
		
		Resource expectedResource = rSet.createResource(URI.createURI("expected/translation/" + oclFileName + "_gremlin.xmi"));
		expectedResource.load(Collections.emptyMap());
		
		IComparisonScope scope = new DefaultComparisonScope(gremlinResource, expectedResource, null);
		Comparison comparison = EMFCompare.builder().build().compare(scope);
		
		List<Diff> differences = comparison.getDifferences();
		for(Diff diff : differences) {
			System.out.println(diff.toString());
		}
		assert differences.size() == 0 : "Comparison with expected translation created " + differences.size() + " diffs";
	}
	
}
