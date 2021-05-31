package com.hcl.exception;

public class RestaurantException extends Exception {

	
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public RestaurantException(String msg){
		this.msg=msg;
	}
	
	public String getMessage() {
		return msg;
	}
}
