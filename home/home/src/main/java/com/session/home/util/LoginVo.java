package com.session.home.util;

import com.session.home.model.User;

public class LoginVo extends User{
	
	private boolean resultSuccess = true;
	private String msg;
	
	
	public LoginVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LoginVo(boolean resultSuccess,String msg) {
		this.resultSuccess = resultSuccess;
		this.msg = msg;
	}
	
	public boolean getResultSuccess() {
		return resultSuccess;
	}
	public void setResultSuccess(boolean resultSuccess) {
		this.resultSuccess = resultSuccess;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
