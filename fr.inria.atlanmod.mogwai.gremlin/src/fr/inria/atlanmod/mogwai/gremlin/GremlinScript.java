/**
 */
package fr.inria.atlanmod.mogwai.gremlin;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.GremlinScript#getInstructions <em>Instructions</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getGremlinScript()
 * @model
 * @generated
 */
public interface GremlinScript extends EObject {
	/**
     * Returns the value of the '<em><b>Instructions</b></em>' containment reference list.
     * The list contents are of type {@link fr.inria.atlanmod.mogwai.gremlin.Instruction}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instructions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Instructions</em>' containment reference list.
     * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getGremlinScript_Instructions()
     * @model containment="true"
     * @generated
     */
	EList<Instruction> getInstructions();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer sb = new StringBuffer();\nfor(Instruction i : getInstructions()) {\n\tsb.append(i.toString()+\";\\n\");\n}\nreturn sb.toString();'"
     * @generated
     */
	String toString();

} // GremlinScript
