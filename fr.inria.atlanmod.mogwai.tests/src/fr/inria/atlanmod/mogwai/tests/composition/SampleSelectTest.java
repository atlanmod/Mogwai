package fr.inria.atlanmod.mogwai.tests.composition;

import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.IdentityStep;
import fr.inria.atlanmod.mogwai.gremlin.InEStep;
import fr.inria.atlanmod.mogwai.gremlin.InVStep;
import fr.inria.atlanmod.mogwai.gremlin.OutEStep;
import fr.inria.atlanmod.mogwai.gremlin.OutVStep;
import fr.inria.atlanmod.mogwai.gremlin.PropertyStep;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;

public class SampleSelectTest extends MogwaiCompositionTest {
	
	/**
	 * Check the translation of a collect on a reference and an attribute.
	 * OCL parser creates a collect iterator for the reference, and an implicit
	 * collect iterator for the attribute access. The second collect is nested in the first
	 * one.
	 */
	@Test
	public void test() {
		System.out.println("Sample Select");
	}

}
