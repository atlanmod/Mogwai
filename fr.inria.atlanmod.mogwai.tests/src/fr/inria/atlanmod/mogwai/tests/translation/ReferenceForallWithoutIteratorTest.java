package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.Closure;
import fr.inria.atlanmod.mogwai.gremlin.ClosureIt;
import fr.inria.atlanmod.mogwai.gremlin.FilterPipe;
import fr.inria.atlanmod.mogwai.gremlin.InEPipe;
import fr.inria.atlanmod.mogwai.gremlin.InVPipe;
import fr.inria.atlanmod.mogwai.gremlin.IsEmptyCall;
import fr.inria.atlanmod.mogwai.gremlin.NotExpression;
import fr.inria.atlanmod.mogwai.gremlin.OutEPipe;
import fr.inria.atlanmod.mogwai.gremlin.OutVPipe;
import fr.inria.atlanmod.mogwai.gremlin.ToListCall;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;
import fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration;

public class ReferenceForallWithoutIteratorTest extends MogwaiTranslationTest {
	
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
		// InEPipe and OutVPipe types are not checked, it is already done in AllInstances test
		InEPipe inE = (InEPipe)va.getNextElement();
		OutVPipe outV = (OutVPipe)inE.getNextElement();
		assert outV.getNextElement() instanceof FilterPipe;
		FilterPipe tran = (FilterPipe)outV.getNextElement();
		assert tran.getClosure() instanceof Closure;
		// Check the content of the closure
		Closure cl = (Closure)tran.getClosure();
		assert cl.getInstructions().size() == 2;
		// Check the local iterator declaration
		assert cl.getInstructions().get(0) instanceof VariableDeclaration;
		VariableDeclaration vd1 = (VariableDeclaration)cl.getInstructions().get(0);
		assert vd1.getName().equals("temp1");
		assert vd1.getValue() instanceof ClosureIt;
		ClosureIt clIt1 = (ClosureIt)vd1.getValue();
		assert clIt1.getNextElement() == null;
		// Check the negative expression
		assert cl.getInstructions().get(1) instanceof NotExpression;
		NotExpression clNot = (NotExpression)cl.getInstructions().get(1);
		// Check the comparison in the negative expression
		assert clNot.getExp() instanceof VariableAccess;
		VariableAccess vaBoolExp = (VariableAccess)clNot.getExp();
		assert vaBoolExp.getName().equals("temp1");
		// Relationship access in boolean expression
		assert vaBoolExp.getNextElement() instanceof OutEPipe;
		OutEPipe outEBoolExp= (OutEPipe)vaBoolExp.getNextElement();
		assert outEBoolExp.getRelationshipName().equals("bodyDeclarations");
		assert outEBoolExp.getNextElement() instanceof InVPipe;
		// Referred vertices access in boolean expression
		InVPipe inVBoolExp = (InVPipe)outEBoolExp.getNextElement();
		// IsEmpty translation
		assert inVBoolExp.getNextElement() instanceof ToListCall;
		ToListCall toListBoolExp = (ToListCall)inVBoolExp.getNextElement();
		assert toListBoolExp.getNextElement() instanceof IsEmptyCall;
		IsEmptyCall isEmptyBoolExp = (IsEmptyCall)toListBoolExp.getNextElement();
		assert isEmptyBoolExp.getNextElement() == null;
		// Check the next element of the filter pipe
		assert tran.getNextElement() instanceof ToListCall;
		ToListCall toListCall = (ToListCall)tran.getNextElement();
		assert toListCall.getNextElement() instanceof IsEmptyCall;
		IsEmptyCall isEmptyCall = (IsEmptyCall)toListCall.getNextElement();
		assert isEmptyCall.getNextElement() == null;
		
	}

}
