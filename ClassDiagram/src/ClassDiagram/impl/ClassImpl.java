/**
 */
package ClassDiagram.impl;

import ClassDiagram.Attribute;
import ClassDiagram.ClassDiagramPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ClassDiagram.impl.ClassImpl#getSuper <em>Super</em>}</li>
 *   <li>{@link ClassDiagram.impl.ClassImpl#getAttr <em>Attr</em>}</li>
 *   <li>{@link ClassDiagram.impl.ClassImpl#getIsAbstract <em>Is Abstract</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends ClassifierImpl implements ClassDiagram.Class {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassDiagramPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ClassDiagram.Class> getSuper() {
		return (EList<ClassDiagram.Class>)eGet(ClassDiagramPackage.Literals.CLASS__SUPER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Attribute> getAttr() {
		return (EList<Attribute>)eGet(ClassDiagramPackage.Literals.CLASS__ATTR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getIsAbstract() {
		return (Boolean)eGet(ClassDiagramPackage.Literals.CLASS__IS_ABSTRACT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAbstract(Boolean newIsAbstract) {
		eSet(ClassDiagramPackage.Literals.CLASS__IS_ABSTRACT, newIsAbstract);
	}

} //ClassImpl
