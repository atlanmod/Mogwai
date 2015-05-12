/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Union Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.UnionCall#getLeftCollection <em>Left Collection</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.UnionCall#getRightCollection <em>Right Collection</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.UnionCall#getCast <em>Cast</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getUnionCall()
 * @model
 * @generated
 */
public interface UnionCall extends MethodCall {
	/**
     * Returns the value of the '<em><b>Left Collection</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Collection</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Left Collection</em>' containment reference.
     * @see #setLeftCollection(Instruction)
     * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getUnionCall_LeftCollection()
     * @model containment="true" required="true"
     * @generated
     */
	Instruction getLeftCollection();

	/**
     * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.UnionCall#getLeftCollection <em>Left Collection</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Left Collection</em>' containment reference.
     * @see #getLeftCollection()
     * @generated
     */
	void setLeftCollection(Instruction value);

	/**
     * Returns the value of the '<em><b>Right Collection</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Collection</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Right Collection</em>' containment reference.
     * @see #setRightCollection(Instruction)
     * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getUnionCall_RightCollection()
     * @model containment="true" required="true"
     * @generated
     */
	Instruction getRightCollection();

	/**
     * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.UnionCall#getRightCollection <em>Right Collection</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Right Collection</em>' containment reference.
     * @see #getRightCollection()
     * @generated
     */
	void setRightCollection(Instruction value);

	/**
     * Returns the value of the '<em><b>Cast</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cast</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Cast</em>' containment reference.
     * @see #setCast(TypeDeclaration)
     * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getUnionCall_Cast()
     * @model containment="true"
     * @generated
     */
	TypeDeclaration getCast();

	/**
     * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.UnionCall#getCast <em>Cast</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cast</em>' containment reference.
     * @see #getCast()
     * @generated
     */
	void setCast(TypeDeclaration value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nif(getCast() != null) {\n\tres.append(\"(\");\n}\nres.append(\"computeUnion(\");\nres.append(getLeftCollection().toString());\nres.append(\", \");\nres.append(getRightCollection().toString());\nres.append(\")\");\nif(getCast() != null) {\n\tres.append(\" as \" + getCast().toString());\n\tres.append(\")\");\n}\nif(getNextElement() != null) {\n\tres.append(\".\").append(getNextElement().toString());\n}\nreturn res.toString();'"
     * @generated
     */
	String toString();

} // UnionCall
