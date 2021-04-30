package com.spring.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class URIController {
	

	@GetMapping("/")
	public String hello() {
		return "views/index";
	}
	
	@GetMapping("/views/**")
	public void goView() {
	}
}
