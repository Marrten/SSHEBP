package com.ebp.exception;
/**
 * 用户注册异常  
 * @author李强
 */
public class RegisterException extends Exception{

	private static final long serialVersionUID = 1L;

	public RegisterException() {
		super();
	}

	public RegisterException(String message) {
		super(message);
	}

	public RegisterException(Throwable cause) {
		super(cause);
	}
	
	
}
