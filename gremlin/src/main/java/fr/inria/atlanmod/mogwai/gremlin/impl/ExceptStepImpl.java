/**
 */
package fr.inria.atlanmod.mogwai.gremlin.impl;

import fr.inria.atlanmod.mogwai.gremlin.CollectionDefinition;
import fr.inria.atlanmod.mogwai.gremlin.ExceptStep;
import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Except Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.ExceptStepImpl#getCollection <em>Collection</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExceptStepImpl extends StepImpl implements ExceptStep {
	/**
	 * The cached value of the '{@link #getCollection() <em>Collection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollection()
	 * @generated
	 * @ordered
	 */
	protected CollectionDefinition collection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExceptStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GremlinPackage.Literals.EXCEPT_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionDefinition getCollection() {
		return collection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCollection(CollectionDefinition newCollection, NotificationChain msgs) {
		CollectionDefinition oldCollection = collection;
		collection = newCollection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GremlinPackage.EXCEPT_STEP__COLLECTION, oldCollection, newCollection);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollection(CollectionDefinition newCollection) {
		if (newCollection != collection) {
			NotificationChain msgs = null;
			if (collection != null)
				msgs = ((InternalEObject)collection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.EXCEPT_STEP__COLLECTION, null, msgs);
			if (newCollection != null)
				msgs = ((InternalEObject)newCollection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.EXCEPT_STEP__COLLECTION, null, msgs);
			msgs = basicSetCollection(newCollection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GremlinPackage.EXCEPT_STEP__COLLECTION, newCollection, newCollection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append("except(");
		res.append(getCollection().toString());
		res.append(")");
		if(getNextElement() != null) {
			res.append(".").append(getNextElement().toString());
		}
		return res.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GremlinPackage.EXCEPT_STEP__COLLECTION:
				return basicSetCollection(null, msgs);
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
			case GremlinPackage.EXCEPT_STEP__COLLECTION:
				return getCollection();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GremlinPackage.EXCEPT_STEP__COLLECTION:
				setCollection((CollectionDefinition)newValue);
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
			case GremlinPackage.EXCEPT_STEP__COLLECTION:
				setCollection((CollectionDefinition)null);
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
			case GremlinPackage.EXCEPT_STEP__COLLECTION:
				return collection != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GremlinPackage.EXCEPT_STEP___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ExceptStepImpl
