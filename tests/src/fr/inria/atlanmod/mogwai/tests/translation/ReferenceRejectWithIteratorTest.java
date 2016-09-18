package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class ReferenceRejectWithIteratorTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of a reject() call on an attribute with a declared iterator 
	 * to Gremlin steps
	 * A reject call generates a Gremlin filter step containing the
	 * select body that access the referred node in a negative expression:
	 * [previous steps].<b>filter{!<select body>}</b>
	 */
	@Test
	public void test() {
	}

}
