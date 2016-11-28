/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ternary Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.TernaryOperator#getCondition <em>Condition</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.TernaryOperator#getIfTrue <em>If True</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.TernaryOperator#getIfFalse <em>If False</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getTernaryOperator()
 * @model
 * @generated
 */
public interface TernaryOperator extends Expression {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Instruction)
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getTernaryOperator_Condition()
	 * @model containment="true"
	 * @generated
	 */
	Instruction getCondition();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.TernaryOperator#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Instruction value);

	/**
	 * Returns the value of the '<em><b>If True</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If True</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If True</em>' containment reference.
	 * @see #setIfTrue(Instruction)
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getTernaryOperator_IfTrue()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Instruction getIfTrue();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.TernaryOperator#getIfTrue <em>If True</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If True</em>' containment reference.
	 * @see #getIfTrue()
	 * @generated
	 */
	void setIfTrue(Instruction value);

	/**
	 * Returns the value of the '<em><b>If False</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If False</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If False</em>' containment reference.
	 * @see #setIfFalse(Instruction)
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getTernaryOperator_IfFalse()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Instruction getIfFalse();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.TernaryOperator#getIfFalse <em>If False</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If False</em>' containment reference.
	 * @see #getIfFalse()
	 * @generated
	 */
	void setIfFalse(Instruction value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nres.append(\"(\");\nres.append(getCondition().toString())\n.append(\" ? \").append(getIfTrue().toString()).append(\" : \").\nappend(getIfFalse().toString()).append(\")\");\nreturn res.toString();'"
	 * @generated
	 */
	String toString();

} // TernaryOperator
