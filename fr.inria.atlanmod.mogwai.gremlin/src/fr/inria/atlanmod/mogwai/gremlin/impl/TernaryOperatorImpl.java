/**
 */
package fr.inria.atlanmod.mogwai.gremlin.impl;

import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;
import fr.inria.atlanmod.mogwai.gremlin.Instruction;
import fr.inria.atlanmod.mogwai.gremlin.TernaryOperator;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ternary Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.TernaryOperatorImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.TernaryOperatorImpl#getIfTrue <em>If True</em>}</li>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.TernaryOperatorImpl#getIfFalse <em>If False</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TernaryOperatorImpl extends ExpressionImpl implements TernaryOperator {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Instruction condition;

	/**
	 * The cached value of the '{@link #getIfTrue() <em>If True</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfTrue()
	 * @generated
	 * @ordered
	 */
	protected Instruction ifTrue;

	/**
	 * The cached value of the '{@link #getIfFalse() <em>If False</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfFalse()
	 * @generated
	 * @ordered
	 */
	protected Instruction ifFalse;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TernaryOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GremlinPackage.Literals.TERNARY_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Instruction getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(Instruction newCondition, NotificationChain msgs) {
		Instruction oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GremlinPackage.TERNARY_OPERATOR__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(Instruction newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.TERNARY_OPERATOR__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.TERNARY_OPERATOR__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GremlinPackage.TERNARY_OPERATOR__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Instruction getIfTrue() {
		return ifTrue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIfTrue(Instruction newIfTrue, NotificationChain msgs) {
		Instruction oldIfTrue = ifTrue;
		ifTrue = newIfTrue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GremlinPackage.TERNARY_OPERATOR__IF_TRUE, oldIfTrue, newIfTrue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfTrue(Instruction newIfTrue) {
		if (newIfTrue != ifTrue) {
			NotificationChain msgs = null;
			if (ifTrue != null)
				msgs = ((InternalEObject)ifTrue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.TERNARY_OPERATOR__IF_TRUE, null, msgs);
			if (newIfTrue != null)
				msgs = ((InternalEObject)newIfTrue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.TERNARY_OPERATOR__IF_TRUE, null, msgs);
			msgs = basicSetIfTrue(newIfTrue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GremlinPackage.TERNARY_OPERATOR__IF_TRUE, newIfTrue, newIfTrue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Instruction getIfFalse() {
		return ifFalse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIfFalse(Instruction newIfFalse, NotificationChain msgs) {
		Instruction oldIfFalse = ifFalse;
		ifFalse = newIfFalse;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GremlinPackage.TERNARY_OPERATOR__IF_FALSE, oldIfFalse, newIfFalse);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfFalse(Instruction newIfFalse) {
		if (newIfFalse != ifFalse) {
			NotificationChain msgs = null;
			if (ifFalse != null)
				msgs = ((InternalEObject)ifFalse).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.TERNARY_OPERATOR__IF_FALSE, null, msgs);
			if (newIfFalse != null)
				msgs = ((InternalEObject)newIfFalse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.TERNARY_OPERATOR__IF_FALSE, null, msgs);
			msgs = basicSetIfFalse(newIfFalse, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GremlinPackage.TERNARY_OPERATOR__IF_FALSE, newIfFalse, newIfFalse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append("(");
		res.append(getCondition().toString())
		.append(" ? ").append(getIfTrue().toString()).append(" : ").
		append(getIfFalse().toString()).append(")");
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
			case GremlinPackage.TERNARY_OPERATOR__CONDITION:
				return basicSetCondition(null, msgs);
			case GremlinPackage.TERNARY_OPERATOR__IF_TRUE:
				return basicSetIfTrue(null, msgs);
			case GremlinPackage.TERNARY_OPERATOR__IF_FALSE:
				return basicSetIfFalse(null, msgs);
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
			case GremlinPackage.TERNARY_OPERATOR__CONDITION:
				return getCondition();
			case GremlinPackage.TERNARY_OPERATOR__IF_TRUE:
				return getIfTrue();
			case GremlinPackage.TERNARY_OPERATOR__IF_FALSE:
				return getIfFalse();
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
			case GremlinPackage.TERNARY_OPERATOR__CONDITION:
				setCondition((Instruction)newValue);
				return;
			case GremlinPackage.TERNARY_OPERATOR__IF_TRUE:
				setIfTrue((Instruction)newValue);
				return;
			case GremlinPackage.TERNARY_OPERATOR__IF_FALSE:
				setIfFalse((Instruction)newValue);
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
			case GremlinPackage.TERNARY_OPERATOR__CONDITION:
				setCondition((Instruction)null);
				return;
			case GremlinPackage.TERNARY_OPERATOR__IF_TRUE:
				setIfTrue((Instruction)null);
				return;
			case GremlinPackage.TERNARY_OPERATOR__IF_FALSE:
				setIfFalse((Instruction)null);
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
			case GremlinPackage.TERNARY_OPERATOR__CONDITION:
				return condition != null;
			case GremlinPackage.TERNARY_OPERATOR__IF_TRUE:
				return ifTrue != null;
			case GremlinPackage.TERNARY_OPERATOR__IF_FALSE:
				return ifFalse != null;
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
			case GremlinPackage.TERNARY_OPERATOR___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //TernaryOperatorImpl
