package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class AttributeSelectWithoutIteratorTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of a select() call on an attribute without iterator 
	 * to Gremlin steps
	 * A select call generates a Gremlin filter step containing the
	 * select body:
	 * [previous steps].<b>filter{<select body>}</b>
	 */
	@Test
	public void test() {
	}

}
