package com.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class TxAdvice {
	public void startTx() {
		System.out.println("Start Transaction......");
	}
	public Object aroundTx(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		System.out.println("arountTx start......");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		result = pjp.proceed();
		stopWatch.stop();
		System.out.println("Process Time:"
		              +stopWatch.getTotalTimeMillis());
		System.out.println("aroundTx end......"+result);
		return result;
	}
}







