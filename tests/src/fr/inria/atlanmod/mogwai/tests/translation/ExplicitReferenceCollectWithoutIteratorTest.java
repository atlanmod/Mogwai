package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.IdentityStep;
import fr.inria.atlanmod.mogwai.gremlin.InEStep;
import fr.inria.atlanmod.mogwai.gremlin.InVStep;
import fr.inria.atlanmod.mogwai.gremlin.OutEStep;
import fr.inria.atlanmod.mogwai.gremlin.OutVStep;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;

public class ExplicitReferenceCollectWithoutIteratorTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of an collect() call on a reference without iterator
	 * to Gremlin steps
	 * A collect call is handled by a step chain representing the access to the referred nodes:
	 * 	- <b>[previous steps].outE(<relationship name>).inV._()</b>
	 * Identity pipe is generated to match the collect object itself, it does not change the
	 * result 
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
		// Collect iterators are mapped to IdentitySteps
		assert outV.getNextElement() instanceof IdentityStep;
		IdentityStep varIdPipe = (IdentityStep)outV.getNextElement();
		// The collect reference access
		assert varIdPipe.getNextElement() instanceof OutEStep;
		OutEStep collectOutE = (OutEStep)varIdPipe.getNextElement();
		assert collectOutE.getRelationshipName().equals("ownedElements");
		assert collectOutE.getNextElement() instanceof InVStep;
		InVStep collectInV = (InVStep)collectOutE.getNextElement();
		// The collect Identity pipe
		assert collectInV.getNextElement() instanceof IdentityStep;
		IdentityStep collectIdPipe = (IdentityStep)collectInV.getNextElement();
		assert collectIdPipe.getNextElement() == null;
	}

}
