package com.vegetable.app.exception;

public class NoSuchCustomerException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	NoSuchCustomerException() {

	}

	public NoSuchCustomerException(String s) {
		super(s);
	}

}
