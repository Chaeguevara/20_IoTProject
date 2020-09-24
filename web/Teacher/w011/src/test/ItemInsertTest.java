package test;

import controller.ItemController;
import frame.Controller;
import vo.Item;
import vo.User;

public class ItemInsertTest {

	public static void main(String[] args) {
		Item u = new Item("Į2", 10000);
		Controller<Integer, Item> controller = 
				new ItemController();
		try {
			controller.register(u);
			System.out.println("Register OK");
		} catch (Exception e) {
			System.out.println("Register Fail");
			e.printStackTrace();
		}
	}

}


