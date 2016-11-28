package fr.inria.atlanmod.mogwai.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.inria.atlanmod.mogwai.tests.composition.EnumEqualityTest;
import fr.inria.atlanmod.mogwai.tests.composition.ExplicitReferenceAttributeCollectWithIteratorTest;
import fr.inria.atlanmod.mogwai.tests.composition.ExplicitReferenceCollectExplicitAttributeCollectWithIteratorTest;
import fr.inria.atlanmod.mogwai.tests.composition.NestedAndTest;
import fr.inria.atlanmod.mogwai.tests.composition.NestedEqualityTest;

@RunWith(Suite.class)
@SuiteClasses({
	EnumEqualityTest.class,
	ExplicitReferenceAttributeCollectWithIteratorTest.class,
	ExplicitReferenceCollectExplicitAttributeCollectWithIteratorTest.class,
	NestedAndTest.class, NestedEqualityTest.class
})
public class MogwaiCompositionTestSuite {

}
