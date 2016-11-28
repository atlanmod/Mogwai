package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class StringLiteralTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of StringLiterals to Gremlin
	 * A StringLiteral generates a single Gremlin literal: <b>"literal"</b> and can not
	 * be a part of a step chain
	 */
	@Test
	public void test() {
	}

}
