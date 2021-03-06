package com.tcpip;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chat.Client;

@Controller
public class MainController {
	
	Client client;
	
	public MainController() {
		// 서버 아이디, 포트, 접속자 이름
		Client client = new Client("192.168.0.2",5555,"[WEB]");
		try {
			client.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/iot.mc")
	public void iot(HttpServletResponse res) throws IOException {
		/*IoT에게 무언가 보냄*/
		System.out.println("IoT Send Start ....");
		client.sendTarget("/192.168.0.2", "100");
		PrintWriter out = res.getWriter();
		out.print("ok");
		out.close();
	}
	
	@RequestMapping("/phone.mc")
	public void phone() {
		System.out.println("Phone Send Start ....");
	}
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
}
