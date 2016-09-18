package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class ExplicitAttributeCollectWithoutIteratorTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of an collect() call on an attribute without iterator
	 * to Gremlin steps
	 * A collect call is handled by a step chain representing the access of the attribute:
	 * 	- <b>[previous steps].<property name>._()</b>
	 * Identity pipe is generated to match the collect object itself, it does not change the
	 * result 
	 */
	@Test
	public void test() {
	}

}
