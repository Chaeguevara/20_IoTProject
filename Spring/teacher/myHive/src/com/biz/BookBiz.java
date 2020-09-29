package com.biz;

import org.springframework.stereotype.Service;

import com.frame.Book;
@Service
public class BookBiz implements Book<Click> {

	@Override
	public void bookclick(Click t) {
		System.out.println(t);
	}

}
