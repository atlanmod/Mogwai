package fr.inria.atlanmod.mogwai.query;

import fr.inria.atlanmod.mogwai.core.exception.MogwaiCoreException;

/**
 * A specific {@link MogwaiCoreException} used to wrap query creation and
 * computation errors.
 * 
 * @author Gwendal DANIEL
 *
 */
public class QueryException extends MogwaiCoreException {

	/**
	 * A unique serial version identifier.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new {@link QueryException} from the provided {@code message}
	 * and {@code args}.
	 * 
	 * @param message
	 *            the exception message
	 * @param args
	 *            the arguments to insert in the message
	 */
	public QueryException(String message, Object... args) {
		super(message, args);
	}

}
