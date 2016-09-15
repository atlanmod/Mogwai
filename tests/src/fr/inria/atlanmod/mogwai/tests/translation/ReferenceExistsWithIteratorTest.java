package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.Closure;
import fr.inria.atlanmod.mogwai.gremlin.ClosureIt;
import fr.inria.atlanmod.mogwai.gremlin.FilterStep;
import fr.inria.atlanmod.mogwai.gremlin.HasNextCall;
import fr.inria.atlanmod.mogwai.gremlin.InEStep;
import fr.inria.atlanmod.mogwai.gremlin.InVStep;
import fr.inria.atlanmod.mogwai.gremlin.IsEmptyCall;
import fr.inria.atlanmod.mogwai.gremlin.OutEStep;
import fr.inria.atlanmod.mogwai.gremlin.OutVStep;
import fr.inria.atlanmod.mogwai.gremlin.ToListCall;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;
import fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration;

public class ReferenceExistsWithIteratorTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of an exists() call with a declared iterator to Gremlin steps
	 * An exists call generates a Gremlin filter step containing the
	 * exists body and a hasNext call to get the boolean value if a comparison is needed: 
	 * [previous steps].<b>filter{<exists body>}.hasNext()</b>
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
		FilterStep filter = (FilterStep)outV.getNextElement();
		assert filter.getClosure() instanceof Closure;
		// Check the content of the closure
		Closure cl = (Closure)filter.getClosure();
		assert cl.getInstructions().size() == 2;
		// Check the local iterator declaration
		assert cl.getInstructions().get(0) instanceof VariableDeclaration;
		VariableDeclaration vd1 = (VariableDeclaration)cl.getInstructions().get(0);
		assert vd1.getName().equals("each");
		assert vd1.getValue() instanceof ClosureIt;
		ClosureIt clIt1 = (ClosureIt)vd1.getValue();
		assert clIt1.getNextElement() == null;
		// Check the boolean comparison
		assert cl.getInstructions().get(1) instanceof VariableAccess;
		VariableAccess vaClos = (VariableAccess)cl.getInstructions().get(1);
		assert vaClos.getName().equals("each");
		assert vaClos.getNextElement() instanceof OutEStep;
		OutEStep outEClos = (OutEStep)vaClos.getNextElement();
		assert outEClos.getRelationshipName().equals("bodyDeclarations");
		assert outEClos.getNextElement() instanceof InVStep;
		InVStep inVClos = (InVStep)outEClos.getNextElement();
		assert inVClos.getNextElement() instanceof ToListCall;
		ToListCall toListClos = (ToListCall)inVClos.getNextElement();
		assert toListClos.getNextElement() instanceof IsEmptyCall;
		IsEmptyCall isEmptyClos = (IsEmptyCall)toListClos.getNextElement();
		assert isEmptyClos.getNextElement() == null;
		// Check the next element of the transform pipe
		assert filter.getNextElement() instanceof HasNextCall;
		HasNextCall hasNextCall = (HasNextCall)filter.getNextElement();
		assert hasNextCall.getNextElement() == null;
		
	}

}
