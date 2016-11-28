package fr.inria.atlanmod.mogwai.tests.composition;

import org.junit.Test;

public class ExplicitReferenceAttributeCollectWithIteratorTest extends MogwaiCompositionTest {
	
	/**
	 * Check the translation of a collect on a reference and an attribute.
	 * OCL parser creates a collect iterator for the reference, and an implicit
	 * collect iterator for the attribute access. The second collect is nested in the first
	 * one.
	 */
	@Test
	public void test() {
	}

}
