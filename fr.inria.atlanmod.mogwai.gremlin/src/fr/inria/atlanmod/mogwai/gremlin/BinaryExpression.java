/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.BinaryExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.BinaryExpression#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getBinaryExpression()
 * @model
 * @generated
 */
public interface BinaryExpression extends Expression {
	/**
     * Returns the value of the '<em><b>Left</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Left</em>' containment reference.
     * @see #setLeft(Instruction)
     * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getBinaryExpression_Left()
     * @model containment="true" required="true"
     * @generated
     */
	Instruction getLeft();

	/**
     * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.BinaryExpression#getLeft <em>Left</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Left</em>' containment reference.
     * @see #getLeft()
     * @generated
     */
	void setLeft(Instruction value);

	/**
     * Returns the value of the '<em><b>Right</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Right</em>' containment reference.
     * @see #setRight(Instruction)
     * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getBinaryExpression_Right()
     * @model containment="true" required="true"
     * @generated
     */
	Instruction getRight();

	/**
     * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.BinaryExpression#getRight <em>Right</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Right</em>' containment reference.
     * @see #getRight()
     * @generated
     */
	void setRight(Instruction value);

} // BinaryExpression
