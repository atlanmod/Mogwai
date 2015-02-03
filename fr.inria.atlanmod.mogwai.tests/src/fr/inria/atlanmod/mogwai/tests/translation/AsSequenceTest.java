package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.IdentityPipe;
import fr.inria.atlanmod.mogwai.gremlin.InEPipe;
import fr.inria.atlanmod.mogwai.gremlin.OutVPipe;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;

public class AsSequenceTest extends MogwaiTranslationTest {

	/**
	 * Check the translation of asSequence() call to Gremlin steps
	 * A asSequence call generates a single Gremlin step: [previous steps].<b>_()</b>
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
		assert outV.getNextElement() instanceof IdentityPipe;
		IdentityPipe idPipe = (IdentityPipe)outV.getNextElement();
		assert idPipe.getNextElement() == null;
	}

}
