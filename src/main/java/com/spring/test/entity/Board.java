package com.spring.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "board")
@Data
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bo_num")
	private Integer boNum;
	
	@Column(name = "bo_title")
	private String boTitle;
	
	@Column(name = "bo_content")
	private String boContent;
	
	
}
