/**
 */
package fr.inria.atlanmod.mogwai.gremlin.impl;

import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;
import fr.inria.atlanmod.mogwai.gremlin.TraversalElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traversal Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.TraversalElementImpl#getNextElement <em>Next Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TraversalElementImpl extends InstructionImpl implements TraversalElement {
	/**
	 * The cached value of the '{@link #getNextElement() <em>Next Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextElement()
	 * @generated
	 * @ordered
	 */
	protected TraversalElement nextElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraversalElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GremlinPackage.Literals.TRAVERSAL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraversalElement getNextElement() {
		return nextElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNextElement(TraversalElement newNextElement, NotificationChain msgs) {
		TraversalElement oldNextElement = nextElement;
		nextElement = newNextElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GremlinPackage.TRAVERSAL_ELEMENT__NEXT_ELEMENT, oldNextElement, newNextElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextElement(TraversalElement newNextElement) {
		if (newNextElement != nextElement) {
			NotificationChain msgs = null;
			if (nextElement != null)
				msgs = ((InternalEObject)nextElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.TRAVERSAL_ELEMENT__NEXT_ELEMENT, null, msgs);
			if (newNextElement != null)
				msgs = ((InternalEObject)newNextElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.TRAVERSAL_ELEMENT__NEXT_ELEMENT, null, msgs);
			msgs = basicSetNextElement(newNextElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GremlinPackage.TRAVERSAL_ELEMENT__NEXT_ELEMENT, newNextElement, newNextElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GremlinPackage.TRAVERSAL_ELEMENT__NEXT_ELEMENT:
				return basicSetNextElement(null, msgs);
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
			case GremlinPackage.TRAVERSAL_ELEMENT__NEXT_ELEMENT:
				return getNextElement();
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
			case GremlinPackage.TRAVERSAL_ELEMENT__NEXT_ELEMENT:
				setNextElement((TraversalElement)newValue);
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
			case GremlinPackage.TRAVERSAL_ELEMENT__NEXT_ELEMENT:
				setNextElement((TraversalElement)null);
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
			case GremlinPackage.TRAVERSAL_ELEMENT__NEXT_ELEMENT:
				return nextElement != null;
		}
		return super.eIsSet(featureID);
	}

} //TraversalElementImpl
