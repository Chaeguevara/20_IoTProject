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
//		new UserVO("id73", "pwd73","ÀÓ¸»¼÷");
//		try {
//			biz.modify(u);
//			System.out.println("OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	
//		ContentsVO c = 
//		new ContentsVO(99, "tit444","con4444");
//		try {
//			biz.modify(c);
//			System.out.println("OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		UserVO content = null;
		try {
			content = biz.get("id01");
			System.out.println(content);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		
//		
		ArrayList<UserVO> list = null;
		try {
			list = biz.get();
			for(UserVO co:list) {
				System.out.println(co);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		factory.close();
		System.out.println("Spring End .......");
		System.out.println("App End .......");

	}

}


