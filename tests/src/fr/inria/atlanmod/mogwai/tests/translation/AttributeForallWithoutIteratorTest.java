package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class AttributeForallWithoutIteratorTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of an forAll() call without iterator to Gremlin steps
	 * A forAll call generates a Gremlin filter step containing the
	 * forAll body in a negative expression. The overall results is calculated by an isEmpty
	 * call: 
	 * [previous steps].<b>filter{!<forall body>}.toList().isEmpty()</b>
	 */
	@Test
	public void test() {
	}

}
