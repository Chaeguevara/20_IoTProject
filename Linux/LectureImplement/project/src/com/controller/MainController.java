package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.UserVO;

@Controller
public class MainController {

	@Resource(name = "ubiz")
	Biz<String, UserVO> biz;

	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main/main");
		return mv;
	}

	@RequestMapping("/login.mc")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("centerpage", "login");
		mv.setViewName("main/main");
		return mv;
	}

	@RequestMapping("/logout.mc")
	public ModelAndView logout( HttpSession session) {
		System.out.println("Logout requested");
		ModelAndView mv = new ModelAndView();
		if (session != null) {
			session.invalidate();
		}
		mv.setViewName("main/main");
		return mv;
	}


	@RequestMapping("/loginimpl.mc")
	public ModelAndView loginimpl(ModelAndView mv, HttpSession session, UserVO loginuser) {	
		System.out.println("Login requested");

		UserVO dbuser;
		try {
			dbuser = biz.get(loginuser.getId());
			// 출력세개
			System.out.println(loginuser.getId());
			dbuser = biz.get(loginuser.getId());
			System.out.println(loginuser);
			System.out.println(dbuser);

			if (loginuser.getPwd().equals(dbuser.getPwd())) {
				if (dbuser.getId().equals("admin")) {
					dbuser.setPosition(1);
				}
				session.setAttribute("loginuser", dbuser);
				mv.addObject("centerpage", "loginok");
				System.out.println("login ok");	
			} else {
				mv.addObject("centerpage", "loginfail");
				System.out.println("login fail");
			}
		} catch (Exception e) {
			mv.addObject("centerpage", "loginfail");
			System.out.println("exception");
			e.printStackTrace();
		}
		mv.setViewName("main/main");
		
		return mv;
	}
	
}
