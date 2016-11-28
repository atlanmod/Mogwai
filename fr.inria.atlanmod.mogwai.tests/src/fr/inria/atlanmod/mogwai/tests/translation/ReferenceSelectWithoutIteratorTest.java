package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class ReferenceSelectWithoutIteratorTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of a select() call on a reference without iterator 
	 * to Gremlin steps
	 * A select call on a reference generates a Gremlin filter step containing the
	 * select body that access the referred node:
	 * [previous steps].<b>filter{<select body>}</b>
	 */
	@Test
	public void test() {
	}

}
