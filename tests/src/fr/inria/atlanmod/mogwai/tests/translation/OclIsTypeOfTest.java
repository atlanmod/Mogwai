package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.Closure;
import fr.inria.atlanmod.mogwai.gremlin.ClosureIt;
import fr.inria.atlanmod.mogwai.gremlin.EqualityExpression;
import fr.inria.atlanmod.mogwai.gremlin.FirstCall;
import fr.inria.atlanmod.mogwai.gremlin.IdentityStep;
import fr.inria.atlanmod.mogwai.gremlin.InEStep;
import fr.inria.atlanmod.mogwai.gremlin.InVStep;
import fr.inria.atlanmod.mogwai.gremlin.NextCall;
import fr.inria.atlanmod.mogwai.gremlin.OutEStep;
import fr.inria.atlanmod.mogwai.gremlin.OutVStep;
import fr.inria.atlanmod.mogwai.gremlin.TransformStep;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;

public class OclIsTypeOfTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of oclIsTypeOf() call to Gremlin steps
	 * An oclIsTypeOf call generates a single transform Gremlin step comparing 
	 * the out node of the outgoing "kyanosInstanceOf" relationship with the corresponding
	 * meta-node: 
	 * [previous steps].<b>transform{it.outE("kyanosInstanceOf").inV.next() == meta<ClassName>Node}</b> 
	 * The next iterator is necessary to compare nodes
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
		// IdentityStep type is not checked, it is done in AsSequence test
		IdentityStep idPipe = (IdentityStep)outV.getNextElement();
		// FirstCall type is not checked, it is done in First test
		FirstCall first = (FirstCall)idPipe.getNextElement();
		assert first.getNextElement() instanceof TransformStep;
		TransformStep trPipe = (TransformStep)first.getNextElement();
		assert trPipe.getClosure() instanceof Closure;
		Closure closure = trPipe.getClosure();
		assert closure.getInstructions().size() == 1;
		assert closure.getInstructions().get(0) instanceof EqualityExpression;
		EqualityExpression eqExp = (EqualityExpression)closure.getInstructions().get(0);
		// Check left part of equality
		assert eqExp.getLeft() instanceof ClosureIt;
		ClosureIt closureIt = (ClosureIt)eqExp.getLeft();
		assert closureIt.getNextElement() instanceof OutEStep;
		OutEStep trOutE = (OutEStep)closureIt.getNextElement();
		assert trOutE.getNextElement() instanceof InVStep;
		InVStep trInV = (InVStep)trOutE.getNextElement();
		assert trInV.getNextElement() instanceof NextCall;
		NextCall trLestNext = (NextCall)trInV.getNextElement();
		assert trLestNext.getNextElement() == null;
		// Check right part of the equality
		assert eqExp.getRight() instanceof VariableAccess;
		VariableAccess trVa = (VariableAccess)eqExp.getRight();
		assert trVa.getName().equals("metaPackageNode");
		assert trVa.getNextElement() == null;
		
		// Check the transform closure is followed by a next call to return the 
		// boolean value of the comparison
		assert trPipe.getNextElement() instanceof NextCall;
		NextCall trNext = (NextCall)trPipe.getNextElement();
		// Check the next call is the last generated
		assert trNext.getNextElement() == null;
		
		
	}

}
