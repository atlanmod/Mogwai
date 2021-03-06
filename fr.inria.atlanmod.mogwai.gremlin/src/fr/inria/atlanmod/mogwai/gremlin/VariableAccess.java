/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.VariableAccess#getName <em>Name</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.VariableAccess#getCast <em>Cast</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getVariableAccess()
 * @model
 * @generated
 */
public interface VariableAccess extends TraversalElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getVariableAccess_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.VariableAccess#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getVariableAccess_Cast()
	 * @model containment="true"
	 * @generated
	 */
	TypeDeclaration getCast();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.VariableAccess#getCast <em>Cast</em>}' containment reference.
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nif(getCast() != null) {\n\tres.append(\"(\");\n}\nres.append(getName());\nif(getNextElement() != null) {\n\tres.append(\".\").append(getNextElement().toString());\n}\nif(getCast() != null) {\n\tres.append(\" as \");\n\tres.append(getCast().toString());\n\tres.append(\")\");\n}\nreturn res.toString();'"
	 * @generated
	 */
	String toString();

} // VariableAccess
