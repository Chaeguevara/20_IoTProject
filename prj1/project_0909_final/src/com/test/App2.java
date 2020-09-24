package com.test;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.SeatVO;
import com.vo.UserVO;

public class App2 {

   public static void main(String[] args) {
      System.out.println("App Start .......");
      AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");
      System.out.println("Spring Started .......");
      // IoC

      Biz<String, SeatVO> biz = (Biz) factory.getBean("seatbiz");


//      SeatVO c = 
//      new SeatVO("1F006", 1);
//      try {
//         biz.modify(c);
//         System.out.println("OK");
//      } catch (Exception e) {
//         e.printStackTrace();
//      }

//      ArrayList<SeatVO> list = null;
//      try {
//         list = biz.get();
//         for (SeatVO co : list) {
//            System.out.println(co);
//         }
//      } catch (Exception e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }

      for (int i = 10; i <= 60; i++) {
         SeatVO v = new SeatVO("3F0"+i, 0);
         try {
            biz.register(v);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }

      factory.close();
      System.out.println("Spring End .......");
      System.out.println("App End .......");

   }

}