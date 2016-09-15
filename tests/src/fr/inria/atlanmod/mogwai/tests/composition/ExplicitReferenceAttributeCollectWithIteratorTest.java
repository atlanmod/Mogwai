package fr.inria.atlanmod.mogwai.tests.composition;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.IdentityStep;
import fr.inria.atlanmod.mogwai.gremlin.InEStep;
import fr.inria.atlanmod.mogwai.gremlin.InVStep;
import fr.inria.atlanmod.mogwai.gremlin.OutEStep;
import fr.inria.atlanmod.mogwai.gremlin.OutVStep;
import fr.inria.atlanmod.mogwai.gremlin.PropertyStep;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;

public class ExplicitReferenceAttributeCollectWithIteratorTest extends MogwaiCompositionTest {
	
	/**
	 * Check the translation of a collect on a reference and an attribute.
	 * OCL parser creates a collect iterator for the reference, and an implicit
	 * collect iterator for the attribute access. The second collect is nested in the first
	 * one.
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
		// The collect attribute access
		assert collectInV.getNextElement() instanceof IdentityStep;
		IdentityStep collectIdPipe1 = (IdentityStep)collectInV.getNextElement();
		assert collectIdPipe1.getNextElement() instanceof PropertyStep;
		PropertyStep collectProperty = (PropertyStep)collectIdPipe1.getNextElement();
		assert collectProperty.getName().equals("name");
		// The IdentityStep corresponding to the end of the nested collect
		assert collectProperty.getNextElement() instanceof IdentityStep;
		IdentityStep collectIdPipe2 = (IdentityStep)collectProperty.getNextElement();
		// The IdentityStep corresponding to the end of the top level collect
		assert collectIdPipe2.getNextElement() instanceof IdentityStep;
		IdentityStep collectIdPipe3 = (IdentityStep)collectIdPipe2.getNextElement();
		assert collectIdPipe3.getNextElement() == null;
	}

}
