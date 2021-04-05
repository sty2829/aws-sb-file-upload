package com.spring.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.test.entity.TrainerInfo;

public interface TrainerInfoRepository extends JpaRepository<TrainerInfo, Long> {

}
