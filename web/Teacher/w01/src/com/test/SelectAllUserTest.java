package com.test;

import java.util.ArrayList;

import com.biz.UserDb;
import com.frame.Db;
import com.vo.User;

public class SelectAllUserTest {

	public static void main(String[] args) {
		Db<String,User> db 
		   = new UserDb("127.0.0.1", "db", "db");
		ArrayList<User> list = null;
		try {
			list = db.select();
			for(User u :list) {
				System.out.println(u);
			}
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}

}
