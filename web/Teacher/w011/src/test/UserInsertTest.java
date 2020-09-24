package test;

import controller.UserController;
import frame.Controller;
import vo.User;

public class UserInsertTest {

	public static void main(String[] args) {
		User u = new User("id22", "pwd22", "È«¸»¼÷");
		Controller<String, User> controller = 
				new UserController();
		try {
			controller.register(u);
			System.out.println("Register OK");
		} catch (Exception e) {
			System.out.println("Register Fail");
			e.printStackTrace();
		}
	}

}


