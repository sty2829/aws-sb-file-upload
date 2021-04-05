package com.spring.test.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name="trainer_info")
@Data
public class TrainerInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ti_num")
	private Long tiNum;
	
	@Column(name="ti_name")
	private String tiName;
	
	@Column(name="ti_gender")
	private String tiGender;
	
	@Column(name="ti_id")
	private String tiId;
	
	@Column(name="ti_password")
	private String tiPassword;
	
	@Column(name="ti_email")
	private String tiEmail;
	
	@Column(name="ti_img")
	private String tiImg;
	
	@Transient
	private MultipartFile tiFile;
	
	@Column(name="ti_phone")
	private String tiPhone;
	
	@Column(name="ti_credat")
	private Date tiCredat;
	
	@OneToMany(mappedBy = "trainerInfo")
	@JsonManagedReference
	private List<MemberInfo> miList;
	
}
