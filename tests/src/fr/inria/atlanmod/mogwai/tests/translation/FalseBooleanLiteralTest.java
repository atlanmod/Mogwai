package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.BooleanLiteral;

public class FalseBooleanLiteralTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of false BooleanLiterals to Gremlin
	 * A false BooleanLiteral generates a single Gremlin literal: <b>false</b> and can not
	 * be a part of a step chain
	 */
	@Test
	public void test() {
		assert gScript.getInstructions().size() == 1;
		assert gScript.getInstructions().get(0) instanceof BooleanLiteral;
		BooleanLiteral boolLit = (BooleanLiteral)gScript.getInstructions().get(0);
		assert boolLit.isValue() == false;
	}

}
