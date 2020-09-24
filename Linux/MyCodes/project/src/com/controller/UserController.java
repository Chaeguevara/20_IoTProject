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
public class UserController {
	@Resource(name = "ubiz")
	Biz<String, UserVO> biz;

	/* 페이지 이동기능 */
	// 사용자 추가 페이지 로드
	@RequestMapping("/useradd.mc")
	public ModelAndView useradd(ModelAndView mv) {
		mv.addObject("centerpage", "user/register");
		mv.setViewName("main/main");
		return mv;
	}

}
