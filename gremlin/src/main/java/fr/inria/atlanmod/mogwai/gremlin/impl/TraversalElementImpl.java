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

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traversal Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.TraversalElementImpl#getNextElement <em>Next Element</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.TraversalElementImpl#getPreviousElement <em>Previous Element</em>}</li>
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
				msgs = ((InternalEObject)nextElement).eInverseRemove(this, GremlinPackage.TRAVERSAL_ELEMENT__PREVIOUS_ELEMENT, TraversalElement.class, msgs);
			if (newNextElement != null)
				msgs = ((InternalEObject)newNextElement).eInverseAdd(this, GremlinPackage.TRAVERSAL_ELEMENT__PREVIOUS_ELEMENT, TraversalElement.class, msgs);
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
	public TraversalElement getPreviousElement() {
		if (eContainerFeatureID() != GremlinPackage.TRAVERSAL_ELEMENT__PREVIOUS_ELEMENT) return null;
		return (TraversalElement)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPreviousElement(TraversalElement newPreviousElement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPreviousElement, GremlinPackage.TRAVERSAL_ELEMENT__PREVIOUS_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreviousElement(TraversalElement newPreviousElement) {
		if (newPreviousElement != eInternalContainer() || (eContainerFeatureID() != GremlinPackage.TRAVERSAL_ELEMENT__PREVIOUS_ELEMENT && newPreviousElement != null)) {
			if (EcoreUtil.isAncestor(this, newPreviousElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPreviousElement != null)
				msgs = ((InternalEObject)newPreviousElement).eInverseAdd(this, GremlinPackage.TRAVERSAL_ELEMENT__NEXT_ELEMENT, TraversalElement.class, msgs);
			msgs = basicSetPreviousElement(newPreviousElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GremlinPackage.TRAVERSAL_ELEMENT__PREVIOUS_ELEMENT, newPreviousElement, newPreviousElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GremlinPackage.TRAVERSAL_ELEMENT__NEXT_ELEMENT:
				if (nextElement != null)
					msgs = ((InternalEObject)nextElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.TRAVERSAL_ELEMENT__NEXT_ELEMENT, null, msgs);
				return basicSetNextElement((TraversalElement)otherEnd, msgs);
			case GremlinPackage.TRAVERSAL_ELEMENT__PREVIOUS_ELEMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPreviousElement((TraversalElement)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case GremlinPackage.TRAVERSAL_ELEMENT__PREVIOUS_ELEMENT:
				return basicSetPreviousElement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GremlinPackage.TRAVERSAL_ELEMENT__PREVIOUS_ELEMENT:
				return eInternalContainer().eInverseRemove(this, GremlinPackage.TRAVERSAL_ELEMENT__NEXT_ELEMENT, TraversalElement.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case GremlinPackage.TRAVERSAL_ELEMENT__PREVIOUS_ELEMENT:
				return getPreviousElement();
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
			case GremlinPackage.TRAVERSAL_ELEMENT__PREVIOUS_ELEMENT:
				setPreviousElement((TraversalElement)newValue);
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
			case GremlinPackage.TRAVERSAL_ELEMENT__PREVIOUS_ELEMENT:
				setPreviousElement((TraversalElement)null);
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
			case GremlinPackage.TRAVERSAL_ELEMENT__PREVIOUS_ELEMENT:
				return getPreviousElement() != null;
		}
		return super.eIsSet(featureID);
	}

} //TraversalElementImpl
