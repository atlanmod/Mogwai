/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gather Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.GatherStep#getClosure <em>Closure</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getGatherStep()
 * @model
 * @generated
 */
public interface GatherStep extends Step {
	/**
	 * Returns the value of the '<em><b>Closure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Closure</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Closure</em>' containment reference.
	 * @see #setClosure(Closure)
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getGatherStep_Closure()
	 * @model containment="true"
	 * @generated
	 */
	Closure getClosure();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.GatherStep#getClosure <em>Closure</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Closure</em>' containment reference.
	 * @see #getClosure()
	 * @generated
	 */
	void setClosure(Closure value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nres.append(\"gather\");\nif(getClosure() != null) {\n\tres.append(getClosure().toString());\n}\nif(getNextElement() != null) {\n\tres.append(\".\").append(getNextElement().toString());\n}\nreturn res.toString();'"
	 * @generated
	 */
	String toString();

} // GatherStep
