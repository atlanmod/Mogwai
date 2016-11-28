package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class AttributeExistsWithIteratorTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of an exists() call with a declared iterator to Gremlin steps
	 * An exists call generates a Gremlin filter step containing the
	 * exists body and a hasNext call to get the boolean value if a comparison is needed: 
	 * [previous steps].<b>filter{<exists body>}.hasNext()</b>
	 */
	@Test
	public void test() {
	}

}
