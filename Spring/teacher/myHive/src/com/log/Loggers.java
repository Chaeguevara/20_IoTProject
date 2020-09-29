package com.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import com.biz.Click;

@Service
@Aspect
public class Loggers {
	private Logger work_log = Logger.getLogger("work");
	private Logger user_log = Logger.getLogger("user");
	private Logger data_log = Logger.getLogger("data");
	private Logger book_log = Logger.getLogger("book");

	// before
	@Before("execution(* com.biz.BookBiz.*(..))")
	public void logging1(JoinPoint jp) {
		Object[] args = jp.getArgs();
		Click click = (Click) args[0];
		book_log.debug(jp.getSignature().getName() + "," + click.getId() + "," + click.getItem() + "," + click.getAct()
				+ "," + click.getAge() + "," + click.getGender());

	}

	// before
	@Before("execution(* com.*.MainController.*(..))")
	public void logging2(JoinPoint jp) {
		work_log.debug(jp.getSignature().getName() + "," + "ABC");
	}

}
