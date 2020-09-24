package com.component;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
@Repository("mysqldao")
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
