package com.test;

import com.biz.UserDb;
import com.frame.Db;
import com.vo.User;

public class SelectUserTest {

	public static void main(String[] args) {
		Db<String,User> db 
		   = new UserDb("127.0.0.1", "db", "db");
		User user = null;
		try {
			user = db.select("id01");
			System.out.println(user);
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}

}
