package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.DoubleLiteral;

public class PositiveRealLiteralTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of positive RealLiterals to Gremlin
	 * A positive RealLiteral generates a single Gremlin literal: <b>double</b> and can not
	 * be a part of a step chain
	 */
	@Test
	public void test() {
		assert gScript.getInstructions().size() == 1;
		assert gScript.getInstructions().get(0) instanceof DoubleLiteral;
		DoubleLiteral doubleLit = (DoubleLiteral)gScript.getInstructions().get(0);
		assert doubleLit.getValue() == 4.2;
	}

}
