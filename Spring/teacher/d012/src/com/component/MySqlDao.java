package com.component;

import com.frame.Dao;

public class MySqlDao implements Dao {

	@Override
	public void insert() {
		System.out.println("MySql Inserted...");

	}

	@Override
	public void delete() {
		System.out.println("MySql Deleted...");
	}

	@Override
	public void update() {
		System.out.println("MySql Updated...");

	}

}
