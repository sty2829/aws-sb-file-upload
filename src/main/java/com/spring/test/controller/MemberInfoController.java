package com.spring.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.entity.MemberInfo;
import com.spring.test.repository.MemberInfoRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MemberInfoController {

	@Autowired
	private MemberInfoRepository miRepo;
	
	@PostMapping("/member-info")
	public Long insert(MemberInfo mi) {
		miRepo.save(mi);
		log.info("mi=>{}", mi);
		return mi.getMiNum();
	}
	
	@GetMapping("/member-infos")
	public List<MemberInfo> getMemberInfo(){
		return miRepo.findAll();
	}

}
