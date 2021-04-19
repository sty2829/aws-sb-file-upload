package com.spring.test;

import java.util.Random;

public class TestSleep {

	public static void main(String[] args) {
		System.out.println("시작!!");
		Random r = new Random();
		int sleepTime = (r.nextInt(3)+1) * 1000;
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println((sleepTime/1000) + "초 후 종료!!");
	}
}
