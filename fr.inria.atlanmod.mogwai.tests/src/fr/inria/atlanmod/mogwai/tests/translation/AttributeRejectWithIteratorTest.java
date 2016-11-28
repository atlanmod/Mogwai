package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class AttributeRejectWithIteratorTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of a reject() call on an attribute with a declared iterator 
	 * to Gremlin steps
	 * A reject call generates a Gremlin filter step containing the
	 * select body in a negative expression:
	 * [previous steps].<b>filter{!<select body>}</b>
	 */
	@Test
	public void test() {
	}

}
