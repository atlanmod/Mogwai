package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.Closure;
import fr.inria.atlanmod.mogwai.gremlin.ClosureIt;
import fr.inria.atlanmod.mogwai.gremlin.FilterStep;
import fr.inria.atlanmod.mogwai.gremlin.InEStep;
import fr.inria.atlanmod.mogwai.gremlin.InVStep;
import fr.inria.atlanmod.mogwai.gremlin.IsEmptyCall;
import fr.inria.atlanmod.mogwai.gremlin.NotExpression;
import fr.inria.atlanmod.mogwai.gremlin.OutEStep;
import fr.inria.atlanmod.mogwai.gremlin.OutVStep;
import fr.inria.atlanmod.mogwai.gremlin.ToListCall;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;
import fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration;

public class ReferenceRejectWithIteratorTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of a reject() call on an attribute with a declared iterator 
	 * to Gremlin steps
	 * A reject call generates a Gremlin filter step containing the
	 * select body that access the referred node in a negative expression:
	 * [previous steps].<b>filter{!<select body>}</b>
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
		// Check the filter pipe associated to the select() call
		assert outV.getNextElement() instanceof FilterStep;
		FilterStep FilterStep = (FilterStep)outV.getNextElement();
		// Check the filter closure
		assert FilterStep.getClosure() instanceof Closure;
		// Check the content of the closure
		Closure filterClosure = (Closure)FilterStep.getClosure();
		assert filterClosure.getInstructions().size() == 2;
		// Check the local iterator declaration
		assert filterClosure.getInstructions().get(0) instanceof VariableDeclaration;
		VariableDeclaration vaClosure = (VariableDeclaration)filterClosure.getInstructions().get(0);
		assert vaClosure.getName().equals("each");
		assert vaClosure.getValue() instanceof ClosureIt;
		ClosureIt vaClosureIt = (ClosureIt)vaClosure.getValue();
		assert vaClosureIt.getNextElement() == null;
		// Check the negative expression
		assert filterClosure.getInstructions().get(1) instanceof NotExpression;
		NotExpression closureNot = (NotExpression)filterClosure.getInstructions().get(1);
		// Check the inner expression
		assert closureNot.getExp() instanceof VariableAccess;
		VariableAccess vaBoolExp = (VariableAccess)closureNot.getExp();
		assert vaBoolExp.getName().equals("each");
		// Relationship access in boolean expression
		assert vaBoolExp.getNextElement() instanceof OutEStep;
		OutEStep outEBoolExp= (OutEStep)vaBoolExp.getNextElement();
		assert outEBoolExp.getRelationshipName().equals("ownedElements");
		assert outEBoolExp.getNextElement() instanceof InVStep;
		// Referred vertices access in boolean expression
		InVStep inVBoolExp = (InVStep)outEBoolExp.getNextElement();
		// IsEmpty translation
		assert inVBoolExp.getNextElement() instanceof ToListCall;
		ToListCall toListBoolExp = (ToListCall)inVBoolExp.getNextElement();
		assert toListBoolExp.getNextElement() instanceof IsEmptyCall;
		IsEmptyCall isEmptyBoolExp = (IsEmptyCall)toListBoolExp.getNextElement();
		assert isEmptyBoolExp.getNextElement() == null;
		// Check there is nothing generated after the filter pipe
		assert FilterStep.getNextElement() == null;
	}

}
