package com.ebp.exception;

public class OrdersException extends Exception{

	private static final long serialVersionUID = 2208998856762853469L;

	public OrdersException() {
		super();
	}

	public OrdersException(String message) {
		super(message);
	}

	public OrdersException(Throwable cause) {
		super(cause);
	}

	
}
