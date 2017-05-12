/**
 */
package fr.inria.atlanmod.mogwai.applications.panama.panamaRelational;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaRelFactory
 * @model kind="package"
 * @generated
 */
public interface PanamaRelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "panamaRelational";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.com/panamaRelational";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "panamaRelational";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PanamaRelPackage eINSTANCE = fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.impl.PanamaRelPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.impl.PanamaOfficersImpl <em>Panama Officers</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.impl.PanamaOfficersImpl
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.impl.PanamaRelPackageImpl#getPanamaOfficers()
	 * @generated
	 */
	int PANAMA_OFFICERS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANAMA_OFFICERS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Company</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANAMA_OFFICERS__COMPANY = 1;

	/**
	 * The number of structural features of the '<em>Panama Officers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANAMA_OFFICERS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Panama Officers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANAMA_OFFICERS_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaOfficers <em>Panama Officers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Panama Officers</em>'.
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaOfficers
	 * @generated
	 */
	EClass getPanamaOfficers();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaOfficers#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaOfficers#getName()
	 * @see #getPanamaOfficers()
	 * @generated
	 */
	EAttribute getPanamaOfficers_Name();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaOfficers#getCompany <em>Company</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Company</em>'.
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaOfficers#getCompany()
	 * @see #getPanamaOfficers()
	 * @generated
	 */
	EAttribute getPanamaOfficers_Company();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PanamaRelFactory getPanamaRelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.impl.PanamaOfficersImpl <em>Panama Officers</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.impl.PanamaOfficersImpl
		 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.impl.PanamaRelPackageImpl#getPanamaOfficers()
		 * @generated
		 */
		EClass PANAMA_OFFICERS = eINSTANCE.getPanamaOfficers();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PANAMA_OFFICERS__NAME = eINSTANCE.getPanamaOfficers_Name();

		/**
		 * The meta object literal for the '<em><b>Company</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PANAMA_OFFICERS__COMPANY = eINSTANCE.getPanamaOfficers_Company();

	}

} //PanamaRelPackage
