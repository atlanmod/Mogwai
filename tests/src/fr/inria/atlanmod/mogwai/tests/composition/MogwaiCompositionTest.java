package fr.inria.atlanmod.mogwai.tests.composition;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
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

public abstract class MogwaiCompositionTest {

	protected GremlinScript gScript;
	
	@Before
	public void setUp() {
		String className = this.getClass().getSimpleName();
		String oclFileName = className.substring(0, className.length()-4);
		oclFileName = Character.toLowerCase(oclFileName.charAt(0))+oclFileName.substring(1);
		Constraint c = null;
		// Debug
//		ResourceSet rSet = new ResourceSetImpl();
//		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
//		Resource r = rSet.createResource(URI.createURI("ocl/composition/xmi/"+oclFileName+".xmi"));
		try {
			c = MogwaiUtil.parseOCL(URI.createURI("ocl/composition/"+oclFileName+".ocl"), JavaPackage.eINSTANCE);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// Debug
//		r.getContents().add(c);
//		try {
//			r.save(Collections.EMPTY_MAP);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		OCL2Gremlin runner = new OCL2Gremlin();
		gScript = (GremlinScript)runner.transform(JavaPackage.eINSTANCE, c);
		assert gScript != null;
	}
	
}
