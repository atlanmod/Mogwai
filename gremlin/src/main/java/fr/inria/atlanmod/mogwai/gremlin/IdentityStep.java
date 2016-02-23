/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identity Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.IdentityStep#isNeeded <em>Needed</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getIdentityStep()
 * @model
 * @generated
 */
public interface IdentityStep extends Step {
	/**
	 * Returns the value of the '<em><b>Needed</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Needed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Needed</em>' attribute.
	 * @see #setNeeded(boolean)
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getIdentityStep_Needed()
	 * @model default="true"
	 * @generated
	 */
	boolean isNeeded();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.IdentityStep#isNeeded <em>Needed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Needed</em>' attribute.
	 * @see #isNeeded()
	 * @generated
	 */
	void setNeeded(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nif(needed) {\n\tres.append(\"_()\");\n\tif(getNextElement() != null) {\n\t\tres.append(\".\").append(getNextElement().toString());\n\t}\n}\nelse {\n\tif(getNextElement() != null) {\n\t\tres.append(getNextElement().toString());\n\t}\n}\nreturn res.toString();'"
	 * @generated
	 */
	String toString();

} // IdentityStep
