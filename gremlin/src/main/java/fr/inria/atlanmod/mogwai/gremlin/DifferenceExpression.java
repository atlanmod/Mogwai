/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Difference Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getDifferenceExpression()
 * @model
 * @generated
 */
public interface DifferenceExpression extends BinaryExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nres.append(getLeft().toString()).append(\" != \").append(getRight().toString());\nreturn res.toString();'"
	 * @generated
	 */
	String toString();

} // DifferenceExpression
