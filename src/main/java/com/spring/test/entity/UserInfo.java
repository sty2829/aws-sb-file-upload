package com.spring.test.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Entity
@Table(name="user_info")
@Data
@DynamicInsert
@DynamicUpdate
public class UserInfo {
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="user_num")
   private Integer userNum;
   @Column(name="user_id")
   private String userID;
   @Column(name="user_pwd")
   private String userPwd;
   @Column(name="user_name")
   private String userName;   
   @Column(name="user_gender")
   private String userGender;
   @Column(name="user_date_of_birth")
   private String userDateOfBirth;   
   @Column(name="user_addr1")
   private String userAddr1;   
   @Column(name="user_addr2")
   private String userAddr2;   
   @Column(name="user_phone1")
   private String userPhone1;
   @Column(name="user_phone2")
   private String userPhone2;
   @Column(name="user_phone3")
   private String userPhone3;
   @Column(name="user_email")
   private String userEmail;
   @Column(name="user_mileage")
   private Integer userMileage;
   
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   @Column(name="reg_date" ,insertable = false,updatable = false)
   private Date regDate;
   @Column(name="favorite_game")
   private String favoriteGame;
   @Column(name="rest_of_time")
   private Time restOfTime;
   @Column(name="user_profile")
   private String userProfile;
   @Column(name="profile_path")
   private String profilePath;
   @Column(name="action",insertable = false)
   private String action;
   
   @Transient
   private MultipartFile userFile;

   
}
