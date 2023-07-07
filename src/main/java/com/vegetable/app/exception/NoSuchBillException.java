package com.vegetable.app.exception;

public class NoSuchBillException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchBillException(String message) {
		super(message);
	}

	public NoSuchBillException() {

	}

}
