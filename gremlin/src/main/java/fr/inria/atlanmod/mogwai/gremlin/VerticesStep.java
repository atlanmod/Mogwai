/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vertices Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.VerticesStep#getVertexId <em>Vertex Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getVerticesStep()
 * @model
 * @generated
 */
public interface VerticesStep extends Step {
	/**
     * Returns the value of the '<em><b>Vertex Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertex Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Vertex Id</em>' attribute.
     * @see #setVertexId(String)
     * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getVerticesStep_VertexId()
     * @model
     * @generated
     */
	String getVertexId();

	/**
     * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.VerticesStep#getVertexId <em>Vertex Id</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Vertex Id</em>' attribute.
     * @see #getVertexId()
     * @generated
     */
	void setVertexId(String value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nif(getVertexId() == null) {\n\tres.append(\"V\");\n}\nelse {\n\tres.append(\"v(\").append(getVertexId()).append(\")\");\n}\nif(getNextElement() != null) {\n\tres.append(\".\").append(getNextElement().toString());\n}\nreturn res.toString();'"
     * @generated
     */
	String toString();

} // VerticesStep
