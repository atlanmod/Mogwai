package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.BooleanLiteral;

public class TrueBooleanLiteralTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of true BooleanLiterals to Gremlin
	 * A true BooleanLiteral generates a single Gremlin literal: <b>true</b> and can not
	 * be a part of a step chain
	 */
	@Test
	public void test() {
		assert gScript.getInstructions().size() == 1;
		assert gScript.getInstructions().get(0) instanceof BooleanLiteral;
		BooleanLiteral boolLit = (BooleanLiteral)gScript.getInstructions().get(0);
		assert boolLit.isValue() == true;
	}

}
