package com.ebp.exception;

public class BookUpdateExecption extends Exception{

	private static final long serialVersionUID = 1L;

	public BookUpdateExecption() {
		super();
	}

	public BookUpdateExecption(String message) {
		super(message);
	}

	public BookUpdateExecption(Throwable cause) {
		super(cause);
	}
	

}
