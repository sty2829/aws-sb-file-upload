package com.spring.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.dto.DataTable;
import com.spring.test.entity.Board;
import com.spring.test.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BoardController {

	@Autowired
	private BoardRepository boardRepository;
	
	@GetMapping("/boards")
	public DataTable<Board> getList(Pageable pageable, DataTable<Board> dt) {
		log.info("pageable=>{}", pageable);
		Page<Board> pb = boardRepository.findAll(pageable);
		dt.setData(pb.getContent());
		dt.setRecordsTotal(pb.getTotalElements());
		dt.setRecordsFilterd(pb.getTotalElements());
		log.info("DataTable=>{}", dt);
		return dt;
	}
	
	
	@GetMapping("/board")
	public Page<Board> getList(Pageable pageable) {
		log.info("pageable=>{}", pageable);
		Page<Board> pb = boardRepository.findAll(pageable);
		log.info("DataTable=>{}", pb);
		return pb;
	}
}