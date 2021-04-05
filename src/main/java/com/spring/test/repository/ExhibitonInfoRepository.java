package com.spring.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.test.entity.ExhibitonInfo;

public interface ExhibitonInfoRepository extends JpaRepository<ExhibitonInfo, Integer> {

}
