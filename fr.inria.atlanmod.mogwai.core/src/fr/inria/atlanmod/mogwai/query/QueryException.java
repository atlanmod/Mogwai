package fr.inria.atlanmod.mogwai.query;

import fr.inria.atlanmod.mogwai.core.exception.MogwaiCoreException;

public class QueryException extends MogwaiCoreException {

	private static final long serialVersionUID = 1L;

	public QueryException(String message) {
		super(message);
	}

}
