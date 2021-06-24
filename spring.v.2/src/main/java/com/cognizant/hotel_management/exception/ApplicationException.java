package com.cognizant.hotel_management.exception;


public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;
	
	

	
	public ApplicationException() {
		super();
	}

	
	public ApplicationException(final String message) {
		super(message);
		
	}
}
