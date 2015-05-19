/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edges Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.EdgesStep#getRelationshipName <em>Relationship Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getEdgesStep()
 * @model
 * @generated
 */
public interface EdgesStep extends Step {
	/**
     * Returns the value of the '<em><b>Relationship Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relationship Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Relationship Name</em>' attribute.
     * @see #setRelationshipName(String)
     * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getEdgesStep_RelationshipName()
     * @model
     * @generated
     */
	String getRelationshipName();

	/**
     * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.EdgesStep#getRelationshipName <em>Relationship Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Relationship Name</em>' attribute.
     * @see #getRelationshipName()
     * @generated
     */
	void setRelationshipName(String value);

} // EdgesStep
