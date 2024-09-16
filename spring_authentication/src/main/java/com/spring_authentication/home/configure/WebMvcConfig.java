package com.spring_authentication.home.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.core.env.Environment;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  // final Environment environment;

  // public WebMvcConfig(Environment environment) {
  //   this.environment = environment;
  // }

  // @Override
	// public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	// 	String location = environment.getProperty("app.file.storage.mapping");
	// 	registry.addResourceHandler("/images/**").addResourceLocations(location);
	// }
  
}
