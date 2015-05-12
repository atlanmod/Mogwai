/**
 */
package fr.inria.atlanmod.mogwai.gremlin.impl;

import fr.inria.atlanmod.mogwai.gremlin.GreaterOrEqualExpression;
import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Greater Or Equal Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class GreaterOrEqualExpressionImpl extends BinaryExpressionImpl implements GreaterOrEqualExpression {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected GreaterOrEqualExpressionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return GremlinPackage.Literals.GREATER_OR_EQUAL_EXPRESSION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String toString() {
        StringBuffer res = new StringBuffer();
        res.append(getLeft().toString()).append(" >= ").append(getRight().toString());
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
            case GremlinPackage.GREATER_OR_EQUAL_EXPRESSION___TO_STRING:
                return toString();
        }
        return super.eInvoke(operationID, arguments);
    }

} //GreaterOrEqualExpressionImpl
