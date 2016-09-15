package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.StringLiteral;

public class EmptyStringLiteralTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of empty StringLiterals to Gremlin
	 * A empty StringLiteral generates a single Gremlin literal: <b>""</b> and can not
	 * be a part of a step chain
	 */
	@Test
	public void test() {
		assert gScript.getInstructions().size() == 1;
		assert gScript.getInstructions().get(0) instanceof StringLiteral;
		StringLiteral stringLit = (StringLiteral)gScript.getInstructions().get(0);
		assert stringLit.getValue().equals("");
	}

}
