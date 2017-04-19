package fr.inria.atlanmod.mogwai.transformation;

import java.util.logging.Level;

import org.eclipse.m2m.atl.common.ATLLogger;

/**
 * An ATL implementation of {@link Transformation}.
 * 
 * @author Gwendal DANIEL
 *
 */
public class ATLTransformation implements Transformation {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDebug(boolean enableDebug) {
		if (enableDebug) {
			ATLLogger.getLogger().setLevel(Level.ALL);
		} else {
			ATLLogger.getLogger().setLevel(Level.OFF);
		}
	}

}
