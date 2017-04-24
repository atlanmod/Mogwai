/**
 */
package org.eclipse.gmt.modisco.java;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gmt.modisco.java.PackageAccess#getPackage <em>Package</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.PackageAccess#getQualifier <em>Qualifier</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gmt.modisco.java.JavaPackage#getPackageAccess()
 * @model
 * @generated
 */
public interface PackageAccess extends NamespaceAccess {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmt.modisco.java.Package#getUsagesInPackageAccess <em>Usages In Package Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' reference.
	 * @see #setPackage(org.eclipse.gmt.modisco.java.Package)
	 * @see org.eclipse.gmt.modisco.java.JavaPackage#getPackageAccess_Package()
	 * @see org.eclipse.gmt.modisco.java.Package#getUsagesInPackageAccess
	 * @model opposite="usagesInPackageAccess" required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.gmt.modisco.java.Package getPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.modisco.java.PackageAccess#getPackage <em>Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(org.eclipse.gmt.modisco.java.Package value);

	/**
	 * Returns the value of the '<em><b>Qualifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifier</em>' containment reference.
	 * @see #setQualifier(PackageAccess)
	 * @see org.eclipse.gmt.modisco.java.JavaPackage#getPackageAccess_Qualifier()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	PackageAccess getQualifier();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.modisco.java.PackageAccess#getQualifier <em>Qualifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualifier</em>' containment reference.
	 * @see #getQualifier()
	 * @generated
	 */
	void setQualifier(PackageAccess value);

} // PackageAccess
