package com.spring.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class URIController {
	

	@GetMapping("/")
	public String hello() {
		return "views/index";
	}
	
	@GetMapping("/views/**")
	public String goView(HttpServletRequest request) {
		return "";
	}
}
