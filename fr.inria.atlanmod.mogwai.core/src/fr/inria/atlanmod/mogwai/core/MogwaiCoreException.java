package fr.inria.atlanmod.mogwai.core;

import java.text.MessageFormat;

public class MogwaiCoreException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MogwaiCoreException(String message, Object... args) {
		super(MessageFormat.format(message, args));
	}
	
}
