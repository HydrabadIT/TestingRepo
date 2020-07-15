package com.nt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MathAdvice {

	@Pointcut("execution(* com.nt.service.MathCalculation.*(..))")
	public void myPointCut() {
	}

	@Around(value="myPointCut()")
	public Object aroundAdvice(ProceedingJoinPoint jp)throws Throwable{
		System.out.println("EnerInto"+jp.getSignature());
		Object res=jp.proceed();
		System.out.println("leaving From"+jp.getSignature());
		return res;
	}


	@AfterReturning(value="myPointCut()",returning ="result")
	public void after(JoinPoint jp,int result) {
		if(result<=0) {
			throw new IllegalArgumentException("Invalid Arguments");
		}
	}

	@Before(value="myPointCut()")	
	public void befor(JoinPoint jp) {
		Object[] args=jp.getArgs();
		if((Integer)args[0]<=0&&(Integer)args[1]<=0)
			throw new IllegalArgumentException("Invalid Argument Exception");
	}

	@AfterThrowing(value="myPointCut()",throwing = "e")
	public void throwResult(JoinPoint jp,Exception e) {
		System.out.println("Exception raised in methode"+jp.getSignature()+"with Argumnet"+jp.getArgs());
	}



}


