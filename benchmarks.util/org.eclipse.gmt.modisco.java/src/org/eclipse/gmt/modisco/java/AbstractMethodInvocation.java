/**
 */
package org.eclipse.gmt.modisco.java;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Method Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gmt.modisco.java.AbstractMethodInvocation#getMethod <em>Method</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.AbstractMethodInvocation#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.AbstractMethodInvocation#getTypeArguments <em>Type Arguments</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gmt.modisco.java.JavaPackage#getAbstractMethodInvocation()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMethodInvocation extends ASTNode {
	/**
	 * Returns the value of the '<em><b>Method</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmt.modisco.java.AbstractMethodDeclaration#getUsages <em>Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' reference.
	 * @see #setMethod(AbstractMethodDeclaration)
	 * @see org.eclipse.gmt.modisco.java.JavaPackage#getAbstractMethodInvocation_Method()
	 * @see org.eclipse.gmt.modisco.java.AbstractMethodDeclaration#getUsages
	 * @model opposite="usages" required="true" ordered="false"
	 * @generated
	 */
	AbstractMethodDeclaration getMethod();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.modisco.java.AbstractMethodInvocation#getMethod <em>Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' reference.
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(AbstractMethodDeclaration value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmt.modisco.java.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.eclipse.gmt.modisco.java.JavaPackage#getAbstractMethodInvocation_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getArguments();

	/**
	 * Returns the value of the '<em><b>Type Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmt.modisco.java.TypeAccess}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Arguments</em>' containment reference list.
	 * @see org.eclipse.gmt.modisco.java.JavaPackage#getAbstractMethodInvocation_TypeArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeAccess> getTypeArguments();

} // AbstractMethodInvocation
