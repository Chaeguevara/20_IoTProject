package test;

import java.util.ArrayList;

import controller.ItemController;
import frame.Controller;
import vo.Item;

public class ItemSelectTest {

	public static void main(String[] args) {
		ArrayList<Item> list = null;
		Controller<Integer, Item> controller = 
				new ItemController();
		try {
			list = controller.get();
			for(Item it : list) {
				System.out.println(it);
			}
		} catch (Exception e) {
			System.out.println("Select Fail");
			e.printStackTrace();
		}
	}

}


