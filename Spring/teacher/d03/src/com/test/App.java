package com.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.ContentsVO;

public class App {

	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started .......");
		// IoC
		
		Biz<Integer,ContentsVO> biz = 
				(Biz)factory.getBean("cbiz");
		
		ArrayList<ContentsVO> list = null;
		HashMap<String, Integer> smap = new HashMap<>();
		smap.put("start", 20);
		smap.put("end", 40);
		try {
			list = biz.search(smap);
			for(ContentsVO cv:list) {
				System.out.println(cv);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		
//		ContentsVO content = null;
//		try {
//			content = biz.get(100);
//			System.out.println(content);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
//		ArrayList<ContentsVO> list = null;
//		try {
//			list = biz.get();
//			for(ContentsVO co:list) {
//				System.out.println(co);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		factory.close();
		System.out.println("Spring End .......");
		System.out.println("App End .......");

	}

}


