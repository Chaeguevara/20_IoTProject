package com.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;

public class App {

	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("com.xml");
		System.out.println("Spring Started .......");

		// IoC
		Biz biz = (Biz)factory.getBean("ubiz");
		biz.register();

		
		factory.close();
		System.out.println("Spring End .......");
		System.out.println("App End .......");

	}

}
