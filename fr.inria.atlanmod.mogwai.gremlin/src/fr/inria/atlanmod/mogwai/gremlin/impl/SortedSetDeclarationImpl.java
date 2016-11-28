/**
 */
package fr.inria.atlanmod.mogwai.gremlin.impl;

import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;
import fr.inria.atlanmod.mogwai.gremlin.SortedSetDeclaration;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sorted Set Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SortedSetDeclarationImpl extends TypeDeclarationImpl implements SortedSetDeclaration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SortedSetDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GremlinPackage.Literals.SORTED_SET_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		return " SortedSet";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GremlinPackage.SORTED_SET_DECLARATION___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //SortedSetDeclarationImpl
