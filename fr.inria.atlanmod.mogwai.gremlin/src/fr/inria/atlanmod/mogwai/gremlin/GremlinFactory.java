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
	 * Returns a new object of class '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Declaration</em>'.
	 * @generated
	 */
	VariableDeclaration createVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Vector Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vector Type</em>'.
	 * @generated
	 */
	VectorType createVectorType();

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
	 * Returns a new object of class '<em>Identity Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identity Pipe</em>'.
	 * @generated
	 */
	IdentityPipe createIdentityPipe();

	/**
	 * Returns a new object of class '<em>Fill Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fill Pipe</em>'.
	 * @generated
	 */
	FillPipe createFillPipe();

	/**
	 * Returns a new object of class '<em>Start Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start Pipe</em>'.
	 * @generated
	 */
	StartPipe createStartPipe();

	/**
	 * Returns a new object of class '<em>Vertices Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vertices Pipe</em>'.
	 * @generated
	 */
	VerticesPipe createVerticesPipe();

	/**
	 * Returns a new object of class '<em>Edges Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edges Pipe</em>'.
	 * @generated
	 */
	EdgesPipe createEdgesPipe();

	/**
	 * Returns a new object of class '<em>Property Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Pipe</em>'.
	 * @generated
	 */
	PropertyPipe createPropertyPipe();

	/**
	 * Returns a new object of class '<em>Out EPipe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Out EPipe</em>'.
	 * @generated
	 */
	OutEPipe createOutEPipe();

	/**
	 * Returns a new object of class '<em>In EPipe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>In EPipe</em>'.
	 * @generated
	 */
	InEPipe createInEPipe();

	/**
	 * Returns a new object of class '<em>In VPipe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>In VPipe</em>'.
	 * @generated
	 */
	InVPipe createInVPipe();

	/**
	 * Returns a new object of class '<em>Out VPipe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Out VPipe</em>'.
	 * @generated
	 */
	OutVPipe createOutVPipe();

	/**
	 * Returns a new object of class '<em>Filter Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Pipe</em>'.
	 * @generated
	 */
	FilterPipe createFilterPipe();

	/**
	 * Returns a new object of class '<em>Transform Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transform Pipe</em>'.
	 * @generated
	 */
	TransformPipe createTransformPipe();

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GremlinPackage getGremlinPackage();

} //GremlinFactory
