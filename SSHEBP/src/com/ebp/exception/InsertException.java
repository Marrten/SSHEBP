package com.ebp.exception;

public class InsertException extends Exception {

	private static final long serialVersionUID = 1L;

	public InsertException() {
		super();
	}

	public InsertException(String message) {
		super(message);
	}

	public InsertException(Throwable cause) {
		super(cause);
	}
	
}
