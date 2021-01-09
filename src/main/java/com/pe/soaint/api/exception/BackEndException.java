package com.pe.soaint.api.exception;

public class BackEndException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BackEndException(String httpStatus, String message, String code, String BackendMessage) {
		super(message);
	}
	
	
}
