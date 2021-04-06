package com.spring.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.entity.PcCurrentStatus;
import com.spring.test.repository.PcCurrentStatusRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PcCurrentStatusController {

	
	@Autowired
	private PcCurrentStatusRepository pcStatusRepo;
	
	@PostMapping("/pc-status")
	public Integer insert(@RequestBody PcCurrentStatus pcStatus) {
		log.info("pcStaus => {}", pcStatus);
		pcStatusRepo.save(pcStatus);
		return pcStatus.getPcStatusNum();
	}
	
	@GetMapping("/pc-status/user/{uiNum}")
	public List<PcCurrentStatus> findAllByUiNum(@PathVariable Integer uiNum) {
		
		return pcStatusRepo.findAllByUserInfoUserNumOrderByPcStatusNumDesc(uiNum);
		
	}
	
	@GetMapping("/pc-status/pc/{pcSeatNum}")
	public List<PcCurrentStatus> findAllByPcSeatNum(@PathVariable Integer pcSeatNum) {
		return pcStatusRepo.findAllByPcInfoPcSeatNumOrderByPcStatusNumDesc(pcSeatNum);
		
	}
}
