package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.DifferenceExpression;
import fr.inria.atlanmod.mogwai.gremlin.IntegerLiteral;

public class DifferentTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of <>() call to Gremlin
	 * A <> call generates a Gremlin binary comparison containing the translated 
	 * inner left and right expressions: <b>([inner left expression] or [inner right expression])</b>
	 * and can not be a part of a step chain
	 */
	@Test
	public void test() {
		assert gScript.getInstructions().size() == 1;
		assert gScript.getInstructions().get(0) instanceof DifferenceExpression;
		DifferenceExpression difExp = (DifferenceExpression)gScript.getInstructions().get(0);
		assert difExp.getLeft() instanceof IntegerLiteral;
		assert difExp.getRight() instanceof IntegerLiteral;
		// Inner Expressions test are not important here (it is part of chaining tests)
	}

}
