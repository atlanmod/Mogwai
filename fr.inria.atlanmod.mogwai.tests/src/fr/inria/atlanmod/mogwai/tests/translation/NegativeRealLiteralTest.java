package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class NegativeRealLiteralTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of negative RealLiterals to Gremlin
	 * A negative RealLiteral generates a single Gremlin literal: <b>-double</b> and can not
	 * be a part of a step chain
	 */
	@Test
	public void test() {
	}

}
