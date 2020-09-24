package com.test;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.ResBookVO;

public class App4 {

	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started .......");
		// IoC
		
		Biz<String,ResBookVO> biz = 
				(Biz)factory.getBean("resbookbiz");
		
//		ArrayList<ResBookVO> resbooklist = null;
//		try {
//			resbooklist = biz.get();
//			for (ResBookVO r: resbooklist) {
//				r.setState("f");
//				biz.modify(r);
//			}
//			
//			System.out.println("OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
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
		
		ResBookVO s = new ResBookVO("id001", "id0005", "t");
		
		try {
			biz.register(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		factory.close();
		System.out.println("Spring End .......");
		System.out.println("App End .......");

	}

}


