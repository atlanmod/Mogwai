/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traversal Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.TraversalElement#getNextElement <em>Next Element</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.TraversalElement#getPreviousElement <em>Previous Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getTraversalElement()
 * @model abstract="true"
 * @generated
 */
public interface TraversalElement extends Instruction {
	/**
	 * Returns the value of the '<em><b>Next Element</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link fr.inria.atlanmod.mogwai.gremlin.TraversalElement#getPreviousElement <em>Previous Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Element</em>' containment reference.
	 * @see #setNextElement(TraversalElement)
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getTraversalElement_NextElement()
	 * @see fr.inria.atlanmod.mogwai.gremlin.TraversalElement#getPreviousElement
	 * @model opposite="previousElement" containment="true"
	 * @generated
	 */
	TraversalElement getNextElement();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.TraversalElement#getNextElement <em>Next Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Element</em>' containment reference.
	 * @see #getNextElement()
	 * @generated
	 */
	void setNextElement(TraversalElement value);

	/**
	 * Returns the value of the '<em><b>Previous Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.inria.atlanmod.mogwai.gremlin.TraversalElement#getNextElement <em>Next Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Previous Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Previous Element</em>' container reference.
	 * @see #setPreviousElement(TraversalElement)
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getTraversalElement_PreviousElement()
	 * @see fr.inria.atlanmod.mogwai.gremlin.TraversalElement#getNextElement
	 * @model opposite="nextElement" transient="false"
	 * @generated
	 */
	TraversalElement getPreviousElement();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.TraversalElement#getPreviousElement <em>Previous Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Previous Element</em>' container reference.
	 * @see #getPreviousElement()
	 * @generated
	 */
	void setPreviousElement(TraversalElement value);

} // TraversalElement
