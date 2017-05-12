/**
 */
package fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.impl;

import fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaOfficers;
import fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaRelFactory;
import fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaRelPackage;

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
public class PanamaRelPackageImpl extends EPackageImpl implements PanamaRelPackage {
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
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaRelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PanamaRelPackageImpl() {
		super(eNS_URI, PanamaRelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PanamaRelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PanamaRelPackage init() {
		if (isInited) return (PanamaRelPackage)EPackage.Registry.INSTANCE.getEPackage(PanamaRelPackage.eNS_URI);

		// Obtain or create and register package
		PanamaRelPackageImpl thePanamaRelPackage = (PanamaRelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PanamaRelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PanamaRelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		thePanamaRelPackage.createPackageContents();

		// Initialize created meta-data
		thePanamaRelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePanamaRelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PanamaRelPackage.eNS_URI, thePanamaRelPackage);
		return thePanamaRelPackage;
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
	public PanamaRelFactory getPanamaRelFactory() {
		return (PanamaRelFactory)getEFactoryInstance();
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

} //PanamaRelPackageImpl
