package fr.inria.atlanmod.mogwai.core;

import java.text.MessageFormat;

public class MogwaiException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MogwaiException(String message, Object... args) {
		super(MessageFormat.format(message, args));
	}
	
}
