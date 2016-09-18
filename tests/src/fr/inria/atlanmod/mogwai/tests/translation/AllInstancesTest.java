package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class AllInstancesTest extends MogwaiTranslationTest {

	/**
	 * Check the translation of allInstances() call to Gremlin steps
	 * An allInstances call generates a step chain following this pattern:
	 * 	- [prev steps].<b>inE("kyanosInstanceOf").outV</b>
	 */
	@Test
	public void test() {
	}

}
