package com.vegetable.app.exception;

public class CustomerNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CustomerNotFoundException() {
	}

	public CustomerNotFoundException(String s) {
		super(s);

	}

}
