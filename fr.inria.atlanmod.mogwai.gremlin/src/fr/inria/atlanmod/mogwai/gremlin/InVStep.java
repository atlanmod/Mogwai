/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>In VStep</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getInVStep()
 * @model
 * @generated
 */
public interface InVStep extends Step {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nres.append(\"inV\");\nif(getNextElement() != null) {\n\tres.append(\".\").append(getNextElement().toString());\n}\nreturn res.toString();'"
	 * @generated
	 */
	String toString();

} // InVStep
