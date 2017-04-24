/**
 */
package org.eclipse.gmt.modisco.java;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Archive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gmt.modisco.java.Archive#getOriginalFilePath <em>Original File Path</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.Archive#getClassFiles <em>Class Files</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.Archive#getManifest <em>Manifest</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gmt.modisco.java.JavaPackage#getArchive()
 * @model
 * @generated
 */
public interface Archive extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Original File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original File Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original File Path</em>' attribute.
	 * @see #setOriginalFilePath(String)
	 * @see org.eclipse.gmt.modisco.java.JavaPackage#getArchive_OriginalFilePath()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getOriginalFilePath();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.modisco.java.Archive#getOriginalFilePath <em>Original File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original File Path</em>' attribute.
	 * @see #getOriginalFilePath()
	 * @generated
	 */
	void setOriginalFilePath(String value);

	/**
	 * Returns the value of the '<em><b>Class Files</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmt.modisco.java.ClassFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Files</em>' containment reference list.
	 * @see org.eclipse.gmt.modisco.java.JavaPackage#getArchive_ClassFiles()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ClassFile> getClassFiles();

	/**
	 * Returns the value of the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manifest</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manifest</em>' containment reference.
	 * @see #setManifest(Manifest)
	 * @see org.eclipse.gmt.modisco.java.JavaPackage#getArchive_Manifest()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Manifest getManifest();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.modisco.java.Archive#getManifest <em>Manifest</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manifest</em>' containment reference.
	 * @see #getManifest()
	 * @generated
	 */
	void setManifest(Manifest value);

} // Archive
