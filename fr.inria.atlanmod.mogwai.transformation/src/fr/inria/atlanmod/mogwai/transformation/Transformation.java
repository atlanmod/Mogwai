package fr.inria.atlanmod.mogwai.transformation;

/**
 * An interface representing the underlying transformation used by
 * {@link AbstractATLProcessor}s to create Gremlin scripts from their respective
 * input language.
 * <p>
 * This interface must be implemented by language specific transformations.
 * 
 * @author Gwendal DANIEL
 *
 */
public interface Transformation {

	/**
	 * Sets whether the transformation should print debug information.
	 * 
	 * @param enableDebug
	 *            {@code true} to enable debug information, {@code false}
	 *            otherwise
	 */
	public void setDebug(boolean enableDebug);

}
