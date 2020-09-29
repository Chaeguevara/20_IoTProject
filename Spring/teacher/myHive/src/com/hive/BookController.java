package com.hive;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.biz.Click;
import com.frame.Book;

@Controller
public class BookController {

	@Autowired
	Book<Click> book;

	@RequestMapping("/book.mc")
	public ModelAndView book(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		String id = req.getParameter("id");
		String item = req.getParameter("item");
		String act = req.getParameter("act");
		String age = "30";
		String gender = "M";

		Click click = new Click(id, item, act, gender, age);
		book.bookclick(click);

		return mv;
	}

}
