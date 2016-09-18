package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class TypeAccessTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of TypeAccess to Gremlin steps
	 * A TypeAccess generates 3 instructions following those patterns:
	 * 	- A variable declaration to store the result of the corresponding index query
	 * 		- <b>def meta<ClassName> = g.idx("metaclasses")[[name:"<ClassName>"]];</b>
	 * 	- A variable declaration to store the node containing the meta class
	 * 		- <b>def meta<ClassName>Node = meta<ClassName>.next();</b>
	 * 	- A variable access that return the node containing the meta class
	 * 		- <b>meta<ClassName>Node.[next steps]</b>
	 */
	@Test
	public void test() {
	}

}
