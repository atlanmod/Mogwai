/**
 */
package fr.inria.atlanmod.mogwai.applications.panama.panamaRelational;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaRelationalPackage
 * @generated
 */
public interface PanamaRelationalFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PanamaRelationalFactory eINSTANCE = fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.impl.PanamaRelationalFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Panama Officers</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Panama Officers</em>'.
	 * @generated
	 */
	PanamaOfficers createPanamaOfficers();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PanamaRelationalPackage getPanamaRelationalPackage();

} //PanamaRelationalFactory
