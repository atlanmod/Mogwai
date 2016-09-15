package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.InEStep;
import fr.inria.atlanmod.mogwai.gremlin.OutVStep;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;

public class EnumTest extends MogwaiTranslationTest {

	/**
	 * Check the translation of allInstances() call to Gremlin steps
	 * An allInstances call generates a step chain following this pattern:
	 * 	- [prev steps].<b>inE("kyanosInstanceOf").outV</b>
	 */
	@Test
	public void test() {
		System.out.println(gScript.toString());
	}

}
