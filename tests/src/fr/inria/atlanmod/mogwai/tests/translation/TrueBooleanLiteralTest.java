package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class TrueBooleanLiteralTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of true BooleanLiterals to Gremlin
	 * A true BooleanLiteral generates a single Gremlin literal: <b>true</b> and can not
	 * be a part of a step chain
	 */
	@Test
	public void test() {
	}

}
