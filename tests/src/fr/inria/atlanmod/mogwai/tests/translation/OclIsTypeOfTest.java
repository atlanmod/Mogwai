package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class OclIsTypeOfTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of oclIsTypeOf() call to Gremlin steps
	 * An oclIsTypeOf call generates a single transform Gremlin step comparing 
	 * the out node of the outgoing "kyanosInstanceOf" relationship with the corresponding
	 * meta-node: 
	 * [previous steps].<b>transform{it.outE("kyanosInstanceOf").inV.next() == meta<ClassName>Node}</b> 
	 * The next iterator is necessary to compare nodes
	 */
	@Test
	public void test() {
	}

}
