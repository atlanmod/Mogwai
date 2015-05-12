/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scatter Step</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getScatterStep()
 * @model
 * @generated
 */
public interface ScatterStep extends Step {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nres.append(\"scatter\");\nif(getNextElement() != null) {\n\tres.append(\".\").append(getNextElement().toString());\n}\nreturn res.toString();'"
     * @generated
     */
	String toString();

} // ScatterStep
