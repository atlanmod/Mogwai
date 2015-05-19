/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.IndexCall#getIndexName <em>Index Name</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.IndexCall#getIndexProperty <em>Index Property</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.IndexCall#getIndexQuery <em>Index Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getIndexCall()
 * @model
 * @generated
 */
public interface IndexCall extends MethodCall {
	/**
     * Returns the value of the '<em><b>Index Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Index Name</em>' attribute.
     * @see #setIndexName(String)
     * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getIndexCall_IndexName()
     * @model required="true"
     * @generated
     */
	String getIndexName();

	/**
     * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.IndexCall#getIndexName <em>Index Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Index Name</em>' attribute.
     * @see #getIndexName()
     * @generated
     */
	void setIndexName(String value);

	/**
     * Returns the value of the '<em><b>Index Property</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Index Property</em>' attribute.
     * @see #setIndexProperty(String)
     * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getIndexCall_IndexProperty()
     * @model required="true"
     * @generated
     */
	String getIndexProperty();

	/**
     * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.IndexCall#getIndexProperty <em>Index Property</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Index Property</em>' attribute.
     * @see #getIndexProperty()
     * @generated
     */
	void setIndexProperty(String value);

	/**
     * Returns the value of the '<em><b>Index Query</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Query</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Index Query</em>' attribute.
     * @see #setIndexQuery(String)
     * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getIndexCall_IndexQuery()
     * @model required="true"
     * @generated
     */
	String getIndexQuery();

	/**
     * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.IndexCall#getIndexQuery <em>Index Query</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Index Query</em>' attribute.
     * @see #getIndexQuery()
     * @generated
     */
	void setIndexQuery(String value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nres.append(\"getIndex(\\\"\"+getIndexName()+\"\\\",Vertex.class)[[\"+getIndexProperty()+\":\\\"\"+getIndexQuery()+\"\\\"]]\");\nif(getNextElement() != null) {\n\tres.append(\".\").append(getNextElement().toString());\n}\nreturn res.toString();'"
     * @generated
     */
	String toString();

} // IndexCall
