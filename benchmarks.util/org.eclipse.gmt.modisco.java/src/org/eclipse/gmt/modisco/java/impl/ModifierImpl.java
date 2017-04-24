/**
 */
package org.eclipse.gmt.modisco.java.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.gmt.modisco.java.BodyDeclaration;
import org.eclipse.gmt.modisco.java.InheritanceKind;
import org.eclipse.gmt.modisco.java.JavaPackage;
import org.eclipse.gmt.modisco.java.Modifier;
import org.eclipse.gmt.modisco.java.SingleVariableDeclaration;
import org.eclipse.gmt.modisco.java.VariableDeclarationExpression;
import org.eclipse.gmt.modisco.java.VariableDeclarationStatement;
import org.eclipse.gmt.modisco.java.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gmt.modisco.java.impl.ModifierImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.impl.ModifierImpl#getInheritance <em>Inheritance</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.impl.ModifierImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.impl.ModifierImpl#isTransient <em>Transient</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.impl.ModifierImpl#isVolatile <em>Volatile</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.impl.ModifierImpl#isNative <em>Native</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.impl.ModifierImpl#isStrictfp <em>Strictfp</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.impl.ModifierImpl#isSynchronized <em>Synchronized</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.impl.ModifierImpl#getBodyDeclaration <em>Body Declaration</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.impl.ModifierImpl#getSingleVariableDeclaration <em>Single Variable Declaration</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.impl.ModifierImpl#getVariableDeclarationStatement <em>Variable Declaration Statement</em>}</li>
 *   <li>{@link org.eclipse.gmt.modisco.java.impl.ModifierImpl#getVariableDeclarationExpression <em>Variable Declaration Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModifierImpl extends ASTNodeImpl implements Modifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaPackage.eINSTANCE.getModifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisibilityKind getVisibility() {
		return (VisibilityKind)eGet(JavaPackage.eINSTANCE.getModifier_Visibility(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(VisibilityKind newVisibility) {
		eSet(JavaPackage.eINSTANCE.getModifier_Visibility(), newVisibility);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InheritanceKind getInheritance() {
		return (InheritanceKind)eGet(JavaPackage.eINSTANCE.getModifier_Inheritance(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritance(InheritanceKind newInheritance) {
		eSet(JavaPackage.eINSTANCE.getModifier_Inheritance(), newInheritance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStatic() {
		return (Boolean)eGet(JavaPackage.eINSTANCE.getModifier_Static(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatic(boolean newStatic) {
		eSet(JavaPackage.eINSTANCE.getModifier_Static(), newStatic);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransient() {
		return (Boolean)eGet(JavaPackage.eINSTANCE.getModifier_Transient(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransient(boolean newTransient) {
		eSet(JavaPackage.eINSTANCE.getModifier_Transient(), newTransient);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVolatile() {
		return (Boolean)eGet(JavaPackage.eINSTANCE.getModifier_Volatile(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVolatile(boolean newVolatile) {
		eSet(JavaPackage.eINSTANCE.getModifier_Volatile(), newVolatile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNative() {
		return (Boolean)eGet(JavaPackage.eINSTANCE.getModifier_Native(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNative(boolean newNative) {
		eSet(JavaPackage.eINSTANCE.getModifier_Native(), newNative);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStrictfp() {
		return (Boolean)eGet(JavaPackage.eINSTANCE.getModifier_Strictfp(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStrictfp(boolean newStrictfp) {
		eSet(JavaPackage.eINSTANCE.getModifier_Strictfp(), newStrictfp);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSynchronized() {
		return (Boolean)eGet(JavaPackage.eINSTANCE.getModifier_Synchronized(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynchronized(boolean newSynchronized) {
		eSet(JavaPackage.eINSTANCE.getModifier_Synchronized(), newSynchronized);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BodyDeclaration getBodyDeclaration() {
		return (BodyDeclaration)eGet(JavaPackage.eINSTANCE.getModifier_BodyDeclaration(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyDeclaration(BodyDeclaration newBodyDeclaration) {
		eSet(JavaPackage.eINSTANCE.getModifier_BodyDeclaration(), newBodyDeclaration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingleVariableDeclaration getSingleVariableDeclaration() {
		return (SingleVariableDeclaration)eGet(JavaPackage.eINSTANCE.getModifier_SingleVariableDeclaration(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleVariableDeclaration(SingleVariableDeclaration newSingleVariableDeclaration) {
		eSet(JavaPackage.eINSTANCE.getModifier_SingleVariableDeclaration(), newSingleVariableDeclaration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclarationStatement getVariableDeclarationStatement() {
		return (VariableDeclarationStatement)eGet(JavaPackage.eINSTANCE.getModifier_VariableDeclarationStatement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableDeclarationStatement(VariableDeclarationStatement newVariableDeclarationStatement) {
		eSet(JavaPackage.eINSTANCE.getModifier_VariableDeclarationStatement(), newVariableDeclarationStatement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclarationExpression getVariableDeclarationExpression() {
		return (VariableDeclarationExpression)eGet(JavaPackage.eINSTANCE.getModifier_VariableDeclarationExpression(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableDeclarationExpression(VariableDeclarationExpression newVariableDeclarationExpression) {
		eSet(JavaPackage.eINSTANCE.getModifier_VariableDeclarationExpression(), newVariableDeclarationExpression);
	}

} //ModifierImpl
