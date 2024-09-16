package com.session.home.util.enums;

public enum SessionKey {
	
	LOGIN_SESSION_NAME("loginVo"),
	LOGIN_SESSION_MKT_NAME("loginVoMKT"),
	LOGIN_SESSION_MKT_ADMIN_NAME("loginVoMKTAdmin");
	
	public final String value;
	private SessionKey(String value) {
        this.value = value;
    }

}