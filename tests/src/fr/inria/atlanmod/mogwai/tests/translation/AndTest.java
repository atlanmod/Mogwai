package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.AndExpression;
import fr.inria.atlanmod.mogwai.gremlin.BooleanLiteral;

public class AndTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of and() call to Gremlin
	 * A and call generates a Gremlin binary comparison containing the translated 
	 * inner left and right expressions: <b>([inner left expression] or [inner right expression])</b>
	 * and can not be a part of a step chain
	 */
	@Test
	public void test() {
		assert gScript.getInstructions().size() == 1;
		assert gScript.getInstructions().get(0) instanceof AndExpression;
		AndExpression andExp = (AndExpression)gScript.getInstructions().get(0);
		assert andExp.getLeft() instanceof BooleanLiteral;
		assert andExp.getRight() instanceof BooleanLiteral;
		// Inner Expressions test are not important here (it is part of chaining tests)
	}

}
