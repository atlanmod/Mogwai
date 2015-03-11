/**
 */
package fr.inria.atlanmod.mogwai.gremlin;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vector Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.VectorType#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getVectorType()
 * @model
 * @generated
 */
public interface VectorType extends Instruction {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.atlanmod.mogwai.gremlin.Instruction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getVectorType_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<Instruction> getValues();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nres.append(\"[\");\nint gen = 0;\nfor(Instruction i : getValues()) {\n\tres.append(i.toString());\n\tgen++;\n\tif(gen < getValues().size()) {\n\t\tres.append(\",\");\n\t}\n}\nres.append(\"]\");\nreturn res.toString();'"
	 * @generated
	 */
	String toString();

} // VectorType
