package fr.inria.atlanmod.mogwai.tests.composition;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.IdentityPipe;
import fr.inria.atlanmod.mogwai.gremlin.InEPipe;
import fr.inria.atlanmod.mogwai.gremlin.InVPipe;
import fr.inria.atlanmod.mogwai.gremlin.OutEPipe;
import fr.inria.atlanmod.mogwai.gremlin.OutVPipe;
import fr.inria.atlanmod.mogwai.gremlin.PropertyPipe;
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
		// The collect attribute access
		assert collectInV.getNextElement() instanceof IdentityPipe;
		IdentityPipe collectIdPipe1 = (IdentityPipe)collectInV.getNextElement();
		assert collectIdPipe1.getNextElement() instanceof PropertyPipe;
		PropertyPipe collectProperty = (PropertyPipe)collectIdPipe1.getNextElement();
		assert collectProperty.getName().equals("name");
		// The IdentityPipe corresponding to the end of the nested collect
		assert collectProperty.getNextElement() instanceof IdentityPipe;
		IdentityPipe collectIdPipe2 = (IdentityPipe)collectProperty.getNextElement();
		// The IdentityPipe corresponding to the end of the top level collect
		assert collectIdPipe2.getNextElement() instanceof IdentityPipe;
		IdentityPipe collectIdPipe3 = (IdentityPipe)collectIdPipe2.getNextElement();
		assert collectIdPipe3.getNextElement() == null;
	}

}
