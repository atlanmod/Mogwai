/**
 */
package fr.inria.atlanmod.mogwai.gremlin.impl;

import fr.inria.atlanmod.mogwai.gremlin.CollectionDefinition;
import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;
import fr.inria.atlanmod.mogwai.gremlin.Instruction;
import fr.inria.atlanmod.mogwai.gremlin.TypeDeclaration;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.CollectionDefinitionImpl#getValues <em>Values</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.CollectionDefinitionImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionDefinitionImpl extends TraversalElementImpl implements CollectionDefinition {
	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Instruction> values;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TypeDeclaration type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GremlinPackage.Literals.COLLECTION_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Instruction> getValues() {
		if (values == null) {
			values = new EObjectContainmentEList<Instruction>(Instruction.class, this, GremlinPackage.COLLECTION_DEFINITION__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeDeclaration getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(TypeDeclaration newType, NotificationChain msgs) {
		TypeDeclaration oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GremlinPackage.COLLECTION_DEFINITION__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TypeDeclaration newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.COLLECTION_DEFINITION__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.COLLECTION_DEFINITION__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GremlinPackage.COLLECTION_DEFINITION__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		StringBuffer res = new StringBuffer();
		if(getType() != null) {
			res.append("(");
		}
		// if(getValues().size() == 1 && getValues().get(0) instanceof fr.inria.atlanmod.mogwai.gremlin.VariableAccess) {
		//	res.append(((fr.inria.atlanmod.mogwai.gremlin.VariableAccess)getValues().get(0)).getName());
		// } else {
		res.append("[");
		int gen = 0;
		for(Instruction i : getValues()) {
			res.append(i.toString());
			gen++;
			if(gen < getValues().size()) {
				res.append(",");
			}
		}
		res.append("]");
		if(getType() != null) {
			res.append(" as ");
			res.append(getType().toString());
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
			case GremlinPackage.COLLECTION_DEFINITION__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
			case GremlinPackage.COLLECTION_DEFINITION__TYPE:
				return basicSetType(null, msgs);
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
			case GremlinPackage.COLLECTION_DEFINITION__VALUES:
				return getValues();
			case GremlinPackage.COLLECTION_DEFINITION__TYPE:
				return getType();
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
			case GremlinPackage.COLLECTION_DEFINITION__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends Instruction>)newValue);
				return;
			case GremlinPackage.COLLECTION_DEFINITION__TYPE:
				setType((TypeDeclaration)newValue);
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
			case GremlinPackage.COLLECTION_DEFINITION__VALUES:
				getValues().clear();
				return;
			case GremlinPackage.COLLECTION_DEFINITION__TYPE:
				setType((TypeDeclaration)null);
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
			case GremlinPackage.COLLECTION_DEFINITION__VALUES:
				return values != null && !values.isEmpty();
			case GremlinPackage.COLLECTION_DEFINITION__TYPE:
				return type != null;
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
			case GremlinPackage.COLLECTION_DEFINITION___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //CollectionDefinitionImpl
