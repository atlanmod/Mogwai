package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.FirstCall;
import fr.inria.atlanmod.mogwai.gremlin.IdentityPipe;
import fr.inria.atlanmod.mogwai.gremlin.InEPipe;
import fr.inria.atlanmod.mogwai.gremlin.OutVPipe;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;

public class OclAsTypeTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of oclAsType() call to Gremlin steps
	 * An oclAsType call generates a single identity Gremlin step: 
	 * [previous steps].<b>_()</b> because type casting does not have
	 * a signification in the database schema
	 */
	@Test
	public void test() {
		assert gScript.getInstructions().size() == 3;
		// Ignore 1st and 2nd instructions, they are the same as in TypeAccess test
		assert gScript.getInstructions().get(2) instanceof VariableAccess;
		VariableAccess va = (VariableAccess)gScript.getInstructions().get(2);
		// Do not check the name of the variable access, it is already done in TypeAccess test
		// InEPipe and OutVPipe types are not checked, it is already done in AllInstances test
		InEPipe inE = (InEPipe)va.getNextElement();
		OutVPipe outV = (OutVPipe)inE.getNextElement();
		// IdentityPipe type is not checked, it is done in AsSequence test
		IdentityPipe idPipe = (IdentityPipe)outV.getNextElement();
		// FirstCall type is not checked, it is done in First test
		FirstCall first = (FirstCall)idPipe.getNextElement();
		assert first.getNextElement() instanceof IdentityPipe;
		IdentityPipe idPipe2 = (IdentityPipe)first.getNextElement();
		assert idPipe2.getNextElement() == null;
	}

}
