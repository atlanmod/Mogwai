package fr.inria.atlanmod.mogwai.core.exception;

import java.text.MessageFormat;

/**
 * The base exception thrown when an error occurs during a query computation.
 * <p>
 * This class is also used to wrap internal exceptions and provide contextual
 * information for debugging purposes.
 * 
 * @author Gwendal DANIEL
 *
 */
public class MogwaiCoreException extends RuntimeException {

	/**
	 * A unique serial version identifier.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new {@link MogwaiCoreException} with the provided
	 * {@code message} and {@code args}.
	 * 
	 * @param message
	 *            the exception message
	 * @param args
	 *            the arguments to insert in the message
	 */
	public MogwaiCoreException(String message, Object... args) {
		super(MessageFormat.format(message, args));
	}

}
