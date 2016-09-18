package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class AsSequenceTest extends MogwaiTranslationTest {

	/**
	 * Check the translation of asSequence() call to Gremlin steps
	 * A asSequence call generates a single Gremlin step: [previous steps].<b>_()</b>
	 */
	@Test
	public void test() {
	}

}
