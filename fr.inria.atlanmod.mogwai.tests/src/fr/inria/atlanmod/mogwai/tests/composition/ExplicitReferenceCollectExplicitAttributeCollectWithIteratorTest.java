package fr.inria.atlanmod.mogwai.tests.composition;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.IdentityPipe;
import fr.inria.atlanmod.mogwai.gremlin.InEPipe;
import fr.inria.atlanmod.mogwai.gremlin.InVPipe;
import fr.inria.atlanmod.mogwai.gremlin.OutEPipe;
import fr.inria.atlanmod.mogwai.gremlin.OutVPipe;
import fr.inria.atlanmod.mogwai.gremlin.PropertyPipe;
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
		// InEPipe and OutVPipe types are not checked, it is already done in AllInstances test
		InEPipe inE = (InEPipe)va.getNextElement();
		OutVPipe outV = (OutVPipe)inE.getNextElement();
		// Collect iterators are mapped to IdentityPipes
		assert outV.getNextElement() instanceof IdentityPipe;
		IdentityPipe varIdPipe = (IdentityPipe)outV.getNextElement();
		// The collect reference access
		assert varIdPipe.getNextElement() instanceof OutEPipe;
		OutEPipe collectOutE1 = (OutEPipe)varIdPipe.getNextElement();
		assert collectOutE1.getRelationshipName().equals("ownedElements");
		assert collectOutE1.getNextElement() instanceof InVPipe;
		InVPipe collectInV1 = (InVPipe)collectOutE1.getNextElement();
		// The IdentityPipe corresponding to the end of the first collect
		assert collectInV1.getNextElement() instanceof IdentityPipe;
		IdentityPipe collectIdPipe1 = (IdentityPipe)collectInV1.getNextElement();
		// The collect attribute access
		assert collectIdPipe1.getNextElement() instanceof IdentityPipe;
		IdentityPipe collectIdPipe2 = (IdentityPipe)collectIdPipe1.getNextElement();
		assert collectIdPipe2.getNextElement() instanceof PropertyPipe;
		PropertyPipe collectPropPipe1 = (PropertyPipe)collectIdPipe2.getNextElement();
		assert collectPropPipe1.getName().equals("name");
		// The IdentityPipe corresponding to the end of the second collect
		assert collectPropPipe1.getNextElement() instanceof IdentityPipe;
		IdentityPipe collectIdPipe3 = (IdentityPipe)collectPropPipe1.getNextElement();
		assert collectIdPipe3.getNextElement() == null;
	}

}
