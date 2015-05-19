/**
 */
package fr.inria.atlanmod.mogwai.gremlin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinPackage#getNotExpression()
 * @model
 * @generated
 */
public interface NotExpression extends UnaryExpression {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuffer res = new StringBuffer();\nres.append(\" !( \").append(getExp().toString()).append(\")\");\nreturn res.toString();'"
     * @generated
     */
	String toString();

} // NotExpression
