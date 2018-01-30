/**
 */
package fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Officer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Officer#getName <em>Name</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Officer#getOFFICER_OF <em>OFFICER OF</em>}</li>
 * </ul>
 *
 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.PanamaNeo4jPackage#getOfficer()
 * @model
 * @generated
 */
public interface Officer extends EObject {
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
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.PanamaNeo4jPackage#getOfficer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Officer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>OFFICER OF</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Entity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>OFFICER OF</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>OFFICER OF</em>' containment reference list.
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.PanamaNeo4jPackage#getOfficer_OFFICER_OF()
	 * @model containment="true"
	 * @generated
	 */
	EList<Entity> getOFFICER_OF();

} // Officer
