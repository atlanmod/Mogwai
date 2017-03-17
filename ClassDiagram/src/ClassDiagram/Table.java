/**
 */
package ClassDiagram;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ClassDiagram.Table#getCol <em>Col</em>}</li>
 *   <li>{@link ClassDiagram.Table#getKey <em>Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see ClassDiagram.ClassDiagramPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends Named {
	/**
	 * Returns the value of the '<em><b>Col</b></em>' containment reference list.
	 * The list contents are of type {@link ClassDiagram.Column}.
	 * It is bidirectional and its opposite is '{@link ClassDiagram.Column#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Col</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Col</em>' containment reference list.
	 * @see ClassDiagram.ClassDiagramPackage#getTable_Col()
	 * @see ClassDiagram.Column#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Column> getCol();

	/**
	 * Returns the value of the '<em><b>Key</b></em>' reference list.
	 * The list contents are of type {@link ClassDiagram.Column}.
	 * It is bidirectional and its opposite is '{@link ClassDiagram.Column#getKeyOf <em>Key Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' reference list.
	 * @see ClassDiagram.ClassDiagramPackage#getTable_Key()
	 * @see ClassDiagram.Column#getKeyOf
	 * @model opposite="keyOf" ordered="false"
	 * @generated
	 */
	EList<Column> getKey();

} // Table
