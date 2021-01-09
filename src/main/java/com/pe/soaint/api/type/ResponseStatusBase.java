package com.pe.soaint.api.type;

import org.springframework.http.HttpStatus;

public class ResponseStatusBase {

	private HttpStatus httpStatus;
	private String message;
	private String code;
	private String backendMessage;
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBackendMessage() {
		return backendMessage;
	}
	public void setBackendMessage(String backendMessage) {
		this.backendMessage = backendMessage;
	}
	
}
