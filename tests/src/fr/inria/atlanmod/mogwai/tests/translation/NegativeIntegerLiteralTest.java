package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class NegativeIntegerLiteralTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of negative IntegerLiterals to Gremlin
	 * A negative IntegerLiteral generates a single Gremlin literal: <b>-number</b> and can not
	 * be a part of a step chain
	 */
	@Test
	public void test() {
	}

}
