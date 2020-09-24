package com.component;

import com.frame.Biz;
import com.frame.Dao;

public class UserBiz implements Biz {

	Dao dao;
	
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	@Override
	public void register() {
		dao.insert();
	}

	@Override
	public void remove() {
		dao.delete();
	}

	@Override
	public void modify() {
		dao.update();
	}

}
