/**
 */
package org.eclipse.gmt.modisco.java.neoemf.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.gmt.modisco.java.Expression;
import org.eclipse.gmt.modisco.java.PostfixExpression;
import org.eclipse.gmt.modisco.java.PostfixExpressionKind;

import org.eclipse.gmt.modisco.java.neoemf.meta.JavaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Postfix Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmt.modisco.java.neoemf.impl.PostfixExpressionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.neoemf.impl.PostfixExpressionImpl#getOperand <em>Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PostfixExpressionImpl extends ExpressionImpl implements PostfixExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PostfixExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaPackage.eINSTANCE.getPostfixExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostfixExpressionKind getOperator() {
		return (PostfixExpressionKind)eGet(JavaPackage.eINSTANCE.getPostfixExpression_Operator(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(PostfixExpressionKind newOperator) {
		eSet(JavaPackage.eINSTANCE.getPostfixExpression_Operator(), newOperator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getOperand() {
		return (Expression)eGet(JavaPackage.eINSTANCE.getPostfixExpression_Operand(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperand(Expression newOperand) {
		eSet(JavaPackage.eINSTANCE.getPostfixExpression_Operand(), newOperand);
	}

} //PostfixExpressionImpl
