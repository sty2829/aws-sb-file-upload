package com.spring.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.test.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

}
