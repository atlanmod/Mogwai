package fr.inria.atlanmod.mogwai.tests.composition;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.EqualityExpression;
import fr.inria.atlanmod.mogwai.gremlin.IntegerLiteral;

public class NestedEqualityTest extends MogwaiCompositionTest {
	
	/**
	 * Check the translation of nested equalities from to Gremlin steps.
	 * Nested comparison operations generates a tree with a root representing
	 * the main operation in the sequence.
	 */
	@Test
	public void test() {
		assert gScript.getInstructions().size() == 1;
		assert gScript.getInstructions().get(0) instanceof EqualityExpression;
		EqualityExpression eqExp = (EqualityExpression)gScript.getInstructions().get(0);
		assert eqExp.getLeft() instanceof EqualityExpression;
		// Check left part equality
		EqualityExpression eqLeft = (EqualityExpression)eqExp.getLeft();
		// Check Inner integer literals
		assert eqLeft.getLeft() instanceof IntegerLiteral;
		IntegerLiteral intLeft1 = (IntegerLiteral)eqLeft.getLeft();
		assert intLeft1.getValue() == 1;
		assert eqLeft.getRight() instanceof IntegerLiteral;
		IntegerLiteral intLeft2 = (IntegerLiteral)eqLeft.getRight();
		assert intLeft2.getValue() == 2;
		// Check right part equality
		assert eqExp.getRight() instanceof EqualityExpression;
		EqualityExpression eqRight = (EqualityExpression)eqExp.getRight();
		assert eqRight.getLeft() instanceof IntegerLiteral;
		IntegerLiteral intRight1 = (IntegerLiteral)eqRight.getLeft();
		assert intRight1.getValue() == 3;
		assert eqRight.getRight() instanceof IntegerLiteral;
		IntegerLiteral intRight2 = (IntegerLiteral)eqRight.getRight();
		assert intRight2.getValue() == 4;
	}

}
