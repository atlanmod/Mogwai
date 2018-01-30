/**
 */
package fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.PanamaNeo4jFactory
 * @model kind="package"
 * @generated
 */
public interface PanamaNeo4jPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "panamaNeo4j";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.com/panamaNeo4j";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "panamaNeo4j";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PanamaNeo4jPackage eINSTANCE = fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl.PanamaNeo4jPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl.OfficerImpl <em>Officer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl.OfficerImpl
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl.PanamaNeo4jPackageImpl#getOfficer()
	 * @generated
	 */
	int OFFICER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFICER__NAME = 0;

	/**
	 * The feature id for the '<em><b>OFFICER OF</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFICER__OFFICER_OF = 1;

	/**
	 * The number of structural features of the '<em>Officer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFICER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Officer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFICER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl.EntityImpl
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl.PanamaNeo4jPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = 0;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Officer <em>Officer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Officer</em>'.
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Officer
	 * @generated
	 */
	EClass getOfficer();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Officer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Officer#getName()
	 * @see #getOfficer()
	 * @generated
	 */
	EAttribute getOfficer_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Officer#getOFFICER_OF <em>OFFICER OF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>OFFICER OF</em>'.
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Officer#getOFFICER_OF()
	 * @see #getOfficer()
	 * @generated
	 */
	EReference getOfficer_OFFICER_OF();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Entity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Entity#getName()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PanamaNeo4jFactory getPanamaNeo4jFactory();

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
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl.OfficerImpl <em>Officer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl.OfficerImpl
		 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl.PanamaNeo4jPackageImpl#getOfficer()
		 * @generated
		 */
		EClass OFFICER = eINSTANCE.getOfficer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFICER__NAME = eINSTANCE.getOfficer_Name();

		/**
		 * The meta object literal for the '<em><b>OFFICER OF</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OFFICER__OFFICER_OF = eINSTANCE.getOfficer_OFFICER_OF();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl.EntityImpl
		 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl.PanamaNeo4jPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__NAME = eINSTANCE.getEntity_Name();

	}

} //PanamaNeo4jPackage
