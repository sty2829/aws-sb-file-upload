package com.spring.test.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@Table(name="pc_current_status")
@Data
@DynamicInsert
@DynamicUpdate
public class PcCurrentStatus {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="pc_status_num")
		private Integer pcStatusNum;
		
		@Column(name="res_num")
		private Integer resNum;

		@Column(name="pc_start_time")
		private Time pcStartTime;
		
		@Column(name="pc_end_time")
		private Time pcEndTime;
		
		@Column(name="pc_seat_result")
		private Integer pcSeatResult;
		
		@ManyToOne
		@JoinColumn(name = "user_num")
		private UserInfo userInfo;
		
		@ManyToOne
		@JoinColumn(name = "pc_seat_num")
		private PcInfo pcInfo;
		
		
	}
