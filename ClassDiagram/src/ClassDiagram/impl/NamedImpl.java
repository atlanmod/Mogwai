/**
 */
package ClassDiagram.impl;

import org.eclipse.emf.ecore.EClass;

import ClassDiagram.ClassDiagramPackage;
import ClassDiagram.Named;
import fr.inria.atlanmod.neoemf.core.DefaultPersistentEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ClassDiagram.impl.NamedImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NamedImpl extends DefaultPersistentEObject implements Named {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassDiagramPackage.Literals.NAMED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(ClassDiagramPackage.Literals.NAMED__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(ClassDiagramPackage.Literals.NAMED__NAME, newName);
	}

} //NamedImpl
