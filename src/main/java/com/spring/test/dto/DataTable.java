package com.spring.test.dto;

import java.util.List;

import lombok.Data;

@Data
public class DataTable<T> {

	private List<T> data;
	private Integer draw;
	private Long recordsTotal;
	private Long recordsFilterd;
}
