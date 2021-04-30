package com.spring.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring.test.interceptor.AuthInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private AuthInterceptor authInterceptor;
	
	private String uploadPath = "/resources/**";
	
	private String galleryPath = "file:///C:/simstudy/img/gallery/";
	
	private String reviewPath = "file:///C:/simstudy/img/review/";
	
	public  void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor)
		.excludePathPatterns("/resources/**")
		.excludePathPatterns("/views/user/login")
		.excludePathPatterns("/api/test/**")
		.excludePathPatterns("/views/ajax")
		.addPathPatterns("/views/**");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(uploadPath)
		.addResourceLocations(galleryPath)
		.addResourceLocations(reviewPath);
	}
}
