/**
 */
package ClassDiagram.impl;

import ClassDiagram.Attribute;
import ClassDiagram.ClassDiagramPackage;
import ClassDiagram.Classifier;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ClassDiagram.impl.AttributeImpl#getMultiValued <em>Multi Valued</em>}</li>
 *   <li>{@link ClassDiagram.impl.AttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link ClassDiagram.impl.AttributeImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeImpl extends NamedElementImpl implements Attribute {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassDiagramPackage.Literals.ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getMultiValued() {
		return (Boolean)eGet(ClassDiagramPackage.Literals.ATTRIBUTE__MULTI_VALUED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiValued(Boolean newMultiValued) {
		eSet(ClassDiagramPackage.Literals.ATTRIBUTE__MULTI_VALUED, newMultiValued);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getType() {
		return (Classifier)eGet(ClassDiagramPackage.Literals.ATTRIBUTE__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Classifier newType) {
		eSet(ClassDiagramPackage.Literals.ATTRIBUTE__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassDiagram.Class getOwner() {
		return (ClassDiagram.Class)eGet(ClassDiagramPackage.Literals.ATTRIBUTE__OWNER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(ClassDiagram.Class newOwner) {
		eSet(ClassDiagramPackage.Literals.ATTRIBUTE__OWNER, newOwner);
	}

} //AttributeImpl
