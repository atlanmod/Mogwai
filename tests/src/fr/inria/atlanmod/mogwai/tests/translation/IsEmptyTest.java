package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class IsEmptyTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of isEmpty() call to Gremlin steps
	 * An isEmpty call generates a step chain following this pattern:
	 * 	- [previous steps].<b>toList().isEmpty()</b>
	 */
	@Test
	public void test() {
	}

}
