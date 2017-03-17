/**
 */
package fr.inria.atlanmod.mogwai.gremlin;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage
 * @generated
 */
public interface GremlinFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GremlinFactory eINSTANCE = fr.inria.atlanmod.mogwai.gremlin.impl.GremlinFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Script</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Script</em>'.
	 * @generated
	 */
	GremlinScript createGremlinScript();

	/**
	 * Returns a new object of class '<em>Method Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Declaration</em>'.
	 * @generated
	 */
	MethodDeclaration createMethodDeclaration();

	/**
	 * Returns a new object of class '<em>List Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Declaration</em>'.
	 * @generated
	 */
	ListDeclaration createListDeclaration();

	/**
	 * Returns a new object of class '<em>Set Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Declaration</em>'.
	 * @generated
	 */
	SetDeclaration createSetDeclaration();

	/**
	 * Returns a new object of class '<em>Sorted Set Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sorted Set Declaration</em>'.
	 * @generated
	 */
	SortedSetDeclaration createSortedSetDeclaration();

	/**
	 * Returns a new object of class '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Declaration</em>'.
	 * @generated
	 */
	VariableDeclaration createVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Collection Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Definition</em>'.
	 * @generated
	 */
	CollectionDefinition createCollectionDefinition();

	/**
	 * Returns a new object of class '<em>Closure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Closure</em>'.
	 * @generated
	 */
	Closure createClosure();

	/**
	 * Returns a new object of class '<em>Closure It</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Closure It</em>'.
	 * @generated
	 */
	ClosureIt createClosureIt();

	/**
	 * Returns a new object of class '<em>Variable Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Access</em>'.
	 * @generated
	 */
	VariableAccess createVariableAccess();

	/**
	 * Returns a new object of class '<em>Identity Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identity Step</em>'.
	 * @generated
	 */
	IdentityStep createIdentityStep();

	/**
	 * Returns a new object of class '<em>Fill Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fill Step</em>'.
	 * @generated
	 */
	FillStep createFillStep();

	/**
	 * Returns a new object of class '<em>Start Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start Step</em>'.
	 * @generated
	 */
	StartStep createStartStep();

	/**
	 * Returns a new object of class '<em>Vertices Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vertices Step</em>'.
	 * @generated
	 */
	VerticesStep createVerticesStep();

	/**
	 * Returns a new object of class '<em>Edges Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edges Step</em>'.
	 * @generated
	 */
	EdgesStep createEdgesStep();

	/**
	 * Returns a new object of class '<em>Property Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Step</em>'.
	 * @generated
	 */
	PropertyStep createPropertyStep();

	/**
	 * Returns a new object of class '<em>Out EStep</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Out EStep</em>'.
	 * @generated
	 */
	OutEStep createOutEStep();

	/**
	 * Returns a new object of class '<em>In EStep</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>In EStep</em>'.
	 * @generated
	 */
	InEStep createInEStep();

	/**
	 * Returns a new object of class '<em>In VStep</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>In VStep</em>'.
	 * @generated
	 */
	InVStep createInVStep();

	/**
	 * Returns a new object of class '<em>Out VStep</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Out VStep</em>'.
	 * @generated
	 */
	OutVStep createOutVStep();

	/**
	 * Returns a new object of class '<em>Filter Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Step</em>'.
	 * @generated
	 */
	FilterStep createFilterStep();

	/**
	 * Returns a new object of class '<em>Retain Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Retain Step</em>'.
	 * @generated
	 */
	RetainStep createRetainStep();

	/**
	 * Returns a new object of class '<em>Except Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Except Step</em>'.
	 * @generated
	 */
	ExceptStep createExceptStep();

	/**
	 * Returns a new object of class '<em>Transform Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transform Step</em>'.
	 * @generated
	 */
	TransformStep createTransformStep();

	/**
	 * Returns a new object of class '<em>Gather Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gather Step</em>'.
	 * @generated
	 */
	GatherStep createGatherStep();

	/**
	 * Returns a new object of class '<em>Scatter Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scatter Step</em>'.
	 * @generated
	 */
	ScatterStep createScatterStep();

	/**
	 * Returns a new object of class '<em>Custom Method Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Custom Method Call</em>'.
	 * @generated
	 */
	CustomMethodCall createCustomMethodCall();

	/**
	 * Returns a new object of class '<em>Next Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Next Call</em>'.
	 * @generated
	 */
	NextCall createNextCall();

	/**
	 * Returns a new object of class '<em>Has Next Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Has Next Call</em>'.
	 * @generated
	 */
	HasNextCall createHasNextCall();

	/**
	 * Returns a new object of class '<em>Index Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Index Call</em>'.
	 * @generated
	 */
	IndexCall createIndexCall();

	/**
	 * Returns a new object of class '<em>Count Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Count Call</em>'.
	 * @generated
	 */
	CountCall createCountCall();

	/**
	 * Returns a new object of class '<em>First Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>First Call</em>'.
	 * @generated
	 */
	FirstCall createFirstCall();

	/**
	 * Returns a new object of class '<em>To List Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>To List Call</em>'.
	 * @generated
	 */
	ToListCall createToListCall();

	/**
	 * Returns a new object of class '<em>Is Empty Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Empty Call</em>'.
	 * @generated
	 */
	IsEmptyCall createIsEmptyCall();

	/**
	 * Returns a new object of class '<em>Contains Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contains Call</em>'.
	 * @generated
	 */
	ContainsCall createContainsCall();

	/**
	 * Returns a new object of class '<em>Contains All Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contains All Call</em>'.
	 * @generated
	 */
	ContainsAllCall createContainsAllCall();

	/**
	 * Returns a new object of class '<em>Add All Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add All Call</em>'.
	 * @generated
	 */
	AddAllCall createAddAllCall();

	/**
	 * Returns a new object of class '<em>Retain All Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Retain All Call</em>'.
	 * @generated
	 */
	RetainAllCall createRetainAllCall();

	/**
	 * Returns a new object of class '<em>Union Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Union Call</em>'.
	 * @generated
	 */
	UnionCall createUnionCall();

	/**
	 * Returns a new object of class '<em>Intersection Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Intersection Call</em>'.
	 * @generated
	 */
	IntersectionCall createIntersectionCall();

	/**
	 * Returns a new object of class '<em>Size Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Size Call</em>'.
	 * @generated
	 */
	SizeCall createSizeCall();

	/**
	 * Returns a new object of class '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression</em>'.
	 * @generated
	 */
	Expression createExpression();

	/**
	 * Returns a new object of class '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unary Expression</em>'.
	 * @generated
	 */
	UnaryExpression createUnaryExpression();

	/**
	 * Returns a new object of class '<em>Not Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Expression</em>'.
	 * @generated
	 */
	NotExpression createNotExpression();

	/**
	 * Returns a new object of class '<em>Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Expression</em>'.
	 * @generated
	 */
	BinaryExpression createBinaryExpression();

	/**
	 * Returns a new object of class '<em>Equality Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equality Expression</em>'.
	 * @generated
	 */
	EqualityExpression createEqualityExpression();

	/**
	 * Returns a new object of class '<em>In Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>In Expression</em>'.
	 * @generated
	 */
	InExpression createInExpression();

	/**
	 * Returns a new object of class '<em>Difference Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Difference Expression</em>'.
	 * @generated
	 */
	DifferenceExpression createDifferenceExpression();

	/**
	 * Returns a new object of class '<em>Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Expression</em>'.
	 * @generated
	 */
	OrExpression createOrExpression();

	/**
	 * Returns a new object of class '<em>And Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Expression</em>'.
	 * @generated
	 */
	AndExpression createAndExpression();

	/**
	 * Returns a new object of class '<em>Greater Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Greater Expression</em>'.
	 * @generated
	 */
	GreaterExpression createGreaterExpression();

	/**
	 * Returns a new object of class '<em>Greater Or Equal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Greater Or Equal Expression</em>'.
	 * @generated
	 */
	GreaterOrEqualExpression createGreaterOrEqualExpression();

	/**
	 * Returns a new object of class '<em>Less Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Less Expression</em>'.
	 * @generated
	 */
	LessExpression createLessExpression();

	/**
	 * Returns a new object of class '<em>Less Or Equal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Less Or Equal Expression</em>'.
	 * @generated
	 */
	LessOrEqualExpression createLessOrEqualExpression();

	/**
	 * Returns a new object of class '<em>Affectation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Affectation Expression</em>'.
	 * @generated
	 */
	AffectationExpression createAffectationExpression();

	/**
	 * Returns a new object of class '<em>Left Shift Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Left Shift Expression</em>'.
	 * @generated
	 */
	LeftShiftExpression createLeftShiftExpression();

	/**
	 * Returns a new object of class '<em>Ternary Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ternary Operator</em>'.
	 * @generated
	 */
	TernaryOperator createTernaryOperator();

	/**
	 * Returns a new object of class '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal</em>'.
	 * @generated
	 */
	StringLiteral createStringLiteral();

	/**
	 * Returns a new object of class '<em>Integer Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Literal</em>'.
	 * @generated
	 */
	IntegerLiteral createIntegerLiteral();

	/**
	 * Returns a new object of class '<em>Double Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Literal</em>'.
	 * @generated
	 */
	DoubleLiteral createDoubleLiteral();

	/**
	 * Returns a new object of class '<em>Boolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal</em>'.
	 * @generated
	 */
	BooleanLiteral createBooleanLiteral();

	/**
	 * Returns a new object of class '<em>Null Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Null Literal</em>'.
	 * @generated
	 */
	NullLiteral createNullLiteral();

	/**
	 * Returns a new object of class '<em>To Integer Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>To Integer Call</em>'.
	 * @generated
	 */
	ToIntegerCall createToIntegerCall();

	/**
	 * Returns a new object of class '<em>Plus Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plus Expression</em>'.
	 * @generated
	 */
	PlusExpression createPlusExpression();

	/**
	 * Returns a new object of class '<em>Custom Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Custom Step</em>'.
	 * @generated
	 */
	CustomStep createCustomStep();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GremlinPackage getGremlinPackage();

} //GremlinFactory
