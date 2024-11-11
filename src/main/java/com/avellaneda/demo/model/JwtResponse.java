package com.avellaneda.demo.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final boolean isSuccess;
	
	
	public JwtResponse(String jwttoken , boolean isSuccess) {
		this.jwttoken = jwttoken;
		this.isSuccess = isSuccess;
	}
	
	

	public String getToken() {
		return this.jwttoken;
	}
	
}