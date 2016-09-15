package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.FirstCall;
import fr.inria.atlanmod.mogwai.gremlin.IdentityStep;
import fr.inria.atlanmod.mogwai.gremlin.InEStep;
import fr.inria.atlanmod.mogwai.gremlin.OutVStep;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;

public class FirstTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of first() call to Gremlin steps
	 * A first call generates a single Gremlin step: [previous steps].<b>first()</b>
	 */
	@Test
	public void test() {
		assert gScript.getInstructions().size() == 3;
		// Ignore 1st and 2nd instructions, they are the same as in TypeAccess test
		assert gScript.getInstructions().get(2) instanceof VariableAccess;
		VariableAccess va = (VariableAccess)gScript.getInstructions().get(2);
		// Do not check the name of the variable access, it is already done in TypeAccess test
		// InEStep and OutVStep types are not checked, it is already done in AllInstances test
		InEStep inE = (InEStep)va.getNextElement();
		OutVStep outV = (OutVStep)inE.getNextElement();
		// IdentityStep type is not checked, it is done in AsSequence test
		IdentityStep idPipe = (IdentityStep)outV.getNextElement();
		assert idPipe.getNextElement() instanceof FirstCall;
		FirstCall first = (FirstCall)idPipe.getNextElement();
		assert first.getNextElement() == null;
	}

}
