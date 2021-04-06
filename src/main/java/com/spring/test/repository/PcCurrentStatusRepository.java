package com.spring.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.test.entity.PcCurrentStatus;

public interface PcCurrentStatusRepository extends JpaRepository<PcCurrentStatus, Integer> {

	
	public List<PcCurrentStatus> findAllByUserInfoUserNumOrderByPcStatusNumDesc(Integer userNum);
	
	public List<PcCurrentStatus> findAllByPcInfoPcSeatNumOrderByPcStatusNumDesc(Integer pcSeatNum);
}
