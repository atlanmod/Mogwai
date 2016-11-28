package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class FalseBooleanLiteralTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of false BooleanLiterals to Gremlin
	 * A false BooleanLiteral generates a single Gremlin literal: <b>false</b> and can not
	 * be a part of a step chain
	 */
	@Test
	public void test() {
	}

}
