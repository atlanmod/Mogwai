/**
 */
package fr.inria.atlanmod.mogwai.gremlin.impl;

import fr.inria.atlanmod.mogwai.gremlin.FillStep;
import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;
import fr.inria.atlanmod.mogwai.gremlin.Instruction;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fill Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.FillStepImpl#getInstruction <em>Instruction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FillStepImpl extends StepImpl implements FillStep {
	/**
	 * The cached value of the '{@link #getInstruction() <em>Instruction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstruction()
	 * @generated
	 * @ordered
	 */
	protected Instruction instruction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FillStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GremlinPackage.Literals.FILL_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Instruction getInstruction() {
		return instruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInstruction(Instruction newInstruction, NotificationChain msgs) {
		Instruction oldInstruction = instruction;
		instruction = newInstruction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GremlinPackage.FILL_STEP__INSTRUCTION, oldInstruction, newInstruction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstruction(Instruction newInstruction) {
		if (newInstruction != instruction) {
			NotificationChain msgs = null;
			if (instruction != null)
				msgs = ((InternalEObject)instruction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.FILL_STEP__INSTRUCTION, null, msgs);
			if (newInstruction != null)
				msgs = ((InternalEObject)newInstruction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GremlinPackage.FILL_STEP__INSTRUCTION, null, msgs);
			msgs = basicSetInstruction(newInstruction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GremlinPackage.FILL_STEP__INSTRUCTION, newInstruction, newInstruction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append("fill(").append(getInstruction().toString()).append(")");
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
			case GremlinPackage.FILL_STEP__INSTRUCTION:
				return basicSetInstruction(null, msgs);
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
			case GremlinPackage.FILL_STEP__INSTRUCTION:
				return getInstruction();
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
			case GremlinPackage.FILL_STEP__INSTRUCTION:
				setInstruction((Instruction)newValue);
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
			case GremlinPackage.FILL_STEP__INSTRUCTION:
				setInstruction((Instruction)null);
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
			case GremlinPackage.FILL_STEP__INSTRUCTION:
				return instruction != null;
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
			case GremlinPackage.FILL_STEP___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //FillStepImpl
