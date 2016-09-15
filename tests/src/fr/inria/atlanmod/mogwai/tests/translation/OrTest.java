package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.BooleanLiteral;
import fr.inria.atlanmod.mogwai.gremlin.OrExpression;

public class OrTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of or() call to Gremlin
	 * A or call generates a Gremlin binary comparison containing the translated 
	 * inner left and right expressions: <b>([inner left expression] or [inner right expression])</b>
	 * and can not be a part of a step chain
	 */
	@Test
	public void test() {
		assert gScript.getInstructions().size() == 1;
		assert gScript.getInstructions().get(0) instanceof OrExpression;
		OrExpression orExp = (OrExpression)gScript.getInstructions().get(0);
		assert orExp.getLeft() instanceof BooleanLiteral;
		assert orExp.getRight() instanceof BooleanLiteral;
		// Inner Expressions test are not important here (it is part of chaining tests)
	}

}
