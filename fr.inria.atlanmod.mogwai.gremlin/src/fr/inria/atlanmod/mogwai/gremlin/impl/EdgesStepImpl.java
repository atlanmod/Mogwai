/**
 */
package fr.inria.atlanmod.mogwai.gremlin.impl;

import fr.inria.atlanmod.mogwai.gremlin.EdgesStep;
import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edges Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.EdgesStepImpl#getRelationshipName <em>Relationship Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgesStepImpl extends StepImpl implements EdgesStep {
	/**
     * The default value of the '{@link #getRelationshipName() <em>Relationship Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRelationshipName()
     * @generated
     * @ordered
     */
	protected static final String RELATIONSHIP_NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getRelationshipName() <em>Relationship Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRelationshipName()
     * @generated
     * @ordered
     */
	protected String relationshipName = RELATIONSHIP_NAME_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EdgesStepImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return GremlinPackage.Literals.EDGES_STEP;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getRelationshipName() {
        return relationshipName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRelationshipName(String newRelationshipName) {
        String oldRelationshipName = relationshipName;
        relationshipName = newRelationshipName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GremlinPackage.EDGES_STEP__RELATIONSHIP_NAME, oldRelationshipName, relationshipName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case GremlinPackage.EDGES_STEP__RELATIONSHIP_NAME:
                return getRelationshipName();
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
            case GremlinPackage.EDGES_STEP__RELATIONSHIP_NAME:
                setRelationshipName((String)newValue);
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
            case GremlinPackage.EDGES_STEP__RELATIONSHIP_NAME:
                setRelationshipName(RELATIONSHIP_NAME_EDEFAULT);
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
            case GremlinPackage.EDGES_STEP__RELATIONSHIP_NAME:
                return RELATIONSHIP_NAME_EDEFAULT == null ? relationshipName != null : !RELATIONSHIP_NAME_EDEFAULT.equals(relationshipName);
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
        result.append(" (relationshipName: ");
        result.append(relationshipName);
        result.append(')');
        return result.toString();
    }

} //EdgesStepImpl
