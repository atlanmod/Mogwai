package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.Closure;
import fr.inria.atlanmod.mogwai.gremlin.ClosureIt;
import fr.inria.atlanmod.mogwai.gremlin.EqualityExpression;
import fr.inria.atlanmod.mogwai.gremlin.FilterStep;
import fr.inria.atlanmod.mogwai.gremlin.InEStep;
import fr.inria.atlanmod.mogwai.gremlin.IsEmptyCall;
import fr.inria.atlanmod.mogwai.gremlin.NotExpression;
import fr.inria.atlanmod.mogwai.gremlin.OutVStep;
import fr.inria.atlanmod.mogwai.gremlin.PropertyStep;
import fr.inria.atlanmod.mogwai.gremlin.StringLiteral;
import fr.inria.atlanmod.mogwai.gremlin.ToListCall;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;
import fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration;

public class AttributeForallWithIteratorTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of an forAll() call with a declared iterator to Gremlin steps
	 * A forAll call generates a Gremlin filter step containing the
	 * forAll body in a negative expression. The overall results is calculated by an isEmpty
	 * call: 
	 * [previous steps].<b>filter{!<forall body>}.toList().isEmpty()</b>
	 */
	@Test
	public void test() {
		assert gScript.getInstructions().size() == 3;
		// Ignore 1st and 2nd instructions, they are the same as in TypeAccess test
		assert gScript.getInstructions().get(2) instanceof VariableAccess;
		VariableAccess va = (VariableAccess)gScript.getInstructions().get(2);
		// Do not check the name of the variable access, it is already done in TypeAccess test
		// InEStep and OutVStep types are not checked, it is already done in AllInstances test
		InEStep inE = (InEStep)va.getNextElement();
		OutVStep outV = (OutVStep)inE.getNextElement();
		assert outV.getNextElement() instanceof FilterStep;
		FilterStep tran = (FilterStep)outV.getNextElement();
		assert tran.getClosure() instanceof Closure;
		// Check the content of the closure
		Closure cl = (Closure)tran.getClosure();
		assert cl.getInstructions().size() == 2;
		// Check the local iterator declaration
		assert cl.getInstructions().get(0) instanceof VariableDeclaration;
		VariableDeclaration vd1 = (VariableDeclaration)cl.getInstructions().get(0);
		assert vd1.getName().equals("each");
		assert vd1.getValue() instanceof ClosureIt;
		ClosureIt clIt1 = (ClosureIt)vd1.getValue();
		assert clIt1.getNextElement() == null;
		// Check the negative expression
		assert cl.getInstructions().get(1) instanceof NotExpression;
		NotExpression clNot = (NotExpression)cl.getInstructions().get(1);
		// Check the comparison in the negative expression
		assert clNot.getExp() instanceof EqualityExpression;
		EqualityExpression eq1 = (EqualityExpression)clNot.getExp();
		// Check equality left part
		assert eq1.getLeft() instanceof VariableAccess;
		VariableAccess va2Left = (VariableAccess)eq1.getLeft();
		assert va2Left.getName().equals("each");
		assert va2Left.getNextElement() instanceof PropertyStep;
		PropertyStep pPipe2Left = (PropertyStep)va2Left.getNextElement();
		assert pPipe2Left.getName().equals("name");
		assert pPipe2Left.getNextElement() == null;
		// Check equality right part
		assert eq1.getRight() instanceof StringLiteral;
		StringLiteral stringLitRight = (StringLiteral)eq1.getRight();
		assert stringLitRight.getValue().equals("Format");
		// Check the next element of the filter pipe
		assert tran.getNextElement() instanceof ToListCall;
		ToListCall toListCall = (ToListCall)tran.getNextElement();
		assert toListCall.getNextElement() instanceof IsEmptyCall;
		IsEmptyCall isEmptyCall = (IsEmptyCall)toListCall.getNextElement();
		assert isEmptyCall.getNextElement() == null;
		
	}

}
