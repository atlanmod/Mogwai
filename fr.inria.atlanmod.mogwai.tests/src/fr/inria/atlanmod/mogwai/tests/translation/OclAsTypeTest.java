package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class OclAsTypeTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of oclAsType() call to Gremlin steps
	 * An oclAsType call generates a single identity Gremlin step: 
	 * [previous steps].<b>_()</b> because type casting does not have
	 * a signification in the database schema
	 */
	@Test
	public void test() {
	}

}
