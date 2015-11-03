package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.InEStep;
import fr.inria.atlanmod.mogwai.gremlin.OutVStep;
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
		assert va.getNextElement() instanceof InEStep;
		InEStep inE = (InEStep)va.getNextElement();
		assert inE.getRelationshipName().equals("kyanosInstanceOf");
		assert inE.getNextElement() instanceof OutVStep;
		OutVStep outV = (OutVStep)inE.getNextElement();
		assert outV.getNextElement() == null;
	}

}
