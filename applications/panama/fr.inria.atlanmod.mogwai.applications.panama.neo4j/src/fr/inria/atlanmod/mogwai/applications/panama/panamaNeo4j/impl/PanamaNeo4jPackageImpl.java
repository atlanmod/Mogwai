/**
 */
package fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl;

import fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Entity;
import fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Officer;
import fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.PanamaNeo4jFactory;
import fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.PanamaNeo4jPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PanamaNeo4jPackageImpl extends EPackageImpl implements PanamaNeo4jPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass officerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

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
	 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.PanamaNeo4jPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PanamaNeo4jPackageImpl() {
		super(eNS_URI, PanamaNeo4jFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PanamaNeo4jPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PanamaNeo4jPackage init() {
		if (isInited) return (PanamaNeo4jPackage)EPackage.Registry.INSTANCE.getEPackage(PanamaNeo4jPackage.eNS_URI);

		// Obtain or create and register package
		PanamaNeo4jPackageImpl thePanamaNeo4jPackage = (PanamaNeo4jPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PanamaNeo4jPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PanamaNeo4jPackageImpl());

		isInited = true;

		// Create package meta-data objects
		thePanamaNeo4jPackage.createPackageContents();

		// Initialize created meta-data
		thePanamaNeo4jPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePanamaNeo4jPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PanamaNeo4jPackage.eNS_URI, thePanamaNeo4jPackage);
		return thePanamaNeo4jPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOfficer() {
		return officerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOfficer_Name() {
		return (EAttribute)officerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOfficer_OFFICER_OF() {
		return (EReference)officerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntity() {
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntity_Name() {
		return (EAttribute)entityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PanamaNeo4jFactory getPanamaNeo4jFactory() {
		return (PanamaNeo4jFactory)getEFactoryInstance();
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
		officerEClass = createEClass(OFFICER);
		createEAttribute(officerEClass, OFFICER__NAME);
		createEReference(officerEClass, OFFICER__OFFICER_OF);

		entityEClass = createEClass(ENTITY);
		createEAttribute(entityEClass, ENTITY__NAME);
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
		initEClass(officerEClass, Officer.class, "Officer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOfficer_Name(), ecorePackage.getEString(), "name", null, 0, 1, Officer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOfficer_OFFICER_OF(), this.getEntity(), null, "OFFICER_OF", null, 0, -1, Officer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntity_Name(), ecorePackage.getEString(), "name", null, 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PanamaNeo4jPackageImpl
