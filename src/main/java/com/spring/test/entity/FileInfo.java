package com.spring.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Entity
@Table(name = "file_info")
public class FileInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fi_num")
	private Integer fiNum;
	
	@Column(name = "fi_name")
	private String fiName;
	
	@Column(name = "fi_path")
	private String fiPath;
	
	@Transient
	private MultipartFile fiFile;

}
