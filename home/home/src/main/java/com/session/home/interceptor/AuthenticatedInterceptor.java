package com.session.home.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.session.home.util.LoginUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticatedInterceptor implements HandlerInterceptor {
    	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticatedInterceptor.class);

	  
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOGGER.debug("=== Pre Handle method is Calling ===");
		if(!LoginUtil.isLogined(request.getSession())) {
			response.sendRedirect("/login");
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		LOGGER.debug("=== Post Handle method is Calling ===");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

		LOGGER.debug("=== Request and Response is completed ===");
	}
}
