package fr.inria.atlanmod.mogwai.core;

public class MogwaiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MogwaiException() {
		
	}
	
	public MogwaiException(String message) {
		super(message);
	}
	
}
