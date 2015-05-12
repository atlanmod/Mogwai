/**
 */
package fr.inria.atlanmod.mogwai.gremlin.impl;

import fr.inria.atlanmod.mogwai.gremlin.ClosureIt;
import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Closure It</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ClosureItImpl extends VariableAccessImpl implements ClosureIt {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ClosureItImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return GremlinPackage.Literals.CLOSURE_IT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String toString() {
        return super.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
        return "it";
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
        if (baseClass == VariableAccess.class) {
            switch (baseOperationID) {
                case GremlinPackage.VARIABLE_ACCESS___TO_STRING: return GremlinPackage.CLOSURE_IT___TO_STRING;
                default: return super.eDerivedOperationID(baseOperationID, baseClass);
            }
        }
        return super.eDerivedOperationID(baseOperationID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
        switch (operationID) {
            case GremlinPackage.CLOSURE_IT___TO_STRING:
                return toString();
            case GremlinPackage.CLOSURE_IT___GET_NAME:
                return getName();
        }
        return super.eInvoke(operationID, arguments);
    }

} //ClosureItImpl
