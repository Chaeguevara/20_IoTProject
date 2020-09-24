package test;

import java.util.ArrayList;

import controller.UserController;
import frame.Controller;
import vo.Item;
import vo.User;

public class UserSelectTest2 {

	public static void main(String[] args) {
		User user = null;
		Controller<String, User> controller = 
				new UserController();
		try {
			user = controller.get("id01");
			System.out.println(user);
		} catch (Exception e) {
			System.out.println("Select Fail");
			e.printStackTrace();
		}
	}

}


