package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class AndTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of and() call to Gremlin
	 * A and call generates a Gremlin binary comparison containing the translated 
	 * inner left and right expressions: <b>([inner left expression] or [inner right expression])</b>
	 * and can not be a part of a step chain
	 */
	@Test
	public void test() {
	}

}
