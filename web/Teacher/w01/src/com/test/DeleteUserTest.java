package com.test;

import com.biz.UserDb;
import com.frame.Db;
import com.vo.User;

public class DeleteUserTest {

	public static void main(String[] args) {
		Db<String,User> db 
		   = new UserDb("127.0.0.1", "db", "db");
		try {
			db.delete("id88");
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}

}
