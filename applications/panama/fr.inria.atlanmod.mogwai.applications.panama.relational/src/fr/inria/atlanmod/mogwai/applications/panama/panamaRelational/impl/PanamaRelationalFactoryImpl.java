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
public class PanamaRelationalFactoryImpl extends EFactoryImpl implements PanamaRelationalFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PanamaRelationalFactory init() {
		try {
			PanamaRelationalFactory thePanamaRelationalFactory = (PanamaRelationalFactory)EPackage.Registry.INSTANCE.getEFactory(PanamaRelationalPackage.eNS_URI);
			if (thePanamaRelationalFactory != null) {
				return thePanamaRelationalFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PanamaRelationalFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PanamaRelationalFactoryImpl() {
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
			case PanamaRelationalPackage.PANAMA_OFFICERS: return createPanamaOfficers();
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
	public PanamaRelationalPackage getPanamaRelationalPackage() {
		return (PanamaRelationalPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PanamaRelationalPackage getPackage() {
		return PanamaRelationalPackage.eINSTANCE;
	}

} //PanamaRelationalFactoryImpl
