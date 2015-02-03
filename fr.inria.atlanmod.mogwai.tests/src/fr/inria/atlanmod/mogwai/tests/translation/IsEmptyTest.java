package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.InEPipe;
import fr.inria.atlanmod.mogwai.gremlin.IsEmptyCall;
import fr.inria.atlanmod.mogwai.gremlin.OutVPipe;
import fr.inria.atlanmod.mogwai.gremlin.ToListCall;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;

public class IsEmptyTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of isEmpty() call to Gremlin steps
	 * An isEmpty call generates a step chain following this pattern:
	 * 	- [previous steps].<b>toList().isEmpty()</b>
	 */
	@Test
	public void test() {
		assert gScript.getInstructions().size() == 3;
		// Ignore 1st and 2nd instructions, they are the same as in TypeAccess test
		assert gScript.getInstructions().get(2) instanceof VariableAccess;
		VariableAccess va = (VariableAccess)gScript.getInstructions().get(2);
		// Do not check the name of the variable access, it is already done in TypeAccess test
		// Next element types are not checked, it is already done in AllInstances test
		InEPipe inE = (InEPipe)va.getNextElement();
		OutVPipe outV = (OutVPipe)inE.getNextElement();
		assert outV.getNextElement() instanceof ToListCall;
		ToListCall toList = (ToListCall)outV.getNextElement();
		assert toList.getNextElement() instanceof IsEmptyCall;
		IsEmptyCall isEmpty = (IsEmptyCall)toList.getNextElement();
		assert isEmpty.getNextElement() == null;
	}

}
