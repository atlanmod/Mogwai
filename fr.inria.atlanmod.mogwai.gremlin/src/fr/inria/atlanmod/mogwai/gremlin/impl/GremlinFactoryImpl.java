/**
 */
package fr.inria.atlanmod.mogwai.gremlin.impl;

import fr.inria.atlanmod.mogwai.gremlin.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GremlinFactoryImpl extends EFactoryImpl implements GremlinFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GremlinFactory init() {
		try {
			GremlinFactory theGremlinFactory = (GremlinFactory)EPackage.Registry.INSTANCE.getEFactory(GremlinPackage.eNS_URI);
			if (theGremlinFactory != null) {
				return theGremlinFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GremlinFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GremlinFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GremlinPackage.GREMLIN_SCRIPT: return createGremlinScript();
			case GremlinPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
			case GremlinPackage.VECTOR_TYPE: return createVectorType();
			case GremlinPackage.CLOSURE: return createClosure();
			case GremlinPackage.CLOSURE_IT: return createClosureIt();
			case GremlinPackage.VARIABLE_ACCESS: return createVariableAccess();
			case GremlinPackage.IDENTITY_STEP: return createIdentityStep();
			case GremlinPackage.FILL_STEP: return createFillStep();
			case GremlinPackage.START_STEP: return createStartStep();
			case GremlinPackage.VERTICES_STEP: return createVerticesStep();
			case GremlinPackage.EDGES_STEP: return createEdgesStep();
			case GremlinPackage.PROPERTY_STEP: return createPropertyStep();
			case GremlinPackage.OUT_ESTEP: return createOutEStep();
			case GremlinPackage.IN_ESTEP: return createInEStep();
			case GremlinPackage.IN_VSTEP: return createInVStep();
			case GremlinPackage.OUT_VSTEP: return createOutVStep();
			case GremlinPackage.FILTER_STEP: return createFilterStep();
			case GremlinPackage.RETAIN_STEP: return createRetainStep();
			case GremlinPackage.EXCEPT_STEP: return createExceptStep();
			case GremlinPackage.TRANSFORM_STEP: return createTransformStep();
			case GremlinPackage.GATHER_STEP: return createGatherStep();
			case GremlinPackage.SCATTER_STEP: return createScatterStep();
			case GremlinPackage.NEXT_CALL: return createNextCall();
			case GremlinPackage.HAS_NEXT_CALL: return createHasNextCall();
			case GremlinPackage.INDEX_CALL: return createIndexCall();
			case GremlinPackage.COUNT_CALL: return createCountCall();
			case GremlinPackage.FIRST_CALL: return createFirstCall();
			case GremlinPackage.TO_LIST_CALL: return createToListCall();
			case GremlinPackage.IS_EMPTY_CALL: return createIsEmptyCall();
			case GremlinPackage.CONTAINS_CALL: return createContainsCall();
			case GremlinPackage.CONTAINS_ALL_CALL: return createContainsAllCall();
			case GremlinPackage.EXPRESSION: return createExpression();
			case GremlinPackage.UNARY_EXPRESSION: return createUnaryExpression();
			case GremlinPackage.NOT_EXPRESSION: return createNotExpression();
			case GremlinPackage.BINARY_EXPRESSION: return createBinaryExpression();
			case GremlinPackage.EQUALITY_EXPRESSION: return createEqualityExpression();
			case GremlinPackage.DIFFERENCE_EXPRESSION: return createDifferenceExpression();
			case GremlinPackage.OR_EXPRESSION: return createOrExpression();
			case GremlinPackage.AND_EXPRESSION: return createAndExpression();
			case GremlinPackage.GREATER_EXPRESSION: return createGreaterExpression();
			case GremlinPackage.GREATER_OR_EQUAL_EXPRESSION: return createGreaterOrEqualExpression();
			case GremlinPackage.LESS_EXPRESSION: return createLessExpression();
			case GremlinPackage.LESS_OR_EQUAL_EXPRESSION: return createLessOrEqualExpression();
			case GremlinPackage.AFFECTATION_EXPRESSION: return createAffectationExpression();
			case GremlinPackage.LEFT_SHIFT_EXPRESSION: return createLeftShiftExpression();
			case GremlinPackage.STRING_LITERAL: return createStringLiteral();
			case GremlinPackage.INTEGER_LITERAL: return createIntegerLiteral();
			case GremlinPackage.DOUBLE_LITERAL: return createDoubleLiteral();
			case GremlinPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GremlinScript createGremlinScript() {
		GremlinScriptImpl gremlinScript = new GremlinScriptImpl();
		return gremlinScript;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration createVariableDeclaration() {
		VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
		return variableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VectorType createVectorType() {
		VectorTypeImpl vectorType = new VectorTypeImpl();
		return vectorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Closure createClosure() {
		ClosureImpl closure = new ClosureImpl();
		return closure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClosureIt createClosureIt() {
		ClosureItImpl closureIt = new ClosureItImpl();
		return closureIt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableAccess createVariableAccess() {
		VariableAccessImpl variableAccess = new VariableAccessImpl();
		return variableAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentityStep createIdentityStep() {
		IdentityStepImpl identityStep = new IdentityStepImpl();
		return identityStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FillStep createFillStep() {
		FillStepImpl fillStep = new FillStepImpl();
		return fillStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartStep createStartStep() {
		StartStepImpl startStep = new StartStepImpl();
		return startStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerticesStep createVerticesStep() {
		VerticesStepImpl verticesStep = new VerticesStepImpl();
		return verticesStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgesStep createEdgesStep() {
		EdgesStepImpl edgesStep = new EdgesStepImpl();
		return edgesStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyStep createPropertyStep() {
		PropertyStepImpl propertyStep = new PropertyStepImpl();
		return propertyStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutEStep createOutEStep() {
		OutEStepImpl outEStep = new OutEStepImpl();
		return outEStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InEStep createInEStep() {
		InEStepImpl inEStep = new InEStepImpl();
		return inEStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InVStep createInVStep() {
		InVStepImpl inVStep = new InVStepImpl();
		return inVStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutVStep createOutVStep() {
		OutVStepImpl outVStep = new OutVStepImpl();
		return outVStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterStep createFilterStep() {
		FilterStepImpl filterStep = new FilterStepImpl();
		return filterStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RetainStep createRetainStep() {
		RetainStepImpl retainStep = new RetainStepImpl();
		return retainStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExceptStep createExceptStep() {
		ExceptStepImpl exceptStep = new ExceptStepImpl();
		return exceptStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformStep createTransformStep() {
		TransformStepImpl transformStep = new TransformStepImpl();
		return transformStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GatherStep createGatherStep() {
		GatherStepImpl gatherStep = new GatherStepImpl();
		return gatherStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScatterStep createScatterStep() {
		ScatterStepImpl scatterStep = new ScatterStepImpl();
		return scatterStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NextCall createNextCall() {
		NextCallImpl nextCall = new NextCallImpl();
		return nextCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasNextCall createHasNextCall() {
		HasNextCallImpl hasNextCall = new HasNextCallImpl();
		return hasNextCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexCall createIndexCall() {
		IndexCallImpl indexCall = new IndexCallImpl();
		return indexCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CountCall createCountCall() {
		CountCallImpl countCall = new CountCallImpl();
		return countCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FirstCall createFirstCall() {
		FirstCallImpl firstCall = new FirstCallImpl();
		return firstCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToListCall createToListCall() {
		ToListCallImpl toListCall = new ToListCallImpl();
		return toListCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsEmptyCall createIsEmptyCall() {
		IsEmptyCallImpl isEmptyCall = new IsEmptyCallImpl();
		return isEmptyCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainsCall createContainsCall() {
		ContainsCallImpl containsCall = new ContainsCallImpl();
		return containsCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainsAllCall createContainsAllCall() {
		ContainsAllCallImpl containsAllCall = new ContainsAllCallImpl();
		return containsAllCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryExpression createUnaryExpression() {
		UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
		return unaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotExpression createNotExpression() {
		NotExpressionImpl notExpression = new NotExpressionImpl();
		return notExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryExpression createBinaryExpression() {
		BinaryExpressionImpl binaryExpression = new BinaryExpressionImpl();
		return binaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualityExpression createEqualityExpression() {
		EqualityExpressionImpl equalityExpression = new EqualityExpressionImpl();
		return equalityExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DifferenceExpression createDifferenceExpression() {
		DifferenceExpressionImpl differenceExpression = new DifferenceExpressionImpl();
		return differenceExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrExpression createOrExpression() {
		OrExpressionImpl orExpression = new OrExpressionImpl();
		return orExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndExpression createAndExpression() {
		AndExpressionImpl andExpression = new AndExpressionImpl();
		return andExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GreaterExpression createGreaterExpression() {
		GreaterExpressionImpl greaterExpression = new GreaterExpressionImpl();
		return greaterExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GreaterOrEqualExpression createGreaterOrEqualExpression() {
		GreaterOrEqualExpressionImpl greaterOrEqualExpression = new GreaterOrEqualExpressionImpl();
		return greaterOrEqualExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LessExpression createLessExpression() {
		LessExpressionImpl lessExpression = new LessExpressionImpl();
		return lessExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LessOrEqualExpression createLessOrEqualExpression() {
		LessOrEqualExpressionImpl lessOrEqualExpression = new LessOrEqualExpressionImpl();
		return lessOrEqualExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffectationExpression createAffectationExpression() {
		AffectationExpressionImpl affectationExpression = new AffectationExpressionImpl();
		return affectationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LeftShiftExpression createLeftShiftExpression() {
		LeftShiftExpressionImpl leftShiftExpression = new LeftShiftExpressionImpl();
		return leftShiftExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteral createStringLiteral() {
		StringLiteralImpl stringLiteral = new StringLiteralImpl();
		return stringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerLiteral createIntegerLiteral() {
		IntegerLiteralImpl integerLiteral = new IntegerLiteralImpl();
		return integerLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleLiteral createDoubleLiteral() {
		DoubleLiteralImpl doubleLiteral = new DoubleLiteralImpl();
		return doubleLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLiteral createBooleanLiteral() {
		BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
		return booleanLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GremlinPackage getGremlinPackage() {
		return (GremlinPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GremlinPackage getPackage() {
		return GremlinPackage.eINSTANCE;
	}

} //GremlinFactoryImpl
