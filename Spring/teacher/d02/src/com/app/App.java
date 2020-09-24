package com.app;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Search;
import com.frame.Service;
import com.vo.Item;
import com.vo.User;

public class App {

	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started .......");
		// IoC
		
		Service service = 
				(Service)factory.getBean("userservice");
	
		User user = new User("id58", "pwd58", "name");
		try {
			service.register(user);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		factory.close();
		System.out.println("Spring End .......");
		System.out.println("App End .......");

	}

}


