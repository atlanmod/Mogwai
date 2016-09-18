package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class SizeTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of size() call to Gremlin steps
	 * A size call generates a single Gremlin step: [previous steps].<b>count()</b>
	 */
	@Test
	public void test() {
	}

}
