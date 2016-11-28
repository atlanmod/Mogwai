/**
 */
package fr.inria.atlanmod.mogwai.gremlin;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.MethodDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.MethodDeclaration#getParameters <em>Parameters</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.MethodDeclaration#getInstructions <em>Instructions</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getMethodDeclaration()
 * @model
 * @generated
 */
public interface MethodDeclaration extends Instruction {
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
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getMethodDeclaration_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.MethodDeclaration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' attribute list.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getMethodDeclaration_Parameters()
	 * @model
	 * @generated
	 */
	EList<String> getParameters();

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
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getMethodDeclaration_Instructions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Instruction> getInstructions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nres.append(\"def \");\nres.append(getName());\nres.append(\"(\");\nint gen = 0;\nfor(String s : getParameters()) {\n\tres.append(s);\n\tgen++;\n\tif(gen < getParameters().size()) {\n\t\tres.append(\", \");\n\t}\n}\nres.append(\") {\");\nfor(Instruction i : getInstructions()) {\n\tres.append(i.toString()).append(\";\");\n}\nres.append(\"}\");\nreturn res.toString();'"
	 * @generated
	 */
	String toString();

} // MethodDeclaration
