/**
 * *******************************************************************************
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 
 *     Fabien Giquel (Mia-Software) - initial API and implementation
 *     Gregoire DUPE (Mia-Software) - initial API and implementation
 * *******************************************************************************
 *
 * $Id$
 */
package org.eclipse.gmt.modisco.java.cdo.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.gmt.modisco.java.Expression;
import org.eclipse.gmt.modisco.java.InfixExpression;
import org.eclipse.gmt.modisco.java.InfixExpressionKind;

import org.eclipse.gmt.modisco.java.cdo.meta.JavaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infix Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmt.modisco.java.cdo.impl.InfixExpressionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.cdo.impl.InfixExpressionImpl#getRightOperand <em>Right Operand</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.cdo.impl.InfixExpressionImpl#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.cdo.impl.InfixExpressionImpl#getExtendedOperands <em>Extended Operands</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InfixExpressionImpl extends ExpressionImpl implements InfixExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfixExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaPackage.eINSTANCE.getInfixExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfixExpressionKind getOperator() {
		return (InfixExpressionKind)eGet(JavaPackage.eINSTANCE.getInfixExpression_Operator(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(InfixExpressionKind newOperator) {
		eSet(JavaPackage.eINSTANCE.getInfixExpression_Operator(), newOperator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRightOperand() {
		return (Expression)eGet(JavaPackage.eINSTANCE.getInfixExpression_RightOperand(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightOperand(Expression newRightOperand) {
		eSet(JavaPackage.eINSTANCE.getInfixExpression_RightOperand(), newRightOperand);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getLeftOperand() {
		return (Expression)eGet(JavaPackage.eINSTANCE.getInfixExpression_LeftOperand(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftOperand(Expression newLeftOperand) {
		eSet(JavaPackage.eINSTANCE.getInfixExpression_LeftOperand(), newLeftOperand);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Expression> getExtendedOperands() {
		return (EList<Expression>)eGet(JavaPackage.eINSTANCE.getInfixExpression_ExtendedOperands(), true);
	}

} //InfixExpressionImpl
