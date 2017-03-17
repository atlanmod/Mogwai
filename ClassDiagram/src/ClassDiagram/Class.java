/**
 */
package ClassDiagram;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ClassDiagram.Class#getSuper <em>Super</em>}</li>
 *   <li>{@link ClassDiagram.Class#getAttr <em>Attr</em>}</li>
 *   <li>{@link ClassDiagram.Class#getIsAbstract <em>Is Abstract</em>}</li>
 * </ul>
 * </p>
 *
 * @see ClassDiagram.ClassDiagramPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends Classifier {
	/**
	 * Returns the value of the '<em><b>Super</b></em>' reference list.
	 * The list contents are of type {@link ClassDiagram.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super</em>' reference list.
	 * @see ClassDiagram.ClassDiagramPackage#getClass_Super()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Class> getSuper();

	/**
	 * Returns the value of the '<em><b>Attr</b></em>' containment reference list.
	 * The list contents are of type {@link ClassDiagram.Attribute}.
	 * It is bidirectional and its opposite is '{@link ClassDiagram.Attribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attr</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attr</em>' containment reference list.
	 * @see ClassDiagram.ClassDiagramPackage#getClass_Attr()
	 * @see ClassDiagram.Attribute#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Attribute> getAttr();

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(Boolean)
	 * @see ClassDiagram.ClassDiagramPackage#getClass_IsAbstract()
	 * @model unique="false" dataType="PrimitiveTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	Boolean getIsAbstract();

	/**
	 * Sets the value of the '{@link ClassDiagram.Class#getIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #getIsAbstract()
	 * @generated
	 */
	void setIsAbstract(Boolean value);

} // Class
