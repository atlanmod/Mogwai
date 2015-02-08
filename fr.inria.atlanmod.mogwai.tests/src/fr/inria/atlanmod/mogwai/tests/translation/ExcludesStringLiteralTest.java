package fr.inria.atlanmod.mogwai.tests.translation;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.Closure;
import fr.inria.atlanmod.mogwai.gremlin.ClosureIt;
import fr.inria.atlanmod.mogwai.gremlin.EqualityExpression;
import fr.inria.atlanmod.mogwai.gremlin.FilterPipe;
import fr.inria.atlanmod.mogwai.gremlin.IdentityPipe;
import fr.inria.atlanmod.mogwai.gremlin.InEPipe;
import fr.inria.atlanmod.mogwai.gremlin.IsEmptyCall;
import fr.inria.atlanmod.mogwai.gremlin.OutVPipe;
import fr.inria.atlanmod.mogwai.gremlin.PropertyPipe;
import fr.inria.atlanmod.mogwai.gremlin.StringLiteral;
import fr.inria.atlanmod.mogwai.gremlin.ToListCall;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;

public class ExcludesStringLiteralTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of an implicit collect call on an attribute to Gremlin
	 * steps
	 * A collect call is handled by a step chain representing the access of the attribute:
	 * 	- <b>[previous steps].<property name>._()</b>
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
		// The collect attribute access
		assert varIdPipe.getNextElement() instanceof PropertyPipe;
		PropertyPipe collectProperty = (PropertyPipe)varIdPipe.getNextElement();
		assert collectProperty.getNextElement() instanceof IdentityPipe;
		IdentityPipe collectIdPipe = (IdentityPipe)collectProperty.getNextElement();
		// The filter corresponding to the exclusion
		assert collectIdPipe.getNextElement() instanceof FilterPipe;
		FilterPipe excludesFilter = (FilterPipe)collectIdPipe.getNextElement();
		assert excludesFilter.getClosure() instanceof Closure;
		Closure excludesClosure = (Closure)excludesFilter.getClosure();
		assert excludesClosure.getInstructions().size() == 1;
		assert excludesClosure.getInstructions().get(0) instanceof EqualityExpression;
		// Excludes comparison
		EqualityExpression excludesEq = (EqualityExpression)excludesClosure.getInstructions().get(0);
		assert excludesEq.getLeft() instanceof ClosureIt;
		// Left expression
		ClosureIt excludesClosureIt = (ClosureIt)excludesEq.getLeft();
		assert excludesClosureIt.getNextElement() == null;
		// Right expression
		assert excludesEq.getRight() instanceof StringLiteral;
		StringLiteral excludesStringLit = (StringLiteral)excludesEq.getRight();
		assert excludesStringLit.getValue().equals("org");
		// The chain after the filter
		assert excludesFilter.getNextElement() instanceof ToListCall;
		ToListCall excludesToList = (ToListCall)excludesFilter.getNextElement();
		assert excludesToList.getNextElement() instanceof IsEmptyCall;
		IsEmptyCall excludesIsEmpty = (IsEmptyCall)excludesToList.getNextElement();
		assert excludesIsEmpty.getNextElement() == null;
	}

}
