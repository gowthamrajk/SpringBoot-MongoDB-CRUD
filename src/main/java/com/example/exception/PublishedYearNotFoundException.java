package com.example.exception;

public class PublishedYearNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PublishedYearNotFoundException(String message) {
		
		super(message);
	}
}
