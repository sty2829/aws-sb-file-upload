package com.spring.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	private static final String FROM_ADDRESS = "sim2829test@gmail.com";
	
	public void mailSend(SimpleMailMessage message) {
		message.setFrom(MailService.FROM_ADDRESS);
		log.info("message => {}", message);
		mailSender.send(message);
	}
	
}
