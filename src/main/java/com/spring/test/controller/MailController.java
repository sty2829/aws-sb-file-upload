package com.spring.test.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.service.MailService;
import com.spring.test.util.CodeGenerator;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MailController {

	@Autowired
	private MailService mailService;
	
	@PostMapping("/mail")
	public Integer sendMail(@RequestBody SimpleMailMessage smm) {
		mailService.mailSend(smm);
		return 1;
	}
	
	public static void main(String[] args) {
		log.debug("랜덤코드 => {}", CodeGenerator.getRandomCode());
	}
}
