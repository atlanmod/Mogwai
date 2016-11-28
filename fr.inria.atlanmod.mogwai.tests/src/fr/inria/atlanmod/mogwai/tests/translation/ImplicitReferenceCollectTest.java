package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

public class ImplicitReferenceCollectTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of an implicit collect() call on a reference 
	 * to Gremlin steps
	 * A collect call is handled by a step chain representing the access to the referred nodes:
	 * 	- <b>[previous steps].outE(<relationship name>).inV._()</b>
	 * Identity pipe is generated to match the collect object itself, it does not change the
	 * result 
	 */
	@Test
	public void test() {
	}

}
