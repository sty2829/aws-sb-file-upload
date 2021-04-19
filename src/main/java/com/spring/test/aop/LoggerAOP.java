package com.spring.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggerAOP {
	
	//@Before("execution(* com.spring.test.controller.*Controller.*(..))")
	//public void before(JoinPoint jp) {
		//log.info("2.{} 실행전입니다.", jp.getSignature().getName());
	//}

	@Around("execution(* com.spring.test.controller.*Controller.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("{} 감싸구 실행전", pjp.getSignature().getName());
		Object returnObj = pjp.proceed();
		log.info("{} 감싸구 실행후", pjp.getSignature().getName());
		sw.stop();
		log.info("수행시간 => {} 초", sw.getTotalTimeSeconds());
		return returnObj;
	}
	
	//@After("execution(* com.spring.test.controller.*Controller.*(..))")
	//public void after(JoinPoint jp) {
		//log.info("4.{} 실행후입니다.", jp.getSignature().getName());
	//}
}
