package fr.inria.atlanmod.mogwai.tests.translation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gmt.modisco.java.kyanos.JavaPackage;
import org.eclipse.ocl.ecore.Constraint;
import org.junit.Before;

import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.transformation.OCL2GremlinTransformer;
import fr.inria.atlanmod.mogwai.util.MogwaiUtil;

public abstract class MogwaiTranslationTest {

	protected GremlinScript gScript;
	
	@Before
	public void setUp() {
		String className = this.getClass().getSimpleName();
		String oclFileName = className.substring(0, className.length()-4);
		oclFileName = Character.toLowerCase(oclFileName.charAt(0))+oclFileName.substring(1);
		Constraint c = null;
		try {
			c = MogwaiUtil.parseOCL(URI.createURI("ocl/translation/"+oclFileName+".ocl"), JavaPackage.eINSTANCE);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		OCL2GremlinTransformer transformer = new OCL2GremlinTransformer();
		gScript = (GremlinScript)transformer.transform(JavaPackage.eINSTANCE, c);
		assert gScript != null;
	}
	
}
