package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class EmptyStringLiteralTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of empty StringLiterals to Gremlin
	 * A empty StringLiteral generates a single Gremlin literal: <b>""</b> and can not
	 * be a part of a step chain
	 */
	@Test
	public void test() {
	}

}
