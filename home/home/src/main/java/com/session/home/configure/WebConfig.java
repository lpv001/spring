package com.session.home.configure;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.session.home.interceptor.AuthenticatedInterceptor;

@Configuration
public class WebConfig implements  WebMvcConfigurer {

    @Autowired
	private AuthenticatedInterceptor authenticatedInterceptor;

    @Override
	public void addInterceptors(InterceptorRegistry registry) {
		this.addAuthenticatedInterceptors(registry);
	}

    private void addAuthenticatedInterceptors(InterceptorRegistry registry) {
		// registry.addInterceptor(authenticatedInterceptor).addPathPatterns("/admin*", "/admin/**", "/user*", "/user/**",
		// 		"/addUser*", "/updateUser*", "/deleteUser*").excludePathPatterns("/login", "/register");
        registry.addInterceptor(authenticatedInterceptor).addPathPatterns("/").excludePathPatterns("/login", "/register");
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}
}
