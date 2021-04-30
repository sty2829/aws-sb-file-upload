package com.spring.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.test.dto.UserSession;
import com.spring.test.entity.UserInfo;
import com.spring.test.repository.UserInfoRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserInfoController {

	@Autowired
	private UserInfoRepository uiRepo;
	
	@PostMapping("/user")
	public @ResponseBody Integer insert(UserSession userSession , @RequestBody UserInfo userInfo) {
		log.info("userSession=>{}", userSession);
		log.info("userInfo => {}", userInfo);
		return 1;
	}
	
	@PostMapping("/user/{uiNum}")
	public @ResponseBody Integer insertS(@PathVariable Integer uiNum , @RequestBody UserInfo userInfo) {
		log.info("uiNum=>{}", uiNum);
		log.info("userInfo => {}", userInfo);
		return 1;
	}
	
	@GetMapping("/user")
	public @ResponseBody Integer session(HttpServletRequest req) {
		log.info("1");
		UserInfo userInfo = uiRepo.findById(2).get();
		log.info("userInfo=>{}", userInfo);
		HttpSession session = req.getSession();
		session.setAttribute("userInfo", userInfo);
		return 1;
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		UserInfo ui = new UserInfo();
		ui.setUserID("test");
		ui.setUserPwd("test");
		ui.setUserName("hong");
		ui.setUserGender("남성");
		ui.setUserDateOfBirth("2010-10-11");
		ui.setUserAddr1("서울시 강서구 동촌1동");
		ui.setUserAddr2("라인아파트 101동");
		ui.setUserPhone1("010");
		ui.setUserPhone2("6208");
		ui.setUserPhone3("0018");
		String json = om.writeValueAsString(ui);
		log.info(json);
	}
	
}
