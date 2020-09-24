package com.test;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.UserVO;

public class App2 {

	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started .......");
		// IoC
		
		Biz<String,UserVO> biz = 
				(Biz)factory.getBean("ubiz");
		
//		UserVO u = 
//		new UserVO("test", "pwd","테스트용계정",0);
//		try {
//			biz.register(u);
//			System.out.println("OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		UserVO u1 = 
//		new UserVO("admin", "admin","관리자",1);
//		try {
//			biz.register(u1);
//			System.out.println("OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	
//		UserVO c = 
//		new UserVO("123", "234", "modifyTest", 0);
//		try {
//			biz.modify(c);
//			System.out.println("OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		UserVO content = null;
//		try {
//			content = biz.get("test");
//			System.out.println(content);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
		ArrayList<UserVO> list = null;
		try {
			list = biz.get();
			for(UserVO co:list) {
				System.out.println(co);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		
		
		
		factory.close();
		System.out.println("Spring End .......");
		System.out.println("App End .......");

	}

}


