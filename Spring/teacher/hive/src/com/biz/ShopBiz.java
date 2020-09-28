package com.biz;

import org.springframework.stereotype.Service;

import com.frame.Shop;
@Service
public class ShopBiz implements Shop<Click> {

	@Override
	public void itemclick(Click t) {
		System.out.println(t);
	}

}
