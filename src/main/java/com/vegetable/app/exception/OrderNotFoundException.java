package com.vegetable.app.exception;

public class OrderNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(String s) {
		super(s);
	}

	OrderNotFoundException() {
	}
}
