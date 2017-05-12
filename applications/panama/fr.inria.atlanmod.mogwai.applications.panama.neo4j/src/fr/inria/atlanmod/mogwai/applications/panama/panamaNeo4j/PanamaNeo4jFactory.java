/**
 */
package fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.PanamaNeo4jPackage
 * @generated
 */
public interface PanamaNeo4jFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PanamaNeo4jFactory eINSTANCE = fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.impl.PanamaNeo4jFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Officer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Officer</em>'.
	 * @generated
	 */
	Officer createOfficer();

	/**
	 * Returns a new object of class '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity</em>'.
	 * @generated
	 */
	Entity createEntity();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PanamaNeo4jPackage getPanamaNeo4jPackage();

} //PanamaNeo4jFactory
