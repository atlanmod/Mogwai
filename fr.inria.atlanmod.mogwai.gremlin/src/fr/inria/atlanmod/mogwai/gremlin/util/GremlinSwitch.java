/**
 */
package fr.inria.atlanmod.mogwai.gremlin.util;

import fr.inria.atlanmod.mogwai.gremlin.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage
 * @generated
 */
public class GremlinSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GremlinPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GremlinSwitch() {
		if (modelPackage == null) {
			modelPackage = GremlinPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GremlinPackage.GREMLIN_SCRIPT: {
				GremlinScript gremlinScript = (GremlinScript)theEObject;
				T result = caseGremlinScript(gremlinScript);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.INSTRUCTION: {
				Instruction instruction = (Instruction)theEObject;
				T result = caseInstruction(instruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.VARIABLE_DECLARATION: {
				VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
				T result = caseVariableDeclaration(variableDeclaration);
				if (result == null) result = caseInstruction(variableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.VECTOR_TYPE: {
				VectorType vectorType = (VectorType)theEObject;
				T result = caseVectorType(vectorType);
				if (result == null) result = caseInstruction(vectorType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.CHAIN_ELEMENT: {
				ChainElement chainElement = (ChainElement)theEObject;
				T result = caseChainElement(chainElement);
				if (result == null) result = caseInstruction(chainElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.CLOSURE: {
				Closure closure = (Closure)theEObject;
				T result = caseClosure(closure);
				if (result == null) result = caseInstruction(closure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.CLOSURE_IT: {
				ClosureIt closureIt = (ClosureIt)theEObject;
				T result = caseClosureIt(closureIt);
				if (result == null) result = caseChainElement(closureIt);
				if (result == null) result = caseInstruction(closureIt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.VARIABLE_ACCESS: {
				VariableAccess variableAccess = (VariableAccess)theEObject;
				T result = caseVariableAccess(variableAccess);
				if (result == null) result = caseChainElement(variableAccess);
				if (result == null) result = caseInstruction(variableAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.PIPE: {
				Pipe pipe = (Pipe)theEObject;
				T result = casePipe(pipe);
				if (result == null) result = caseChainElement(pipe);
				if (result == null) result = caseInstruction(pipe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.IDENTITY_PIPE: {
				IdentityPipe identityPipe = (IdentityPipe)theEObject;
				T result = caseIdentityPipe(identityPipe);
				if (result == null) result = casePipe(identityPipe);
				if (result == null) result = caseChainElement(identityPipe);
				if (result == null) result = caseInstruction(identityPipe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.FILL_PIPE: {
				FillPipe fillPipe = (FillPipe)theEObject;
				T result = caseFillPipe(fillPipe);
				if (result == null) result = casePipe(fillPipe);
				if (result == null) result = caseChainElement(fillPipe);
				if (result == null) result = caseInstruction(fillPipe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.START_PIPE: {
				StartPipe startPipe = (StartPipe)theEObject;
				T result = caseStartPipe(startPipe);
				if (result == null) result = casePipe(startPipe);
				if (result == null) result = caseChainElement(startPipe);
				if (result == null) result = caseInstruction(startPipe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.VERTICES_PIPE: {
				VerticesPipe verticesPipe = (VerticesPipe)theEObject;
				T result = caseVerticesPipe(verticesPipe);
				if (result == null) result = casePipe(verticesPipe);
				if (result == null) result = caseChainElement(verticesPipe);
				if (result == null) result = caseInstruction(verticesPipe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.EDGES_PIPE: {
				EdgesPipe edgesPipe = (EdgesPipe)theEObject;
				T result = caseEdgesPipe(edgesPipe);
				if (result == null) result = casePipe(edgesPipe);
				if (result == null) result = caseChainElement(edgesPipe);
				if (result == null) result = caseInstruction(edgesPipe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.PROPERTY_PIPE: {
				PropertyPipe propertyPipe = (PropertyPipe)theEObject;
				T result = casePropertyPipe(propertyPipe);
				if (result == null) result = casePipe(propertyPipe);
				if (result == null) result = caseChainElement(propertyPipe);
				if (result == null) result = caseInstruction(propertyPipe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.OUT_EPIPE: {
				OutEPipe outEPipe = (OutEPipe)theEObject;
				T result = caseOutEPipe(outEPipe);
				if (result == null) result = casePipe(outEPipe);
				if (result == null) result = caseChainElement(outEPipe);
				if (result == null) result = caseInstruction(outEPipe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.IN_EPIPE: {
				InEPipe inEPipe = (InEPipe)theEObject;
				T result = caseInEPipe(inEPipe);
				if (result == null) result = casePipe(inEPipe);
				if (result == null) result = caseChainElement(inEPipe);
				if (result == null) result = caseInstruction(inEPipe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.IN_VPIPE: {
				InVPipe inVPipe = (InVPipe)theEObject;
				T result = caseInVPipe(inVPipe);
				if (result == null) result = casePipe(inVPipe);
				if (result == null) result = caseChainElement(inVPipe);
				if (result == null) result = caseInstruction(inVPipe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.OUT_VPIPE: {
				OutVPipe outVPipe = (OutVPipe)theEObject;
				T result = caseOutVPipe(outVPipe);
				if (result == null) result = casePipe(outVPipe);
				if (result == null) result = caseChainElement(outVPipe);
				if (result == null) result = caseInstruction(outVPipe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.FILTER_PIPE: {
				FilterPipe filterPipe = (FilterPipe)theEObject;
				T result = caseFilterPipe(filterPipe);
				if (result == null) result = casePipe(filterPipe);
				if (result == null) result = caseChainElement(filterPipe);
				if (result == null) result = caseInstruction(filterPipe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.TRANSFORM_PIPE: {
				TransformPipe transformPipe = (TransformPipe)theEObject;
				T result = caseTransformPipe(transformPipe);
				if (result == null) result = casePipe(transformPipe);
				if (result == null) result = caseChainElement(transformPipe);
				if (result == null) result = caseInstruction(transformPipe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.METHOD_CALL: {
				MethodCall methodCall = (MethodCall)theEObject;
				T result = caseMethodCall(methodCall);
				if (result == null) result = caseChainElement(methodCall);
				if (result == null) result = caseInstruction(methodCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.NEXT_CALL: {
				NextCall nextCall = (NextCall)theEObject;
				T result = caseNextCall(nextCall);
				if (result == null) result = caseMethodCall(nextCall);
				if (result == null) result = caseChainElement(nextCall);
				if (result == null) result = caseInstruction(nextCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.HAS_NEXT_CALL: {
				HasNextCall hasNextCall = (HasNextCall)theEObject;
				T result = caseHasNextCall(hasNextCall);
				if (result == null) result = caseMethodCall(hasNextCall);
				if (result == null) result = caseChainElement(hasNextCall);
				if (result == null) result = caseInstruction(hasNextCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.INDEX_CALL: {
				IndexCall indexCall = (IndexCall)theEObject;
				T result = caseIndexCall(indexCall);
				if (result == null) result = caseMethodCall(indexCall);
				if (result == null) result = caseChainElement(indexCall);
				if (result == null) result = caseInstruction(indexCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.COUNT_CALL: {
				CountCall countCall = (CountCall)theEObject;
				T result = caseCountCall(countCall);
				if (result == null) result = caseMethodCall(countCall);
				if (result == null) result = caseChainElement(countCall);
				if (result == null) result = caseInstruction(countCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.FIRST_CALL: {
				FirstCall firstCall = (FirstCall)theEObject;
				T result = caseFirstCall(firstCall);
				if (result == null) result = caseMethodCall(firstCall);
				if (result == null) result = caseChainElement(firstCall);
				if (result == null) result = caseInstruction(firstCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.TO_LIST_CALL: {
				ToListCall toListCall = (ToListCall)theEObject;
				T result = caseToListCall(toListCall);
				if (result == null) result = caseMethodCall(toListCall);
				if (result == null) result = caseChainElement(toListCall);
				if (result == null) result = caseInstruction(toListCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.IS_EMPTY_CALL: {
				IsEmptyCall isEmptyCall = (IsEmptyCall)theEObject;
				T result = caseIsEmptyCall(isEmptyCall);
				if (result == null) result = caseMethodCall(isEmptyCall);
				if (result == null) result = caseChainElement(isEmptyCall);
				if (result == null) result = caseInstruction(isEmptyCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = caseInstruction(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.UNARY_EXPRESSION: {
				UnaryExpression unaryExpression = (UnaryExpression)theEObject;
				T result = caseUnaryExpression(unaryExpression);
				if (result == null) result = caseExpression(unaryExpression);
				if (result == null) result = caseInstruction(unaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.NOT_EXPRESSION: {
				NotExpression notExpression = (NotExpression)theEObject;
				T result = caseNotExpression(notExpression);
				if (result == null) result = caseUnaryExpression(notExpression);
				if (result == null) result = caseExpression(notExpression);
				if (result == null) result = caseInstruction(notExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.BINARY_EXPRESSION: {
				BinaryExpression binaryExpression = (BinaryExpression)theEObject;
				T result = caseBinaryExpression(binaryExpression);
				if (result == null) result = caseExpression(binaryExpression);
				if (result == null) result = caseInstruction(binaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.EQUALITY_EXPRESSION: {
				EqualityExpression equalityExpression = (EqualityExpression)theEObject;
				T result = caseEqualityExpression(equalityExpression);
				if (result == null) result = caseBinaryExpression(equalityExpression);
				if (result == null) result = caseExpression(equalityExpression);
				if (result == null) result = caseInstruction(equalityExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.DIFFERENCE_EXPRESSION: {
				DifferenceExpression differenceExpression = (DifferenceExpression)theEObject;
				T result = caseDifferenceExpression(differenceExpression);
				if (result == null) result = caseBinaryExpression(differenceExpression);
				if (result == null) result = caseExpression(differenceExpression);
				if (result == null) result = caseInstruction(differenceExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.OR_EXPRESSION: {
				OrExpression orExpression = (OrExpression)theEObject;
				T result = caseOrExpression(orExpression);
				if (result == null) result = caseBinaryExpression(orExpression);
				if (result == null) result = caseExpression(orExpression);
				if (result == null) result = caseInstruction(orExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.AND_EXPRESSION: {
				AndExpression andExpression = (AndExpression)theEObject;
				T result = caseAndExpression(andExpression);
				if (result == null) result = caseBinaryExpression(andExpression);
				if (result == null) result = caseExpression(andExpression);
				if (result == null) result = caseInstruction(andExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.GREATER_EXPRESSION: {
				GreaterExpression greaterExpression = (GreaterExpression)theEObject;
				T result = caseGreaterExpression(greaterExpression);
				if (result == null) result = caseBinaryExpression(greaterExpression);
				if (result == null) result = caseExpression(greaterExpression);
				if (result == null) result = caseInstruction(greaterExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.GREATER_OR_EQUAL_EXPRESSION: {
				GreaterOrEqualExpression greaterOrEqualExpression = (GreaterOrEqualExpression)theEObject;
				T result = caseGreaterOrEqualExpression(greaterOrEqualExpression);
				if (result == null) result = caseBinaryExpression(greaterOrEqualExpression);
				if (result == null) result = caseExpression(greaterOrEqualExpression);
				if (result == null) result = caseInstruction(greaterOrEqualExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.LESS_EXPRESSION: {
				LessExpression lessExpression = (LessExpression)theEObject;
				T result = caseLessExpression(lessExpression);
				if (result == null) result = caseBinaryExpression(lessExpression);
				if (result == null) result = caseExpression(lessExpression);
				if (result == null) result = caseInstruction(lessExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.LESS_OR_EQUAL_EXPRESSION: {
				LessOrEqualExpression lessOrEqualExpression = (LessOrEqualExpression)theEObject;
				T result = caseLessOrEqualExpression(lessOrEqualExpression);
				if (result == null) result = caseBinaryExpression(lessOrEqualExpression);
				if (result == null) result = caseExpression(lessOrEqualExpression);
				if (result == null) result = caseInstruction(lessOrEqualExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.AFFECTATION_EXPRESSION: {
				AffectationExpression affectationExpression = (AffectationExpression)theEObject;
				T result = caseAffectationExpression(affectationExpression);
				if (result == null) result = caseBinaryExpression(affectationExpression);
				if (result == null) result = caseExpression(affectationExpression);
				if (result == null) result = caseInstruction(affectationExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.STRING_LITERAL: {
				StringLiteral stringLiteral = (StringLiteral)theEObject;
				T result = caseStringLiteral(stringLiteral);
				if (result == null) result = caseExpression(stringLiteral);
				if (result == null) result = caseInstruction(stringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.INTEGER_LITERAL: {
				IntegerLiteral integerLiteral = (IntegerLiteral)theEObject;
				T result = caseIntegerLiteral(integerLiteral);
				if (result == null) result = caseExpression(integerLiteral);
				if (result == null) result = caseInstruction(integerLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.DOUBLE_LITERAL: {
				DoubleLiteral doubleLiteral = (DoubleLiteral)theEObject;
				T result = caseDoubleLiteral(doubleLiteral);
				if (result == null) result = caseExpression(doubleLiteral);
				if (result == null) result = caseInstruction(doubleLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GremlinPackage.BOOLEAN_LITERAL: {
				BooleanLiteral booleanLiteral = (BooleanLiteral)theEObject;
				T result = caseBooleanLiteral(booleanLiteral);
				if (result == null) result = caseExpression(booleanLiteral);
				if (result == null) result = caseInstruction(booleanLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGremlinScript(GremlinScript object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstruction(Instruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vector Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vector Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVectorType(VectorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Chain Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Chain Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChainElement(ChainElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Closure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Closure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClosure(Closure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Closure It</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Closure It</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClosureIt(ClosureIt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableAccess(VariableAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pipe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePipe(Pipe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identity Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identity Pipe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentityPipe(IdentityPipe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fill Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fill Pipe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFillPipe(FillPipe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Start Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start Pipe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStartPipe(StartPipe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vertices Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vertices Pipe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVerticesPipe(VerticesPipe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edges Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edges Pipe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgesPipe(EdgesPipe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Pipe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyPipe(PropertyPipe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Out EPipe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Out EPipe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutEPipe(OutEPipe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>In EPipe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>In EPipe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInEPipe(InEPipe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>In VPipe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>In VPipe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInVPipe(InVPipe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Out VPipe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Out VPipe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutVPipe(OutVPipe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Pipe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilterPipe(FilterPipe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transform Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transform Pipe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransformPipe(TransformPipe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodCall(MethodCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Next Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Next Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNextCall(NextCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Next Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Next Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasNextCall(HasNextCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Index Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndexCall(IndexCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Count Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Count Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCountCall(CountCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>First Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>First Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFirstCall(FirstCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>To List Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>To List Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToListCall(ToListCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Empty Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Empty Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIsEmptyCall(IsEmptyCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryExpression(UnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotExpression(NotExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryExpression(BinaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equality Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equality Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEqualityExpression(EqualityExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Difference Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Difference Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDifferenceExpression(DifferenceExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrExpression(OrExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndExpression(AndExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Greater Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Greater Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGreaterExpression(GreaterExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Greater Or Equal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Greater Or Equal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGreaterOrEqualExpression(GreaterOrEqualExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Less Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Less Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLessExpression(LessExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Less Or Equal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Less Or Equal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLessOrEqualExpression(LessOrEqualExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Affectation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Affectation Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAffectationExpression(AffectationExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteral(StringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerLiteral(IntegerLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleLiteral(DoubleLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteral(BooleanLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //GremlinSwitch
