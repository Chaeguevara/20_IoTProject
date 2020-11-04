package com.tcpip;


import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chat.Client;


@Controller 
public class MainController {
	
	Client client;
		
	public MainController() {
		client = new Client("192.168.1.107",5555,"[WEB]");
		try {
			client.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	// TCP/IP socket 을 통한 Data 전송 ============================================
	@RequestMapping("/iot.mc")
	public void iot(HttpServletResponse res) throws IOException {
		System.out.println("IoT Send Start...");
		client.sendTarget("/192.168.1.107", "100");
		PrintWriter out = res.getWriter();
		out.print("ok");
		out.close();
		
	}
	
//	@RequestMapping("/phone.mc")
//	public void phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Phone Send Start...");
//		
//		
//	}
	
	//  Phone 으로 FCM 보내기 (Tomcat Server 사용)===============================================
	@RequestMapping("/phone.mc")
	public void phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Phone Send Start...");
		URL url = null;
		try {
			url = new URL("https://fcm.googleapis.com/fcm/send");
		} catch (MalformedURLException e) {
			System.out.println("Error while creating Firebase URL | MalformedURLException");
			e.printStackTrace();
		}
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			System.out.println("Error while createing connection with Firebase URL | IOException");
			e.printStackTrace();
		}
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/json");

		// set my firebase server key https://console.firebase.google.com/ 설정 클라우드 메시징에 키값이 있다.
		conn.setRequestProperty("Authorization", "key="
				+ "AAAA8lOJpRo:APA91bFIBy6c8XfFTge-5gA6MHRnFUSeTH54HpLE8yb3MySrXTdmeq7hvdM1iiwi1C1rmh8EbPsM6wFTaHxbz1a7RT2Xjs1c9uZL8FSUVKQfjGQylgTmBmv46sRlevImRCdAcm1O459l");

		// create notification message into JSON format /topics/  옆에는 Android 양식에 맞게 수정
		JSONObject message = new JSONObject();
		message.put("to", "/topics/movie");
		message.put("priority", "high");
		
		// 앱이 꺼져있는 상태에 알림가는 내용 (데이터안감)
		JSONObject notification = new JSONObject();
		notification.put("title", "되냐");
		notification.put("body", "됩니까");
		message.put("notification", notification);
		
		// 앱이 켜져있는 상태에 데이터가 전송됨 (알림 안감)
		JSONObject data = new JSONObject();
		data.put("control", "ㅇㅇㅇ");
		data.put("data", "ㅇㅇㅇㅇ");
		message.put("data", data);


		try {
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			out.write(message.toString());
			out.flush();
			conn.getInputStream();
			System.out.println("OK...............");

		} catch (IOException e) {
			System.out.println("Error while writing outputstream to firebase sending to ManageApp | IOException");
			e.printStackTrace();
		}	
		
	}
	

} // class end
