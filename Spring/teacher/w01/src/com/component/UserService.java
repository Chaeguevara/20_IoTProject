package com.component;

import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Service;
import com.vo.User;

public class UserService implements Service<String, User> {

	Dao<String,User> dao;
	
	public void setDao(Dao<String,User> dao) throws Exception {
		this.dao = dao;
	}
	
	@Override
	public void register(User v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(User v)  throws Exception{
		dao.update(v);
	}

	@Override
	public User get(String k)  throws Exception{
		User user = null;
		Thread.sleep(5000);
		user = dao.select(k);
		return user;
	}

	@Override
	public ArrayList<User> get() throws Exception {
		return dao.select();
	}

}
