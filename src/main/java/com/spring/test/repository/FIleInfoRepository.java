package com.spring.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.test.entity.FileInfo;

public interface FIleInfoRepository extends JpaRepository<FileInfo, Integer> {

}
