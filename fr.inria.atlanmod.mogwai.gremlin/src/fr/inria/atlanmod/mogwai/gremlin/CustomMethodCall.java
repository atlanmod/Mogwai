/**
 */
package fr.inria.atlanmod.mogwai.gremlin;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Method Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.CustomMethodCall#getName <em>Name</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.CustomMethodCall#getParams <em>Params</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getCustomMethodCall()
 * @model
 * @generated
 */
public interface CustomMethodCall extends MethodCall {
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
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getCustomMethodCall_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.CustomMethodCall#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Params</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Params</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Params</em>' attribute list.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getCustomMethodCall_Params()
	 * @model
	 * @generated
	 */
	EList<String> getParams();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nres.append(name);\nres.append(\"(\");\nif(params != null) {\n\tString delim = \"\";\n\tfor(String p : params) {\n\t\tres.append(delim).append(p);\n\t\tdelim = \",\";\n\t}\n}\nres.append(\")\");\nif(getNextElement() != null) {\n\tres.append(\".\").append(getNextElement().toString());\n}\nreturn res.toString();'"
	 * @generated
	 */
	String toString();

} // CustomMethodCall
