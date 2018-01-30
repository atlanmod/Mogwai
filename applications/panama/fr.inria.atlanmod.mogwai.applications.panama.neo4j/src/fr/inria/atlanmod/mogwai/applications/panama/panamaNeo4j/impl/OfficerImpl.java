/**
 */
package fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl;

import fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Entity;
import fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.Officer;
import fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.PanamaNeo4jPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Officer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl.OfficerImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl.OfficerImpl#getOFFICER_OF <em>OFFICER OF</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OfficerImpl extends MinimalEObjectImpl.Container implements Officer {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOFFICER_OF() <em>OFFICER OF</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOFFICER_OF()
	 * @generated
	 * @ordered
	 */
	protected EList<Entity> officeR_OF;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OfficerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PanamaNeo4jPackage.Literals.OFFICER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PanamaNeo4jPackage.OFFICER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Entity> getOFFICER_OF() {
		if (officeR_OF == null) {
			officeR_OF = new EObjectContainmentEList<Entity>(Entity.class, this, PanamaNeo4jPackage.OFFICER__OFFICER_OF);
		}
		return officeR_OF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PanamaNeo4jPackage.OFFICER__OFFICER_OF:
				return ((InternalEList<?>)getOFFICER_OF()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PanamaNeo4jPackage.OFFICER__NAME:
				return getName();
			case PanamaNeo4jPackage.OFFICER__OFFICER_OF:
				return getOFFICER_OF();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PanamaNeo4jPackage.OFFICER__NAME:
				setName((String)newValue);
				return;
			case PanamaNeo4jPackage.OFFICER__OFFICER_OF:
				getOFFICER_OF().clear();
				getOFFICER_OF().addAll((Collection<? extends Entity>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PanamaNeo4jPackage.OFFICER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PanamaNeo4jPackage.OFFICER__OFFICER_OF:
				getOFFICER_OF().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PanamaNeo4jPackage.OFFICER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PanamaNeo4jPackage.OFFICER__OFFICER_OF:
				return officeR_OF != null && !officeR_OF.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //OfficerImpl
