package fr.inria.atlanmod.mogwai.tests.composition;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gmt.modisco.java.neoemf.meta.JavaPackage;
import org.eclipse.ocl.ecore.Constraint;
import org.junit.Before;

import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.transformation.OCL2GremlinRunner;
import fr.inria.atlanmod.mogwai.util.MogwaiUtil;

public abstract class MogwaiCompositionTest {

	protected GremlinScript gScript;
	
	@Before
	public void setUp() {
		String className = this.getClass().getSimpleName();
		String oclFileName = className.substring(0, className.length()-4);
		oclFileName = Character.toLowerCase(oclFileName.charAt(0))+oclFileName.substring(1);
		Constraint c = null;
		try {
			c = MogwaiUtil.parseOCL(URI.createURI("ocl/composition/"+oclFileName+".ocl"), JavaPackage.eINSTANCE);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		OCL2GremlinRunner runner = new OCL2GremlinRunner();
		gScript = (GremlinScript)runner.transform(JavaPackage.eINSTANCE, c);
		assert gScript != null;
	}
	
}
