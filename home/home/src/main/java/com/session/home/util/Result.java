package com.session.home.util;

public class Result {
    private boolean error = false;
	private String message;
	private Object data;
	
		
	public boolean hasError() {
		return this.error;
	}
	
	
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
