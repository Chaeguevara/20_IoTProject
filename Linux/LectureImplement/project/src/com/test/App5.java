package com.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.ResBookVO;
import com.vo.UseSeatVO;

public class App5 {

	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started .......");
		// IoC
		
		Biz<Integer,UseSeatVO> biz = 
				(Biz)factory.getBean("useseatbiz");
//		
		
		UseSeatVO s = new UseSeatVO("id001", "003");
		try {
			biz.register(s);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			System.out.println(biz.get());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			System.out.println(biz.get("1"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			biz.remove("1");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	
		
		factory.close();
		System.out.println("Spring End .......");
		System.out.println("App End .......");

	}

}


