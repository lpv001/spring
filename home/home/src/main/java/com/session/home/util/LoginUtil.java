package com.session.home.util;

import com.session.home.util.enums.SessionKey;

import jakarta.servlet.http.HttpSession;

public class LoginUtil {
    
    public static boolean isLogined(HttpSession session) throws RuntimeException {
		LoginVo loginVO = getLoginVo(session);
		return loginVO == null ? false : true;
	}
	
	
	public static LoginVo getLoginVo(HttpSession session)throws RuntimeException {
		LoginVo loginVO = (LoginVo)session.getAttribute(SessionKey.LOGIN_SESSION_NAME.value);
		return loginVO;
	}
    
}
