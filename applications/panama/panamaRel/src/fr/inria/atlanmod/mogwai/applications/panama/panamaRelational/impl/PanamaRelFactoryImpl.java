/**
 */
package fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.impl;

import fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PanamaRelFactoryImpl extends EFactoryImpl implements PanamaRelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PanamaRelFactory init() {
		try {
			PanamaRelFactory thePanamaRelFactory = (PanamaRelFactory)EPackage.Registry.INSTANCE.getEFactory(PanamaRelPackage.eNS_URI);
			if (thePanamaRelFactory != null) {
				return thePanamaRelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PanamaRelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PanamaRelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PanamaRelPackage.PANAMA_OFFICERS: return createPanamaOfficers();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PanamaOfficers createPanamaOfficers() {
		PanamaOfficersImpl panamaOfficers = new PanamaOfficersImpl();
		return panamaOfficers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PanamaRelPackage getPanamaRelPackage() {
		return (PanamaRelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PanamaRelPackage getPackage() {
		return PanamaRelPackage.eINSTANCE;
	}

} //PanamaRelFactoryImpl
