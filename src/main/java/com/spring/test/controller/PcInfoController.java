package com.spring.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.entity.PcInfo;
import com.spring.test.repository.PcInfoRepository;

@RestController
public class PcInfoController {

	@Autowired
	private PcInfoRepository pcRepo;
	
	@PostMapping("/pc")
	public Integer insert(@RequestBody PcInfo pcInfo) {
		pcRepo.save(pcInfo);
		return pcInfo.getPcSeatNum();
	}
}
