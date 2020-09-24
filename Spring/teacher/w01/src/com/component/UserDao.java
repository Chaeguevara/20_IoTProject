package com.component;

import java.util.ArrayList;

import com.frame.Dao;
import com.vo.User;

public class UserDao implements Dao<String, User> {

	@Override
	public void insert(User v)  throws Exception{
//		if(v.getId().equals("id01")) {
//			throw new Exception();
//		}
		System.out.println("Inserted:"+v);
	}

	@Override
	public void delete(String k)  throws Exception{
		System.out.println("Deleted:"+k);
	}

	@Override
	public void update(User v)  throws Exception{
		System.out.println("Updated:"+v);		
	}

	@Override
	public User select(String k)  throws Exception{
		User user = new User(k,"pwd02","James");
		return user;
	}

	@Override
	public ArrayList<User> select()  throws Exception{
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("id01","pwd01","James1"));
		list.add(new User("id02","pwd02","James2"));
		list.add(new User("id03","pwd03","James3"));
		list.add(new User("id04","pwd04","James4"));
		list.add(new User("id05","pwd05","James5"));
		return list;
	}

}




