package com.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.SeatVO;
import com.vo.UseSeatVO;

public class App6 {

	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started .......");
		// IoC
		
		Biz<String,SeatVO> biz = 
				(Biz)factory.getBean("seatbiz");
		
		
		SeatVO s = new SeatVO("007", 0);
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


