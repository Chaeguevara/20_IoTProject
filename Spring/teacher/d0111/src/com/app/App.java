package com.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.biz.Biz;

public class App {

	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("com.xml");
		System.out.println("Spring Started .......");

		Biz biz = (Biz)factory.getBean("ubiz");
		biz.register();
		biz.modify();
		
		factory.close();
		System.out.println("Spring End .......");
		System.out.println("App End .......");

	}

}
