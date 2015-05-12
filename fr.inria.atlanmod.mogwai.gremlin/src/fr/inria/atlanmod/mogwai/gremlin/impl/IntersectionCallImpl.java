/**
 */
package fr.inria.atlanmod.mogwai.gremlin.impl;

import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;
import fr.inria.atlanmod.mogwai.gremlin.Instruction;
import fr.inria.atlanmod.mogwai.gremlin.IntersectionCall;
import fr.inria.atlanmod.mogwai.gremlin.TypeDeclaration;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intersection Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.IntersectionCallImpl#getLeftCollection <em>Left Collection</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.IntersectionCallImpl#getRightCollection <em>Right Collection</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.IntersectionCallImpl#getCast <em>Cast</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntersectionCallImpl extends MethodCallImpl implements IntersectionCall {
	/**
     * The cached value of the '{@link #getLeftCollection() <em>Left Collection</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLeftCollection()
     * @generated
     * @ordered
     */
	protected Instruction leftCollection;

	/**
     * The cached value of the '{@link #getRightCollection() <em>Right Collection</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRightCollection()
     * @generated
     * @ordered
     */
	protected Instruction rightCollection;

	/**
     * The cached value of the '{@link #getCast() <em>Cast</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCast()
     * @generated
     * @ordered
     */
	protected TypeDeclaration cast;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected IntersectionCallImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return GremlinPackage.Literals.INTERSECTION_CALL;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Instruction getLeftCollection() {
        return leftCollection;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetLeftCollection(Instruction newLeftCollection, NotificationChain msgs) {
        Instruction oldLeftCollection = leftCollection;
        leftCollection = newLeftCollection;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GremlinPackage.INTERSECTION_CALL__LEFT_COLLECTION, oldLeftCollection, newLeftCollection);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setLeftCollection(Instruction newLeftCollection) {
        if (newLeftCollection != leftCollection) {
            NotificationChain msgs = null;
            if (leftCollection != null)
                msgs = ((InternalEObject)leftCollection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.INTERSECTION_CALL__LEFT_COLLECTION, null, msgs);
            if (newLeftCollection != null)
                msgs = ((InternalEObject)newLeftCollection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.INTERSECTION_CALL__LEFT_COLLECTION, null, msgs);
            msgs = basicSetLeftCollection(newLeftCollection, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GremlinPackage.INTERSECTION_CALL__LEFT_COLLECTION, newLeftCollection, newLeftCollection));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Instruction getRightCollection() {
        return rightCollection;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetRightCollection(Instruction newRightCollection, NotificationChain msgs) {
        Instruction oldRightCollection = rightCollection;
        rightCollection = newRightCollection;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GremlinPackage.INTERSECTION_CALL__RIGHT_COLLECTION, oldRightCollection, newRightCollection);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRightCollection(Instruction newRightCollection) {
        if (newRightCollection != rightCollection) {
            NotificationChain msgs = null;
            if (rightCollection != null)
                msgs = ((InternalEObject)rightCollection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.INTERSECTION_CALL__RIGHT_COLLECTION, null, msgs);
            if (newRightCollection != null)
                msgs = ((InternalEObject)newRightCollection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.INTERSECTION_CALL__RIGHT_COLLECTION, null, msgs);
            msgs = basicSetRightCollection(newRightCollection, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GremlinPackage.INTERSECTION_CALL__RIGHT_COLLECTION, newRightCollection, newRightCollection));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeDeclaration getCast() {
        return cast;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetCast(TypeDeclaration newCast, NotificationChain msgs) {
        TypeDeclaration oldCast = cast;
        cast = newCast;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GremlinPackage.INTERSECTION_CALL__CAST, oldCast, newCast);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCast(TypeDeclaration newCast) {
        if (newCast != cast) {
            NotificationChain msgs = null;
            if (cast != null)
                msgs = ((InternalEObject)cast).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.INTERSECTION_CALL__CAST, null, msgs);
            if (newCast != null)
                msgs = ((InternalEObject)newCast).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.INTERSECTION_CALL__CAST, null, msgs);
            msgs = basicSetCast(newCast, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GremlinPackage.INTERSECTION_CALL__CAST, newCast, newCast));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String toString() {
        StringBuffer res = new StringBuffer();
        if(getCast() != null) {
            res.append("(");
        }
        res.append("computeIntersection(");
        res.append(getLeftCollection().toString());
        res.append(", ");
        res.append(getRightCollection().toString());
        res.append(")");
        if(getCast() != null) {
            res.append(" as " + getCast().toString());
            res.append(")");
        }
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
            case GremlinPackage.INTERSECTION_CALL__LEFT_COLLECTION:
                return basicSetLeftCollection(null, msgs);
            case GremlinPackage.INTERSECTION_CALL__RIGHT_COLLECTION:
                return basicSetRightCollection(null, msgs);
            case GremlinPackage.INTERSECTION_CALL__CAST:
                return basicSetCast(null, msgs);
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
            case GremlinPackage.INTERSECTION_CALL__LEFT_COLLECTION:
                return getLeftCollection();
            case GremlinPackage.INTERSECTION_CALL__RIGHT_COLLECTION:
                return getRightCollection();
            case GremlinPackage.INTERSECTION_CALL__CAST:
                return getCast();
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
            case GremlinPackage.INTERSECTION_CALL__LEFT_COLLECTION:
                setLeftCollection((Instruction)newValue);
                return;
            case GremlinPackage.INTERSECTION_CALL__RIGHT_COLLECTION:
                setRightCollection((Instruction)newValue);
                return;
            case GremlinPackage.INTERSECTION_CALL__CAST:
                setCast((TypeDeclaration)newValue);
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
            case GremlinPackage.INTERSECTION_CALL__LEFT_COLLECTION:
                setLeftCollection((Instruction)null);
                return;
            case GremlinPackage.INTERSECTION_CALL__RIGHT_COLLECTION:
                setRightCollection((Instruction)null);
                return;
            case GremlinPackage.INTERSECTION_CALL__CAST:
                setCast((TypeDeclaration)null);
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
            case GremlinPackage.INTERSECTION_CALL__LEFT_COLLECTION:
                return leftCollection != null;
            case GremlinPackage.INTERSECTION_CALL__RIGHT_COLLECTION:
                return rightCollection != null;
            case GremlinPackage.INTERSECTION_CALL__CAST:
                return cast != null;
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
            case GremlinPackage.INTERSECTION_CALL___TO_STRING:
                return toString();
        }
        return super.eInvoke(operationID, arguments);
    }

} //IntersectionCallImpl
