package com.spring.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.test.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
