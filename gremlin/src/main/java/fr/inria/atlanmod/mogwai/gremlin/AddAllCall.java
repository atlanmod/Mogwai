/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add All Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.AddAllCall#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getAddAllCall()
 * @model
 * @generated
 */
public interface AddAllCall extends MethodCall {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Instruction)
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getAddAllCall_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Instruction getValue();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.AddAllCall#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Instruction value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nres.append(\"addAll(\");\nres.append(getValue().toString()+\")\");\nif(getNextElement() != null) {\n\tres.append(\".\").append(getNextElement().toString());\n}\nreturn res.toString();'"
	 * @generated
	 */
	String toString();

} // AddAllCall
