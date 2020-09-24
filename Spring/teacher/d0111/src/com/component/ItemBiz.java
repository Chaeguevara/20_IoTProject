package com.component;

import com.biz.Biz;

public class ItemBiz implements Biz {
	
	public ItemBiz() {
		System.out.println("ItemBiz Constructor ....");
	}
	@Override
	public void register() {
		System.out.println("Item register");

	}

	@Override
	public void remove() {
		System.out.println("Item remove");

	}

	@Override
	public void modify() {
		System.out.println("Item modify");

	}

}
