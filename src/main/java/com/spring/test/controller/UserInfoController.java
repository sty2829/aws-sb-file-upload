package com.spring.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.test.entity.UserInfo;
import com.spring.test.repository.UserInfoRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserInfoController {

	@Autowired
	private UserInfoRepository uiRepo;
	
	@PostMapping("/user")
	public @ResponseBody Integer insert(@RequestBody UserInfo user) {
		log.info("user=>{}", user);
		uiRepo.save(user);
		return user.getUserNum();
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
