package fr.inria.atlanmod.mogwai.tests.composition;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.EqualityExpression;
import fr.inria.atlanmod.mogwai.gremlin.IntegerLiteral;

public class EnumEqualityTest extends MogwaiCompositionTest {
	
	/**
	 * Check the translation of nested equalities from to Gremlin steps.
	 * Nested comparison operations generates a tree with a root representing
	 * the main operation in the sequence.
	 */
	@Test
	public void test() {
		System.out.println(gScript.getName());
		System.out.println(gScript.toString());
	}

}
