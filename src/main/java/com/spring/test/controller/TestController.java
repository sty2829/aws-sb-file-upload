package com.spring.test.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/api/test")
	public int test() throws InterruptedException {
		Random r = new Random();
		int time = (r.nextInt(3)+1) * 1000;
		Thread.sleep(time);
		return time;
	}
}
