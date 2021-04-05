package com.spring.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.test.entity.MemberInfo;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {

}
