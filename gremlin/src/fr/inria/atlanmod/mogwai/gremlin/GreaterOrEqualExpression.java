/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Greater Or Equal Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getGreaterOrEqualExpression()
 * @model
 * @generated
 */
public interface GreaterOrEqualExpression extends BinaryExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nres.append(getLeft().toString()).append(\" >= \").append(getRight().toString());\nreturn res.toString();'"
	 * @generated
	 */
	String toString();

} // GreaterOrEqualExpression
