package fr.inria.atlanmod.mogwai.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.inria.atlanmod.mogwai.tests.translation.AllInstancesTest;
import fr.inria.atlanmod.mogwai.tests.translation.AndTest;
import fr.inria.atlanmod.mogwai.tests.translation.AsSequenceTest;
import fr.inria.atlanmod.mogwai.tests.translation.AttributeExistsWithIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.AttributeExistsWithoutIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.AttributeForallWithIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.AttributeForallWithoutIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.AttributeRejectWithIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.AttributeRejectWithoutIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.AttributeSelectWithIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.AttributeSelectWithoutIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.DifferentTest;
import fr.inria.atlanmod.mogwai.tests.translation.EmptyStringLiteralTest;
import fr.inria.atlanmod.mogwai.tests.translation.EqualityTest;
import fr.inria.atlanmod.mogwai.tests.translation.ExcludesStringLiteralTest;
import fr.inria.atlanmod.mogwai.tests.translation.ExplicitAttributeCollectWithIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.ExplicitAttributeCollectWithoutIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.ExplicitReferenceCollectWithIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.ExplicitReferenceCollectWithoutIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.FalseBooleanLiteralTest;
import fr.inria.atlanmod.mogwai.tests.translation.FirstTest;
import fr.inria.atlanmod.mogwai.tests.translation.GreaterOrEqualTest;
import fr.inria.atlanmod.mogwai.tests.translation.GreaterTest;
import fr.inria.atlanmod.mogwai.tests.translation.ImplicitAttributeCollectTest;
import fr.inria.atlanmod.mogwai.tests.translation.ImplicitReferenceCollectTest;
import fr.inria.atlanmod.mogwai.tests.translation.IsEmptyTest;
import fr.inria.atlanmod.mogwai.tests.translation.LessOrEqualTest;
import fr.inria.atlanmod.mogwai.tests.translation.LessTest;
import fr.inria.atlanmod.mogwai.tests.translation.NegativeIntegerLiteralTest;
import fr.inria.atlanmod.mogwai.tests.translation.NegativeRealLiteralTest;
import fr.inria.atlanmod.mogwai.tests.translation.NotTest;
import fr.inria.atlanmod.mogwai.tests.translation.OclAsTypeTest;
import fr.inria.atlanmod.mogwai.tests.translation.OclIsTypeOfTest;
import fr.inria.atlanmod.mogwai.tests.translation.OrTest;
import fr.inria.atlanmod.mogwai.tests.translation.PositiveIntegerLiteralTest;
import fr.inria.atlanmod.mogwai.tests.translation.PositiveRealLiteralTest;
import fr.inria.atlanmod.mogwai.tests.translation.ReferenceExistsWithIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.ReferenceExistsWithoutIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.ReferenceForallWithIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.ReferenceForallWithoutIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.ReferenceRejectWithIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.ReferenceRejectWithoutIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.ReferenceSelectWithIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.ReferenceSelectWithoutIteratorTest;
import fr.inria.atlanmod.mogwai.tests.translation.SizeTest;
import fr.inria.atlanmod.mogwai.tests.translation.StringLiteralTest;
import fr.inria.atlanmod.mogwai.tests.translation.TrueBooleanLiteralTest;
import fr.inria.atlanmod.mogwai.tests.translation.TypeAccessTest;

@RunWith(Suite.class)
@SuiteClasses({
	TypeAccessTest.class,
	AllInstancesTest.class,
	IsEmptyTest.class,
	AsSequenceTest.class,
	SizeTest.class,
	FirstTest.class,
	StringLiteralTest.class,
	EmptyStringLiteralTest.class,
	TrueBooleanLiteralTest.class,
	FalseBooleanLiteralTest.class,
	PositiveIntegerLiteralTest.class,
	NegativeIntegerLiteralTest.class,
	PositiveRealLiteralTest.class,
	NegativeRealLiteralTest.class,
	NotTest.class,
	OrTest.class,
	AndTest.class,
	EqualityTest.class,
	DifferentTest.class,
	GreaterTest.class,
	GreaterOrEqualTest.class,
	LessTest.class,
	LessOrEqualTest.class,
	OclAsTypeTest.class,
	OclIsTypeOfTest.class,
	AttributeExistsWithIteratorTest.class,
	AttributeExistsWithoutIteratorTest.class,
	ReferenceExistsWithIteratorTest.class,
	ReferenceExistsWithoutIteratorTest.class,
	ExplicitAttributeCollectWithIteratorTest.class,
	ImplicitAttributeCollectTest.class,
	ExplicitAttributeCollectWithoutIteratorTest.class,
	ExplicitReferenceCollectWithIteratorTest.class,
	ImplicitReferenceCollectTest.class,
	ExplicitReferenceCollectWithoutIteratorTest.class,
	AttributeSelectWithIteratorTest.class,
	AttributeSelectWithoutIteratorTest.class,
	ReferenceSelectWithIteratorTest.class,
	ReferenceSelectWithoutIteratorTest.class,
	AttributeRejectWithIteratorTest.class,
	AttributeRejectWithoutIteratorTest.class,
	ReferenceRejectWithIteratorTest.class,
	ReferenceRejectWithoutIteratorTest.class,
	AttributeForallWithIteratorTest.class,
	AttributeForallWithoutIteratorTest.class,
	ReferenceForallWithIteratorTest.class,
	ReferenceForallWithoutIteratorTest.class,
	ExcludesStringLiteralTest.class
})
public class MogwaiTranslationTestSuite {

}
