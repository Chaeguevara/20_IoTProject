package com.test;

import com.biz.ProductDb;
import com.frame.Db;
import com.vo.Product;

public class InsertProductTest {

	public static void main(String[] args) {
		Db<Integer,Product> db =
				new ProductDb("127.0.0.1", "db", "db");
		Product p = new Product(100, "¹ÙÁö", 20000, 3.4);
		try {
			db.insert(p);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		
	}

}
