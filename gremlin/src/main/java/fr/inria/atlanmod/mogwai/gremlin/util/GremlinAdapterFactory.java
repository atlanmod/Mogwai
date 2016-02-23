/**
 */
package fr.inria.atlanmod.mogwai.gremlin.util;

import fr.inria.atlanmod.mogwai.gremlin.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage
 * @generated
 */
public class GremlinAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GremlinPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GremlinAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GremlinPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GremlinSwitch<Adapter> modelSwitch =
		new GremlinSwitch<Adapter>() {
			@Override
			public Adapter caseGremlinScript(GremlinScript object) {
				return createGremlinScriptAdapter();
			}
			@Override
			public Adapter caseInstruction(Instruction object) {
				return createInstructionAdapter();
			}
			@Override
			public Adapter caseMethodDeclaration(MethodDeclaration object) {
				return createMethodDeclarationAdapter();
			}
			@Override
			public Adapter caseTypeDeclaration(TypeDeclaration object) {
				return createTypeDeclarationAdapter();
			}
			@Override
			public Adapter caseListDeclaration(ListDeclaration object) {
				return createListDeclarationAdapter();
			}
			@Override
			public Adapter caseSetDeclaration(SetDeclaration object) {
				return createSetDeclarationAdapter();
			}
			@Override
			public Adapter caseSortedSetDeclaration(SortedSetDeclaration object) {
				return createSortedSetDeclarationAdapter();
			}
			@Override
			public Adapter caseVariableDeclaration(VariableDeclaration object) {
				return createVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseTraversalElement(TraversalElement object) {
				return createTraversalElementAdapter();
			}
			@Override
			public Adapter caseCollectionDefinition(CollectionDefinition object) {
				return createCollectionDefinitionAdapter();
			}
			@Override
			public Adapter caseClosure(Closure object) {
				return createClosureAdapter();
			}
			@Override
			public Adapter caseClosureIt(ClosureIt object) {
				return createClosureItAdapter();
			}
			@Override
			public Adapter caseVariableAccess(VariableAccess object) {
				return createVariableAccessAdapter();
			}
			@Override
			public Adapter caseStep(Step object) {
				return createStepAdapter();
			}
			@Override
			public Adapter caseIdentityStep(IdentityStep object) {
				return createIdentityStepAdapter();
			}
			@Override
			public Adapter caseFillStep(FillStep object) {
				return createFillStepAdapter();
			}
			@Override
			public Adapter caseStartStep(StartStep object) {
				return createStartStepAdapter();
			}
			@Override
			public Adapter caseVerticesStep(VerticesStep object) {
				return createVerticesStepAdapter();
			}
			@Override
			public Adapter caseEdgesStep(EdgesStep object) {
				return createEdgesStepAdapter();
			}
			@Override
			public Adapter casePropertyStep(PropertyStep object) {
				return createPropertyStepAdapter();
			}
			@Override
			public Adapter caseOutEStep(OutEStep object) {
				return createOutEStepAdapter();
			}
			@Override
			public Adapter caseInEStep(InEStep object) {
				return createInEStepAdapter();
			}
			@Override
			public Adapter caseInVStep(InVStep object) {
				return createInVStepAdapter();
			}
			@Override
			public Adapter caseOutVStep(OutVStep object) {
				return createOutVStepAdapter();
			}
			@Override
			public Adapter caseFilterStep(FilterStep object) {
				return createFilterStepAdapter();
			}
			@Override
			public Adapter caseRetainStep(RetainStep object) {
				return createRetainStepAdapter();
			}
			@Override
			public Adapter caseExceptStep(ExceptStep object) {
				return createExceptStepAdapter();
			}
			@Override
			public Adapter caseTransformStep(TransformStep object) {
				return createTransformStepAdapter();
			}
			@Override
			public Adapter caseGatherStep(GatherStep object) {
				return createGatherStepAdapter();
			}
			@Override
			public Adapter caseScatterStep(ScatterStep object) {
				return createScatterStepAdapter();
			}
			@Override
			public Adapter caseMethodCall(MethodCall object) {
				return createMethodCallAdapter();
			}
			@Override
			public Adapter caseNextCall(NextCall object) {
				return createNextCallAdapter();
			}
			@Override
			public Adapter caseHasNextCall(HasNextCall object) {
				return createHasNextCallAdapter();
			}
			@Override
			public Adapter caseIndexCall(IndexCall object) {
				return createIndexCallAdapter();
			}
			@Override
			public Adapter caseCountCall(CountCall object) {
				return createCountCallAdapter();
			}
			@Override
			public Adapter caseFirstCall(FirstCall object) {
				return createFirstCallAdapter();
			}
			@Override
			public Adapter caseToListCall(ToListCall object) {
				return createToListCallAdapter();
			}
			@Override
			public Adapter caseIsEmptyCall(IsEmptyCall object) {
				return createIsEmptyCallAdapter();
			}
			@Override
			public Adapter caseContainsCall(ContainsCall object) {
				return createContainsCallAdapter();
			}
			@Override
			public Adapter caseContainsAllCall(ContainsAllCall object) {
				return createContainsAllCallAdapter();
			}
			@Override
			public Adapter caseAddAllCall(AddAllCall object) {
				return createAddAllCallAdapter();
			}
			@Override
			public Adapter caseRetainAllCall(RetainAllCall object) {
				return createRetainAllCallAdapter();
			}
			@Override
			public Adapter caseUnionCall(UnionCall object) {
				return createUnionCallAdapter();
			}
			@Override
			public Adapter caseIntersectionCall(IntersectionCall object) {
				return createIntersectionCallAdapter();
			}
			@Override
			public Adapter caseSizeCall(SizeCall object) {
				return createSizeCallAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseUnaryExpression(UnaryExpression object) {
				return createUnaryExpressionAdapter();
			}
			@Override
			public Adapter caseNotExpression(NotExpression object) {
				return createNotExpressionAdapter();
			}
			@Override
			public Adapter caseBinaryExpression(BinaryExpression object) {
				return createBinaryExpressionAdapter();
			}
			@Override
			public Adapter caseEqualityExpression(EqualityExpression object) {
				return createEqualityExpressionAdapter();
			}
			@Override
			public Adapter caseDifferenceExpression(DifferenceExpression object) {
				return createDifferenceExpressionAdapter();
			}
			@Override
			public Adapter caseOrExpression(OrExpression object) {
				return createOrExpressionAdapter();
			}
			@Override
			public Adapter caseAndExpression(AndExpression object) {
				return createAndExpressionAdapter();
			}
			@Override
			public Adapter caseGreaterExpression(GreaterExpression object) {
				return createGreaterExpressionAdapter();
			}
			@Override
			public Adapter caseGreaterOrEqualExpression(GreaterOrEqualExpression object) {
				return createGreaterOrEqualExpressionAdapter();
			}
			@Override
			public Adapter caseLessExpression(LessExpression object) {
				return createLessExpressionAdapter();
			}
			@Override
			public Adapter caseLessOrEqualExpression(LessOrEqualExpression object) {
				return createLessOrEqualExpressionAdapter();
			}
			@Override
			public Adapter caseAffectationExpression(AffectationExpression object) {
				return createAffectationExpressionAdapter();
			}
			@Override
			public Adapter caseLeftShiftExpression(LeftShiftExpression object) {
				return createLeftShiftExpressionAdapter();
			}
			@Override
			public Adapter caseStringLiteral(StringLiteral object) {
				return createStringLiteralAdapter();
			}
			@Override
			public Adapter caseIntegerLiteral(IntegerLiteral object) {
				return createIntegerLiteralAdapter();
			}
			@Override
			public Adapter caseDoubleLiteral(DoubleLiteral object) {
				return createDoubleLiteralAdapter();
			}
			@Override
			public Adapter caseBooleanLiteral(BooleanLiteral object) {
				return createBooleanLiteralAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.GremlinScript <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinScript
	 * @generated
	 */
	public Adapter createGremlinScriptAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.Instruction <em>Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.Instruction
	 * @generated
	 */
	public Adapter createInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.MethodDeclaration <em>Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.MethodDeclaration
	 * @generated
	 */
	public Adapter createMethodDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.TypeDeclaration <em>Type Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.TypeDeclaration
	 * @generated
	 */
	public Adapter createTypeDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.ListDeclaration <em>List Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ListDeclaration
	 * @generated
	 */
	public Adapter createListDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.SetDeclaration <em>Set Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.SetDeclaration
	 * @generated
	 */
	public Adapter createSetDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.SortedSetDeclaration <em>Sorted Set Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.SortedSetDeclaration
	 * @generated
	 */
	public Adapter createSortedSetDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration
	 * @generated
	 */
	public Adapter createVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.TraversalElement <em>Traversal Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.TraversalElement
	 * @generated
	 */
	public Adapter createTraversalElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.CollectionDefinition <em>Collection Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.CollectionDefinition
	 * @generated
	 */
	public Adapter createCollectionDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.Closure <em>Closure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.Closure
	 * @generated
	 */
	public Adapter createClosureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.ClosureIt <em>Closure It</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ClosureIt
	 * @generated
	 */
	public Adapter createClosureItAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.VariableAccess <em>Variable Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.VariableAccess
	 * @generated
	 */
	public Adapter createVariableAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.Step <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.Step
	 * @generated
	 */
	public Adapter createStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.IdentityStep <em>Identity Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IdentityStep
	 * @generated
	 */
	public Adapter createIdentityStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.FillStep <em>Fill Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.FillStep
	 * @generated
	 */
	public Adapter createFillStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.StartStep <em>Start Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.StartStep
	 * @generated
	 */
	public Adapter createStartStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.VerticesStep <em>Vertices Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.VerticesStep
	 * @generated
	 */
	public Adapter createVerticesStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.EdgesStep <em>Edges Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.EdgesStep
	 * @generated
	 */
	public Adapter createEdgesStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.PropertyStep <em>Property Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.PropertyStep
	 * @generated
	 */
	public Adapter createPropertyStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.OutEStep <em>Out EStep</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.OutEStep
	 * @generated
	 */
	public Adapter createOutEStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.InEStep <em>In EStep</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.InEStep
	 * @generated
	 */
	public Adapter createInEStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.InVStep <em>In VStep</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.InVStep
	 * @generated
	 */
	public Adapter createInVStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.OutVStep <em>Out VStep</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.OutVStep
	 * @generated
	 */
	public Adapter createOutVStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.FilterStep <em>Filter Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.FilterStep
	 * @generated
	 */
	public Adapter createFilterStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.RetainStep <em>Retain Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.RetainStep
	 * @generated
	 */
	public Adapter createRetainStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.ExceptStep <em>Except Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ExceptStep
	 * @generated
	 */
	public Adapter createExceptStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.TransformStep <em>Transform Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.TransformStep
	 * @generated
	 */
	public Adapter createTransformStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.GatherStep <em>Gather Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GatherStep
	 * @generated
	 */
	public Adapter createGatherStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.ScatterStep <em>Scatter Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ScatterStep
	 * @generated
	 */
	public Adapter createScatterStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.MethodCall <em>Method Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.MethodCall
	 * @generated
	 */
	public Adapter createMethodCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.NextCall <em>Next Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.NextCall
	 * @generated
	 */
	public Adapter createNextCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.HasNextCall <em>Has Next Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.HasNextCall
	 * @generated
	 */
	public Adapter createHasNextCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.IndexCall <em>Index Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IndexCall
	 * @generated
	 */
	public Adapter createIndexCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.CountCall <em>Count Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.CountCall
	 * @generated
	 */
	public Adapter createCountCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.FirstCall <em>First Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.FirstCall
	 * @generated
	 */
	public Adapter createFirstCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.ToListCall <em>To List Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ToListCall
	 * @generated
	 */
	public Adapter createToListCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.IsEmptyCall <em>Is Empty Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IsEmptyCall
	 * @generated
	 */
	public Adapter createIsEmptyCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.ContainsCall <em>Contains Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ContainsCall
	 * @generated
	 */
	public Adapter createContainsCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.ContainsAllCall <em>Contains All Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ContainsAllCall
	 * @generated
	 */
	public Adapter createContainsAllCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.AddAllCall <em>Add All Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.AddAllCall
	 * @generated
	 */
	public Adapter createAddAllCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.RetainAllCall <em>Retain All Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.RetainAllCall
	 * @generated
	 */
	public Adapter createRetainAllCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.UnionCall <em>Union Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.UnionCall
	 * @generated
	 */
	public Adapter createUnionCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.IntersectionCall <em>Intersection Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IntersectionCall
	 * @generated
	 */
	public Adapter createIntersectionCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.SizeCall <em>Size Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.SizeCall
	 * @generated
	 */
	public Adapter createSizeCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.UnaryExpression
	 * @generated
	 */
	public Adapter createUnaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.NotExpression <em>Not Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.NotExpression
	 * @generated
	 */
	public Adapter createNotExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.BinaryExpression <em>Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.BinaryExpression
	 * @generated
	 */
	public Adapter createBinaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.EqualityExpression <em>Equality Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.EqualityExpression
	 * @generated
	 */
	public Adapter createEqualityExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.DifferenceExpression <em>Difference Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.DifferenceExpression
	 * @generated
	 */
	public Adapter createDifferenceExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.OrExpression <em>Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.OrExpression
	 * @generated
	 */
	public Adapter createOrExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.AndExpression <em>And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.AndExpression
	 * @generated
	 */
	public Adapter createAndExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.GreaterExpression <em>Greater Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GreaterExpression
	 * @generated
	 */
	public Adapter createGreaterExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.GreaterOrEqualExpression <em>Greater Or Equal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GreaterOrEqualExpression
	 * @generated
	 */
	public Adapter createGreaterOrEqualExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.LessExpression <em>Less Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.LessExpression
	 * @generated
	 */
	public Adapter createLessExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.LessOrEqualExpression <em>Less Or Equal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.LessOrEqualExpression
	 * @generated
	 */
	public Adapter createLessOrEqualExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.AffectationExpression <em>Affectation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.AffectationExpression
	 * @generated
	 */
	public Adapter createAffectationExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.LeftShiftExpression <em>Left Shift Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.LeftShiftExpression
	 * @generated
	 */
	public Adapter createLeftShiftExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.StringLiteral
	 * @generated
	 */
	public Adapter createStringLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IntegerLiteral
	 * @generated
	 */
	public Adapter createIntegerLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.DoubleLiteral <em>Double Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.DoubleLiteral
	 * @generated
	 */
	public Adapter createDoubleLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.atlanmod.mogwai.gremlin.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.atlanmod.mogwai.gremlin.BooleanLiteral
	 * @generated
	 */
	public Adapter createBooleanLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GremlinAdapterFactory
