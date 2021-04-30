package com.spring.test.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.spring.test.dto.UserSession;
import com.spring.test.entity.UserInfo;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggerAOP {
	
	//@Before("execution(* com.spring.test.controller.*Controller.*(..))")
	//public void before(JoinPoint jp) {
		//log.info("2.{} 실행전입니다.", jp.getSignature().getName());
	//}

	//@Around("execution(* com.spring.test.controller.*Controller.*(..))")
	//public Object around(ProceedingJoinPoint pjp) throws Throwable {
		///StopWatch sw = new StopWatch();
		//sw.start();
		//log.info("{} 감싸구 실행전", pjp.getSignature().getName());
		//Object returnObj = pjp.proceed();
		//log.info("{} 감싸구 실행후", pjp.getSignature().getName());
		//sw.stop();
		//log.info("수행시간 => {} 초", sw.getTotalTimeSeconds());
		//return returnObj;
	//}
	
	@Around("execution(* com.spring.test.controller.*Controller.*(com.spring.test.dto.UserSession,..))")
	public Object getUser(ProceedingJoinPoint pjp) throws Throwable {
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
		UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
		Integer userNum = userInfo.getUserNum();
		UserSession userSession = new UserSession();
		userSession.setUiNum(userNum);
		String parameterName = "";
		
		Object[] args = pjp.getArgs();
	    MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        
        for (int i = 0; i < method.getParameters().length; i++) {
            parameterName = method.getParameters()[i].getName();
            log.info("parameterName =>{}", parameterName);
            if (parameterName.equals("userSession")) {
            	
            	args[i] = userSession;
            }
        }
		return pjp.proceed(args);
	}
	
	
	//@After("execution(* com.spring.test.controller.*Controller.*(..))")
	//public void after(JoinPoint jp) {
		//log.info("4.{} 실행후입니다.", jp.getSignature().getName());
	//}
}
