/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Chain Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.ChainElement#getNextElement <em>Next Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getChainElement()
 * @model abstract="true"
 * @generated
 */
public interface ChainElement extends Instruction {
	/**
	 * Returns the value of the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Element</em>' containment reference.
	 * @see #setNextElement(ChainElement)
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getChainElement_NextElement()
	 * @model containment="true"
	 * @generated
	 */
	ChainElement getNextElement();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.ChainElement#getNextElement <em>Next Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Element</em>' containment reference.
	 * @see #getNextElement()
	 * @generated
	 */
	void setNextElement(ChainElement value);

} // ChainElement
