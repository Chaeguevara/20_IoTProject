package com.component;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
@Repository("oracledao")
public class OracleDao implements Dao {

	@Override
	public void insert() {
		System.out.println("Oracle Inserted...");
	}

	@Override
	public void delete() {
		System.out.println("Oracle Deleted...");

	}

	@Override
	public void update() {
		System.out.println("Oracle Updated...");

	}

}
