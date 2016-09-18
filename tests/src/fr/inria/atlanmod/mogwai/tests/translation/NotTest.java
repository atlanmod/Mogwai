package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class NotTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of not() call to Gremlin
	 * A not call generates a Gremlin unary comparison containing the translated 
	 * inner expression: <b>!([inner expression])</b> and can not
	 * be a part of a step chain
	 */
	@Test
	public void test() {
	}

}
