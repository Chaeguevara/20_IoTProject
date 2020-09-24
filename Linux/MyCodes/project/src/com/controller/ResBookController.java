package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.BookVO;
import com.vo.ResBookVO;

@Controller
public class ResBookController {
	@Resource(name="bbiz")
	Biz<String,BookVO> biz;
	
	@Resource(name="resbookbiz")
	Biz<String,ResBookVO> resbbiz;
	
	//채희진
	//최종수정일:2020.09.07
	//관리자 대출내역 조회
	@RequestMapping("/getresbookimpl.mc")
	public ModelAndView bookadd(ModelAndView mv) {
		ArrayList<ResBookVO> resblist = null;
		ArrayList<BookVO> booklist = new ArrayList<BookVO>();
		try {
			resblist = resbbiz.get();
			mv.addObject("resblist", resblist);
			mv.addObject("centerpage", "manager");
			for(ResBookVO v:resblist) {
				BookVO book = biz.get(v.getBookid());
				booklist.add(book);
			}
			mv.addObject("bookList", booklist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.setViewName("main/main");
		return mv;
	}
}
