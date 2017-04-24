/**
 */
package org.eclipse.gmt.modisco.java;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gmt.modisco.java.Comment#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.Comment#isEnclosedByParent <em>Enclosed By Parent</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.Comment#isPrefixOfParent <em>Prefix Of Parent</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gmt.modisco.java.JavaPackage#getComment()
 * @model abstract="true"
 * @generated
 */
public interface Comment extends ASTNode {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see org.eclipse.gmt.modisco.java.JavaPackage#getComment_Content()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.modisco.java.Comment#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

	/**
	 * Returns the value of the '<em><b>Enclosed By Parent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enclosed By Parent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enclosed By Parent</em>' attribute.
	 * @see #setEnclosedByParent(boolean)
	 * @see org.eclipse.gmt.modisco.java.JavaPackage#getComment_EnclosedByParent()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isEnclosedByParent();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.modisco.java.Comment#isEnclosedByParent <em>Enclosed By Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enclosed By Parent</em>' attribute.
	 * @see #isEnclosedByParent()
	 * @generated
	 */
	void setEnclosedByParent(boolean value);

	/**
	 * Returns the value of the '<em><b>Prefix Of Parent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix Of Parent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix Of Parent</em>' attribute.
	 * @see #setPrefixOfParent(boolean)
	 * @see org.eclipse.gmt.modisco.java.JavaPackage#getComment_PrefixOfParent()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isPrefixOfParent();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.modisco.java.Comment#isPrefixOfParent <em>Prefix Of Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix Of Parent</em>' attribute.
	 * @see #isPrefixOfParent()
	 * @generated
	 */
	void setPrefixOfParent(boolean value);

} // Comment
