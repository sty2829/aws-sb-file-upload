package com.spring.test;

public class Test {

	public static void main(String[] args) {
		
		int page = 5;
		int countPage = 10;
		
		int startPage = ((page - 1) / countPage) * countPage + 1;
		int endPage = startPage + countPage -1;
		
		System.out.println(startPage);
		System.out.println(endPage);
		
	}
}
