/**
 */
package fr.inria.atlanmod.mogwai.gremlin.impl;

import fr.inria.atlanmod.mogwai.gremlin.FirstCall;
import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>First Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class FirstCallImpl extends MethodCallImpl implements FirstCall {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FirstCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GremlinPackage.Literals.FIRST_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append("first()");
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GremlinPackage.FIRST_CALL___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //FirstCallImpl
