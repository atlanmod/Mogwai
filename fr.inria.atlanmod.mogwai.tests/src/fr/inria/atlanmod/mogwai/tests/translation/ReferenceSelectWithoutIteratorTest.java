package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.Closure;
import fr.inria.atlanmod.mogwai.gremlin.ClosureIt;
import fr.inria.atlanmod.mogwai.gremlin.FilterPipe;
import fr.inria.atlanmod.mogwai.gremlin.InEPipe;
import fr.inria.atlanmod.mogwai.gremlin.InVPipe;
import fr.inria.atlanmod.mogwai.gremlin.IsEmptyCall;
import fr.inria.atlanmod.mogwai.gremlin.OutEPipe;
import fr.inria.atlanmod.mogwai.gremlin.OutVPipe;
import fr.inria.atlanmod.mogwai.gremlin.ToListCall;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;
import fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration;

public class ReferenceSelectWithoutIteratorTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of a select() call on a reference without iterator 
	 * to Gremlin steps
	 * A select call on a reference generates a Gremlin filter step containing the
	 * select body that access the referred node:
	 * [previous steps].<b>filter{<select body>}</b>
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
		// Check the filter pipe associated to the select() call
		assert outV.getNextElement() instanceof FilterPipe;
		FilterPipe filterPipe = (FilterPipe)outV.getNextElement();
		// Check the filter closure
		assert filterPipe.getClosure() instanceof Closure;
		// Check the content of the closure
		Closure filterClosure = (Closure)filterPipe.getClosure();
		assert filterClosure.getInstructions().size() == 2;
		// Check the local iterator declaration
		assert filterClosure.getInstructions().get(0) instanceof VariableDeclaration;
		VariableDeclaration vaClosure = (VariableDeclaration)filterClosure.getInstructions().get(0);
		assert vaClosure.getName().equals("temp1");
		assert vaClosure.getValue() instanceof ClosureIt;
		ClosureIt vaClosureIt = (ClosureIt)vaClosure.getValue();
		assert vaClosureIt.getNextElement() == null;
		// Check the boolean expression
		assert filterClosure.getInstructions().get(1) instanceof VariableAccess;
		VariableAccess vaBoolExp = (VariableAccess)filterClosure.getInstructions().get(1);
		assert vaBoolExp.getName().equals("temp1");
		// Relationship access in boolean expression
		assert vaBoolExp.getNextElement() instanceof OutEPipe;
		OutEPipe outEBoolExp= (OutEPipe)vaBoolExp.getNextElement();
		assert outEBoolExp.getRelationshipName().equals("ownedElements");
		assert outEBoolExp.getNextElement() instanceof InVPipe;
		// Referred vertices access in boolean expression
		InVPipe inVBoolExp = (InVPipe)outEBoolExp.getNextElement();
		// IsEmpty translation
		assert inVBoolExp.getNextElement() instanceof ToListCall;
		ToListCall toListBoolExp = (ToListCall)inVBoolExp.getNextElement();
		assert toListBoolExp.getNextElement() instanceof IsEmptyCall;
		IsEmptyCall isEmptyBoolExp = (IsEmptyCall)toListBoolExp.getNextElement();
		assert isEmptyBoolExp.getNextElement() == null;
		// Check there is nothing generated after the filter pipe
		assert filterPipe.getNextElement() == null;
	}

}
