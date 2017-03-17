/**
 */
package ClassDiagram.impl;

import ClassDiagram.ClassDiagramPackage;
import ClassDiagram.Column;
import ClassDiagram.Table;
import ClassDiagram.Type;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ClassDiagram.impl.ColumnImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link ClassDiagram.impl.ColumnImpl#getKeyOf <em>Key Of</em>}</li>
 *   <li>{@link ClassDiagram.impl.ColumnImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColumnImpl extends NamedImpl implements Column {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassDiagramPackage.Literals.COLUMN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table getOwner() {
		return (Table)eGet(ClassDiagramPackage.Literals.COLUMN__OWNER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Table newOwner) {
		eSet(ClassDiagramPackage.Literals.COLUMN__OWNER, newOwner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table getKeyOf() {
		return (Table)eGet(ClassDiagramPackage.Literals.COLUMN__KEY_OF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyOf(Table newKeyOf) {
		eSet(ClassDiagramPackage.Literals.COLUMN__KEY_OF, newKeyOf);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		return (Type)eGet(ClassDiagramPackage.Literals.COLUMN__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		eSet(ClassDiagramPackage.Literals.COLUMN__TYPE, newType);
	}

} //ColumnImpl
