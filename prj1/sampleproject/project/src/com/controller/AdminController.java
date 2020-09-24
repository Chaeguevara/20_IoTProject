package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	@RequestMapping("/admin.mc")
	public ModelAndView admin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/main");
		return mv;
	}
	
}




