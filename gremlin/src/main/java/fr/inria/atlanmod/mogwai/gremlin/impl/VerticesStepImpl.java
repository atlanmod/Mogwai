/**
 */
package fr.inria.atlanmod.mogwai.gremlin.impl;

import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;
import fr.inria.atlanmod.mogwai.gremlin.VerticesStep;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vertices Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.VerticesStepImpl#getVertexId <em>Vertex Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VerticesStepImpl extends StepImpl implements VerticesStep {
	/**
     * The default value of the '{@link #getVertexId() <em>Vertex Id</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVertexId()
     * @generated
     * @ordered
     */
	protected static final String VERTEX_ID_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getVertexId() <em>Vertex Id</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVertexId()
     * @generated
     * @ordered
     */
	protected String vertexId = VERTEX_ID_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected VerticesStepImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return GremlinPackage.Literals.VERTICES_STEP;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getVertexId() {
        return vertexId;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setVertexId(String newVertexId) {
        String oldVertexId = vertexId;
        vertexId = newVertexId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GremlinPackage.VERTICES_STEP__VERTEX_ID, oldVertexId, vertexId));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String toString() {
        StringBuffer res = new StringBuffer();
        if(getVertexId() == null) {
            res.append("V");
        }
        else {
            res.append("v(").append(getVertexId()).append(")");
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case GremlinPackage.VERTICES_STEP__VERTEX_ID:
                return getVertexId();
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
            case GremlinPackage.VERTICES_STEP__VERTEX_ID:
                setVertexId((String)newValue);
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
            case GremlinPackage.VERTICES_STEP__VERTEX_ID:
                setVertexId(VERTEX_ID_EDEFAULT);
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
            case GremlinPackage.VERTICES_STEP__VERTEX_ID:
                return VERTEX_ID_EDEFAULT == null ? vertexId != null : !VERTEX_ID_EDEFAULT.equals(vertexId);
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
            case GremlinPackage.VERTICES_STEP___TO_STRING:
                return toString();
        }
        return super.eInvoke(operationID, arguments);
    }

} //VerticesStepImpl
