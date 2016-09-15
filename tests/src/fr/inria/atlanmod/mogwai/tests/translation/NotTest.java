package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.BooleanLiteral;
import fr.inria.atlanmod.mogwai.gremlin.NotExpression;

public class NotTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of not() call to Gremlin
	 * A not call generates a Gremlin unary comparison containing the translated 
	 * inner expression: <b>!([inner expression])</b> and can not
	 * be a part of a step chain
	 */
	@Test
	public void test() {
		assert gScript.getInstructions().size() == 1;
		assert gScript.getInstructions().get(0) instanceof NotExpression;
		NotExpression notExp = (NotExpression)gScript.getInstructions().get(0);
		assert notExp.getExp() instanceof BooleanLiteral;
		// Inner Expression test is not important here (it is part of chaining tests)
	}

}
