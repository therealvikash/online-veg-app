package com.vegetable.app.exception;

public class VegetableNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	VegetableNotFoundException() {
	}

	public VegetableNotFoundException(String s) {
		super(s);
	}
}
