package com.spring.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.test.entity.PcInfo;

public interface PcInfoRepository extends JpaRepository<PcInfo, Integer> {

}
