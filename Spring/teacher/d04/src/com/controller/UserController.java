package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.UserVO;

@Controller
public class UserController {

	@Resource(name="ubiz")
	Biz<String, UserVO> biz;
	
	@RequestMapping("/useradd.mc")
	public ModelAndView useradd(ModelAndView mv) {
		mv.addObject("centerpage", "user/register"); 
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/useraddimpl.mc")
	public ModelAndView useraddimpl(ModelAndView mv,
			UserVO user) {
		try {
			biz.register(user);
			mv.addObject("centerpage", "user/registerok"); 
		} catch (Exception e) {
			mv.addObject("centerpage", "user/registerfail"); 
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/userselect.mc")
	public ModelAndView userselect(ModelAndView mv) {
		ArrayList<UserVO> list = null;
		try {
			list = biz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("userlist", list);
		mv.addObject("centerpage", "user/get"); 
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/userdetail.mc")
	public ModelAndView userdetail(ModelAndView mv,
			String id) {
		UserVO user = null;
		try {
			user = biz.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("userdetail",user);
		mv.addObject("centerpage", "user/detail"); 
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/userdelete.mc")
	public String userdelete(String id) {
		try {
			biz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:userselect.mc";
	}
	
	@RequestMapping("/userupdate.mc")
	public ModelAndView userupdate(ModelAndView mv,
			String id) {
		UserVO user = null;
		try {
			user = biz.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("dbuser",user);
		mv.addObject("centerpage", "user/modify"); 
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/userupdateimpl.mc")
	public String userupdateimpl(UserVO user) {
		try {
			biz.modify(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:userdetail.mc?id="+user.getId();
	}
}




