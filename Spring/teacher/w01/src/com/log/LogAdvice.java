package com.log;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object [] args = jp.getArgs();
		System.out.println("[LOG]:"+method+" "+args[0].toString());
	}
	public void printLog2(JoinPoint jp,Object returnObj) {
		String method = jp.getSignature().getName();
		System.out.println("[After-Returning LOG]: "+method+" "+returnObj);
	}
}






