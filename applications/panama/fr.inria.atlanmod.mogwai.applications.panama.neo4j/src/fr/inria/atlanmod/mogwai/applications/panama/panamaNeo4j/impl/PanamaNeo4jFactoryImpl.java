/**
 */
package fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl;

import fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.*;

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
public class PanamaNeo4jFactoryImpl extends EFactoryImpl implements PanamaNeo4jFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PanamaNeo4jFactory init() {
		try {
			PanamaNeo4jFactory thePanamaNeo4jFactory = (PanamaNeo4jFactory)EPackage.Registry.INSTANCE.getEFactory(PanamaNeo4jPackage.eNS_URI);
			if (thePanamaNeo4jFactory != null) {
				return thePanamaNeo4jFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PanamaNeo4jFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PanamaNeo4jFactoryImpl() {
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
			case PanamaNeo4jPackage.OFFICER: return createOfficer();
			case PanamaNeo4jPackage.ENTITY: return createEntity();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Officer createOfficer() {
		OfficerImpl officer = new OfficerImpl();
		return officer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity createEntity() {
		EntityImpl entity = new EntityImpl();
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PanamaNeo4jPackage getPanamaNeo4jPackage() {
		return (PanamaNeo4jPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PanamaNeo4jPackage getPackage() {
		return PanamaNeo4jPackage.eINSTANCE;
	}

} //PanamaNeo4jFactoryImpl
