/**
 */
package fr.inria.atlanmod.mogwai.applications.panama.panamaRelational;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Panama Officers</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaOfficers#getName <em>Name</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaOfficers#getCompany <em>Company</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaRelPackage#getPanamaOfficers()
 * @model
 * @generated
 */
public interface PanamaOfficers extends EObject {
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
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaRelPackage#getPanamaOfficers_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaOfficers#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Company</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Company</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Company</em>' attribute.
	 * @see #setCompany(String)
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaRelPackage#getPanamaOfficers_Company()
	 * @model
	 * @generated
	 */
	String getCompany();

	/**
	 * Sets the value of the '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaOfficers#getCompany <em>Company</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Company</em>' attribute.
	 * @see #getCompany()
	 * @generated
	 */
	void setCompany(String value);

} // PanamaOfficers
