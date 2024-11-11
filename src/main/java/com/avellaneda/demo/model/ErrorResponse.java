package com.avellaneda.demo.model;

import lombok.Data;

@Data
public class ErrorResponse {

	private int code;
	private String message;
	private boolean Error;
	
	public ErrorResponse(int code, String message, boolean error) {
		super();
		this.code = code;
		this.message = message;
		Error = error;
	}
	
	
	
}
