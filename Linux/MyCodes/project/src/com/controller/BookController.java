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
public class BookController {
	@Resource(name = "bbiz")
	Biz<String, BookVO> biz;

	@Resource(name = "resbookbiz")
	Biz<String, ResBookVO> resbbiz;

	// 책 더하기 페이지로 이동
	@RequestMapping("/bookadd.mc")
	public ModelAndView bookadd(ModelAndView mv) {
		mv.addObject("centerpage", "book/register");
		mv.setViewName("main/main");
		return mv;
	}
	
	// 책 조회하기로 우선 이동
	@RequestMapping("/bookupdate.mc")
	public ModelAndView bookupdate(ModelAndView mv) {
		mv.addObject("centerpage", "book/get");
		mv.setViewName("main/main");
		return mv;
	}

	// 책 더하기
	@RequestMapping("/bookaddimpl.mc")
	public ModelAndView bookaddimpl(ModelAndView mv, BookVO regibook) {

		String imgname = regibook.getMf().getOriginalFilename();
		regibook.setImg(imgname);
		System.out.println(imgname);

		System.out.println("Book add requested");
		System.out.println(regibook);

		try {
			biz.register(regibook);
			Util.saveFile(regibook.getMf());
			System.out.println("Ok");
			mv.addObject("regibook",regibook);
			mv.addObject("centerpage", "book/registerok");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("fail");
			mv.addObject("centerpage", "book/registerfail");
			e.printStackTrace();
		}

		mv.setViewName("main/main");
		return mv;
	}
	
	// 책 삭제페이지
	@RequestMapping("/bookdelete.mc")
	public ModelAndView bookdelete(ModelAndView mv) {
		mv.addObject("centerpage", "book/remove");
		mv.setViewName("main/main");
		return mv;
	}
	
	// 책 삭제하기
	@RequestMapping("/bookdeleteimpl.mc")
	public String bookdeleteimpl(String id) {
		try {
			biz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:bookselectall.mc";
	}

	// 장서조회
	@RequestMapping("/bookselectall.mc")
	public ModelAndView bookselectall(ModelAndView mv) {
		ArrayList<BookVO> list = null;
		try {
			list = biz.get();
			mv.addObject("booklist", list);
			mv.addObject("centerpage", "book/selectall");
		} catch (Exception e) {
			mv.addObject("centerpage", "book/selectfail");
			e.printStackTrace();
		}

		mv.setViewName("main/main");
		return mv;
	}

	// 책 상세조회
	@RequestMapping("/bookdetail.mc")
	public ModelAndView bookdetail(ModelAndView mv, String id) {
		System.out.println(id);
		BookVO book = null;
		try {
			book = biz.get(id);
			System.out.println(book);
			mv.addObject("bookdetail", book);
			mv.addObject("centerpage", "book/detail");
		} catch (Exception e) {
			mv.addObject("centerpage", "book/selectfail");
			e.printStackTrace();
		}

		mv.setViewName("main/main");
		return mv;
	}

	// 책 업데이트
	@RequestMapping("/bookupdateimpl.mc")
	public String bookupdateimpl(BookVO book) {
		String newimgname = book.getMf().getOriginalFilename();
		System.out.println(book);
		if (!newimgname.equals("")) {
			book.setImg(newimgname);
			Util.saveFile(book.getMf());
		}
		try {
			biz.modify(book);
			System.out.println("Update ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:bookdetail.mc?id=" + book.getId();
	}
}
