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
			case GremlinPackage.IDENTITY_PIPE: return createIdentityPipe();
			case GremlinPackage.FILL_PIPE: return createFillPipe();
			case GremlinPackage.START_PIPE: return createStartPipe();
			case GremlinPackage.VERTICES_PIPE: return createVerticesPipe();
			case GremlinPackage.EDGES_PIPE: return createEdgesPipe();
			case GremlinPackage.PROPERTY_PIPE: return createPropertyPipe();
			case GremlinPackage.OUT_EPIPE: return createOutEPipe();
			case GremlinPackage.IN_EPIPE: return createInEPipe();
			case GremlinPackage.IN_VPIPE: return createInVPipe();
			case GremlinPackage.OUT_VPIPE: return createOutVPipe();
			case GremlinPackage.FILTER_PIPE: return createFilterPipe();
			case GremlinPackage.TRANSFORM_PIPE: return createTransformPipe();
			case GremlinPackage.NEXT_CALL: return createNextCall();
			case GremlinPackage.HAS_NEXT_CALL: return createHasNextCall();
			case GremlinPackage.INDEX_CALL: return createIndexCall();
			case GremlinPackage.COUNT_CALL: return createCountCall();
			case GremlinPackage.FIRST_CALL: return createFirstCall();
			case GremlinPackage.TO_LIST_CALL: return createToListCall();
			case GremlinPackage.IS_EMPTY_CALL: return createIsEmptyCall();
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
	public IdentityPipe createIdentityPipe() {
		IdentityPipeImpl identityPipe = new IdentityPipeImpl();
		return identityPipe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FillPipe createFillPipe() {
		FillPipeImpl fillPipe = new FillPipeImpl();
		return fillPipe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartPipe createStartPipe() {
		StartPipeImpl startPipe = new StartPipeImpl();
		return startPipe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerticesPipe createVerticesPipe() {
		VerticesPipeImpl verticesPipe = new VerticesPipeImpl();
		return verticesPipe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgesPipe createEdgesPipe() {
		EdgesPipeImpl edgesPipe = new EdgesPipeImpl();
		return edgesPipe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyPipe createPropertyPipe() {
		PropertyPipeImpl propertyPipe = new PropertyPipeImpl();
		return propertyPipe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutEPipe createOutEPipe() {
		OutEPipeImpl outEPipe = new OutEPipeImpl();
		return outEPipe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InEPipe createInEPipe() {
		InEPipeImpl inEPipe = new InEPipeImpl();
		return inEPipe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InVPipe createInVPipe() {
		InVPipeImpl inVPipe = new InVPipeImpl();
		return inVPipe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutVPipe createOutVPipe() {
		OutVPipeImpl outVPipe = new OutVPipeImpl();
		return outVPipe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterPipe createFilterPipe() {
		FilterPipeImpl filterPipe = new FilterPipeImpl();
		return filterPipe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformPipe createTransformPipe() {
		TransformPipeImpl transformPipe = new TransformPipeImpl();
		return transformPipe;
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
