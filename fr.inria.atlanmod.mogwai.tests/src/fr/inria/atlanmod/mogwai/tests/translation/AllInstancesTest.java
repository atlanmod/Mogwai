package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.InEPipe;
import fr.inria.atlanmod.mogwai.gremlin.OutVPipe;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;

public class AllInstancesTest extends MogwaiTranslationTest {

	/**
	 * Check the translation of allInstances() call to Gremlin steps
	 * An allInstances call generates a step chain following this pattern:
	 * 	- [prev steps].<b>inE("kyanosInstanceOf").outV</b>
	 */
	@Test
	public void test() {
		assert gScript.getInstructions().size() == 3;
		// Ignore 1st and 2nd instructions, they are the same as in TypeAccess test
		assert gScript.getInstructions().get(2) instanceof VariableAccess;
		VariableAccess va = (VariableAccess)gScript.getInstructions().get(2);
		// Do not check the name of the variable access, it is already done in TypeAccess test
		assert va.getNextElement() instanceof InEPipe;
		InEPipe inE = (InEPipe)va.getNextElement();
		assert inE.getRelationshipName().equals("kyanosInstanceOf");
		assert inE.getNextElement() instanceof OutVPipe;
		OutVPipe outV = (OutVPipe)inE.getNextElement();
		assert outV.getNextElement() == null;
	}

}
