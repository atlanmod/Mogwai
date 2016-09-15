package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.IntegerLiteral;

public class PositiveIntegerLiteralTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of positive IntegerLiterals to Gremlin
	 * A positive IntegerLiteral generates a single Gremlin literal: <b>number</b> and can not
	 * be a part of a step chain
	 */
	@Test
	public void test() {
		assert gScript.getInstructions().size() == 1;
		assert gScript.getInstructions().get(0) instanceof IntegerLiteral;
		IntegerLiteral intLit = (IntegerLiteral)gScript.getInstructions().get(0);
		assert intLit.getValue() == 42;
	}

}
