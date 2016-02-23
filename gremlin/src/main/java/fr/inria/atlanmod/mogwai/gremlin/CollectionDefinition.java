/**
 */
package fr.inria.atlanmod.mogwai.gremlin;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.CollectionDefinition#getValues <em>Values</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.CollectionDefinition#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getCollectionDefinition()
 * @model
 * @generated
 */
public interface CollectionDefinition extends TraversalElement {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.atlanmod.mogwai.gremlin.Instruction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getCollectionDefinition_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<Instruction> getValues();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(TypeDeclaration)
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getCollectionDefinition_Type()
	 * @model containment="true"
	 * @generated
	 */
	TypeDeclaration getType();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.CollectionDefinition#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeDeclaration value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nif(getType() != null) {\n\tres.append(\"(\");\n}\nif(getValues().size() == 1 && getValues().get(0) instanceof fr.inria.atlanmod.mogwai.gremlin.VariableAccess) {\n\tres.append(((fr.inria.atlanmod.mogwai.gremlin.VariableAccess)getValues().get(0)).getName());\n} else {\nres.append(\"[\");\nint gen = 0;\nfor(Instruction i : getValues()) {\n\tres.append(i.toString());\n\tgen++;\n\tif(gen < getValues().size()) {\n\t\tres.append(\",\");\n\t}\n}\nres.append(\"]\");\n}\nif(getType() != null) {\n\tres.append(\" as \");\n\tres.append(getType().toString());\n\tres.append(\")\");\n}\nif(getNextElement() != null) {\n\tres.append(\".\").append(getNextElement().toString());\n}\nreturn res.toString();'"
	 * @generated
	 */
	String toString();

} // CollectionDefinition
