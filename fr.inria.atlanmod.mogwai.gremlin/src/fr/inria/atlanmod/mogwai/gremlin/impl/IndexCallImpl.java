/**
 */
package fr.inria.atlanmod.mogwai.gremlin.impl;

import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;
import fr.inria.atlanmod.mogwai.gremlin.IndexCall;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.IndexCallImpl#getIndexName <em>Index Name</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.IndexCallImpl#getIndexProperty <em>Index Property</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.IndexCallImpl#getIndexQuery <em>Index Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IndexCallImpl extends MethodCallImpl implements IndexCall {
	/**
	 * The default value of the '{@link #getIndexName() <em>Index Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexName()
	 * @generated
	 * @ordered
	 */
	protected static final String INDEX_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIndexName() <em>Index Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexName()
	 * @generated
	 * @ordered
	 */
	protected String indexName = INDEX_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndexProperty() <em>Index Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String INDEX_PROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIndexProperty() <em>Index Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexProperty()
	 * @generated
	 * @ordered
	 */
	protected String indexProperty = INDEX_PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndexQuery() <em>Index Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexQuery()
	 * @generated
	 * @ordered
	 */
	protected static final String INDEX_QUERY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIndexQuery() <em>Index Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexQuery()
	 * @generated
	 * @ordered
	 */
	protected String indexQuery = INDEX_QUERY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GremlinPackage.Literals.INDEX_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIndexName() {
		return indexName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexName(String newIndexName) {
		String oldIndexName = indexName;
		indexName = newIndexName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GremlinPackage.INDEX_CALL__INDEX_NAME, oldIndexName, indexName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIndexProperty() {
		return indexProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexProperty(String newIndexProperty) {
		String oldIndexProperty = indexProperty;
		indexProperty = newIndexProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GremlinPackage.INDEX_CALL__INDEX_PROPERTY, oldIndexProperty, indexProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIndexQuery() {
		return indexQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexQuery(String newIndexQuery) {
		String oldIndexQuery = indexQuery;
		indexQuery = newIndexQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GremlinPackage.INDEX_CALL__INDEX_QUERY, oldIndexQuery, indexQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append("getIndex(\""+getIndexName()+"\",Vertex.class)[["+getIndexProperty()+":\""+getIndexQuery()+"\"]]");
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
			case GremlinPackage.INDEX_CALL__INDEX_NAME:
				return getIndexName();
			case GremlinPackage.INDEX_CALL__INDEX_PROPERTY:
				return getIndexProperty();
			case GremlinPackage.INDEX_CALL__INDEX_QUERY:
				return getIndexQuery();
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
			case GremlinPackage.INDEX_CALL__INDEX_NAME:
				setIndexName((String)newValue);
				return;
			case GremlinPackage.INDEX_CALL__INDEX_PROPERTY:
				setIndexProperty((String)newValue);
				return;
			case GremlinPackage.INDEX_CALL__INDEX_QUERY:
				setIndexQuery((String)newValue);
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
			case GremlinPackage.INDEX_CALL__INDEX_NAME:
				setIndexName(INDEX_NAME_EDEFAULT);
				return;
			case GremlinPackage.INDEX_CALL__INDEX_PROPERTY:
				setIndexProperty(INDEX_PROPERTY_EDEFAULT);
				return;
			case GremlinPackage.INDEX_CALL__INDEX_QUERY:
				setIndexQuery(INDEX_QUERY_EDEFAULT);
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
			case GremlinPackage.INDEX_CALL__INDEX_NAME:
				return INDEX_NAME_EDEFAULT == null ? indexName != null : !INDEX_NAME_EDEFAULT.equals(indexName);
			case GremlinPackage.INDEX_CALL__INDEX_PROPERTY:
				return INDEX_PROPERTY_EDEFAULT == null ? indexProperty != null : !INDEX_PROPERTY_EDEFAULT.equals(indexProperty);
			case GremlinPackage.INDEX_CALL__INDEX_QUERY:
				return INDEX_QUERY_EDEFAULT == null ? indexQuery != null : !INDEX_QUERY_EDEFAULT.equals(indexQuery);
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
			case GremlinPackage.INDEX_CALL___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //IndexCallImpl
