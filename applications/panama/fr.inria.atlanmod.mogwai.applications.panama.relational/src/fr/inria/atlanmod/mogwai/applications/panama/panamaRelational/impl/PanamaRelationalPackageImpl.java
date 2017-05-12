/**
 */
package fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.impl;

import fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaOfficers;
import fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaRelationalFactory;
import fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaRelationalPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PanamaRelationalPackageImpl extends EPackageImpl implements PanamaRelationalPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass panamaOfficersEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaRelationalPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PanamaRelationalPackageImpl() {
		super(eNS_URI, PanamaRelationalFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link PanamaRelationalPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PanamaRelationalPackage init() {
		if (isInited) return (PanamaRelationalPackage)EPackage.Registry.INSTANCE.getEPackage(PanamaRelationalPackage.eNS_URI);

		// Obtain or create and register package
		PanamaRelationalPackageImpl thePanamaRelationalPackage = (PanamaRelationalPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PanamaRelationalPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PanamaRelationalPackageImpl());

		isInited = true;

		// Create package meta-data objects
		thePanamaRelationalPackage.createPackageContents();

		// Initialize created meta-data
		thePanamaRelationalPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePanamaRelationalPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PanamaRelationalPackage.eNS_URI, thePanamaRelationalPackage);
		return thePanamaRelationalPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPanamaOfficers() {
		return panamaOfficersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPanamaOfficers_Name() {
		return (EAttribute)panamaOfficersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPanamaOfficers_Company() {
		return (EAttribute)panamaOfficersEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PanamaRelationalFactory getPanamaRelationalFactory() {
		return (PanamaRelationalFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		panamaOfficersEClass = createEClass(PANAMA_OFFICERS);
		createEAttribute(panamaOfficersEClass, PANAMA_OFFICERS__NAME);
		createEAttribute(panamaOfficersEClass, PANAMA_OFFICERS__COMPANY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(panamaOfficersEClass, PanamaOfficers.class, "PanamaOfficers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPanamaOfficers_Name(), ecorePackage.getEString(), "name", null, 0, 1, PanamaOfficers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPanamaOfficers_Company(), ecorePackage.getEString(), "company", null, 0, 1, PanamaOfficers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PanamaRelationalPackageImpl
