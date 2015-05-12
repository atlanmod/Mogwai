/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration#getValue <em>Value</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getVariableDeclaration()
 * @model
 * @generated
 */
public interface VariableDeclaration extends Instruction {
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
     * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getVariableDeclaration_Name()
     * @model required="true"
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

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
     * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getVariableDeclaration_Value()
     * @model containment="true"
     * @generated
     */
	Instruction getValue();

	/**
     * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration#getValue <em>Value</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' containment reference.
     * @see #getValue()
     * @generated
     */
	void setValue(Instruction value);

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
     * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getVariableDeclaration_Type()
     * @model containment="true"
     * @generated
     */
	TypeDeclaration getType();

	/**
     * Sets the value of the '{@link fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration#getType <em>Type</em>}' containment reference.
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
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(getType() != null) {\n\tif(getValue() != null) {\n\t\treturn getType().toString() + \" \" + getName() + \" = \" + getValue().toString();\n\t}\n\telse {\n\t\treturn getType().toString() + \" \" + getName();\n\t}\n}\nelse {\n\tif(getValue() != null) {\n\t\treturn \"def \" + getName() + \" = \" + getValue().toString();\n\t}\n\telse {\n\t\treturn \"def \" + getName();\n\t}\n}'"
     * @generated
     */
	String toString();

} // VariableDeclaration
