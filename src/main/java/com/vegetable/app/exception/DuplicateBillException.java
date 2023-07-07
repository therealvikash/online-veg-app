package com.vegetable.app.exception;

public class DuplicateBillException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateBillException(String message) {
		super(message);
	}

	public DuplicateBillException() {

	}

}
