package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.IdentityPipe;
import fr.inria.atlanmod.mogwai.gremlin.InEPipe;
import fr.inria.atlanmod.mogwai.gremlin.InVPipe;
import fr.inria.atlanmod.mogwai.gremlin.OutEPipe;
import fr.inria.atlanmod.mogwai.gremlin.OutVPipe;
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
		// InEPipe and OutVPipe types are not checked, it is already done in AllInstances test
		InEPipe inE = (InEPipe)va.getNextElement();
		OutVPipe outV = (OutVPipe)inE.getNextElement();
		// Collect iterators are mapped to IdentityPipes
		assert outV.getNextElement() instanceof IdentityPipe;
		IdentityPipe varIdPipe = (IdentityPipe)outV.getNextElement();
		// The collect reference access
		assert varIdPipe.getNextElement() instanceof OutEPipe;
		OutEPipe collectOutE = (OutEPipe)varIdPipe.getNextElement();
		assert collectOutE.getRelationshipName().equals("ownedElements");
		assert collectOutE.getNextElement() instanceof InVPipe;
		InVPipe collectInV = (InVPipe)collectOutE.getNextElement();
		// The collect Identity pipe
		assert collectInV.getNextElement() instanceof IdentityPipe;
		IdentityPipe collectIdPipe = (IdentityPipe)collectInV.getNextElement();
		assert collectIdPipe.getNextElement() == null;
	}

}
