package com.test;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.ShopVO;
import com.vo.UserVO;

public class App3 {

	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started .......");
		// IoC
		
		Biz<Integer,ShopVO> biz = 
				(Biz)factory.getBean("sbiz");
		
		ShopVO s = 
		new ShopVO("¹ÙÁö", 10000,"pants.jpg");
		try {
			biz.register(s);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
//		ContentsVO c = 
//		new ContentsVO(99, "tit444","con4444");
//		try {
//			biz.modify(c);
//			System.out.println("OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		ShopVO content = null;
		try {
			content = biz.get(100);
			System.out.println(content);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		
//		
		ArrayList<ShopVO> list = null;
		try {
			list = biz.get();
			for(ShopVO co:list) {
				System.out.println(co);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
		
		
		factory.close();
		System.out.println("Spring End .......");
		System.out.println("App End .......");

	}

}


