package fr.inria.atlanmod.mogwai.tests.composition;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.IdentityStep;
import fr.inria.atlanmod.mogwai.gremlin.InEStep;
import fr.inria.atlanmod.mogwai.gremlin.InVStep;
import fr.inria.atlanmod.mogwai.gremlin.OutEStep;
import fr.inria.atlanmod.mogwai.gremlin.OutVStep;
import fr.inria.atlanmod.mogwai.gremlin.PropertyStep;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;

public class ExplicitReferenceCollectExplicitAttributeCollectWithIteratorTest extends MogwaiCompositionTest {
	
	/**
	 * Check the translation of 2 linked collec calls. The first one access
	 * a reference and the second one an attribute.
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
		OutEStep collectOutE1 = (OutEStep)varIdPipe.getNextElement();
		assert collectOutE1.getRelationshipName().equals("ownedElements");
		assert collectOutE1.getNextElement() instanceof InVStep;
		InVStep collectInV1 = (InVStep)collectOutE1.getNextElement();
		// The IdentityStep corresponding to the end of the first collect
		assert collectInV1.getNextElement() instanceof IdentityStep;
		IdentityStep collectIdPipe1 = (IdentityStep)collectInV1.getNextElement();
		// The collect attribute access
		assert collectIdPipe1.getNextElement() instanceof IdentityStep;
		IdentityStep collectIdPipe2 = (IdentityStep)collectIdPipe1.getNextElement();
		assert collectIdPipe2.getNextElement() instanceof PropertyStep;
		PropertyStep collectPropPipe1 = (PropertyStep)collectIdPipe2.getNextElement();
		assert collectPropPipe1.getName().equals("name");
		// The IdentityStep corresponding to the end of the second collect
		assert collectPropPipe1.getNextElement() instanceof IdentityStep;
		IdentityStep collectIdPipe3 = (IdentityStep)collectPropPipe1.getNextElement();
		assert collectIdPipe3.getNextElement() == null;
	}

}
