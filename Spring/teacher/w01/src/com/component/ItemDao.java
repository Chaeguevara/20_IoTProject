package com.component;

import java.util.ArrayList;
import java.util.Date;

import com.frame.Dao;
import com.vo.Item;
import com.vo.User;

public class ItemDao implements Dao<String, Item> {

	@Override
	public void insert(Item v)  throws Exception{
		System.out.println("Inserted:"+v);		
	}

	@Override
	public void delete(String k)  throws Exception{
		System.out.println("Deleted:"+k);		
	}

	@Override
	public void update(Item v)  throws Exception{
		System.out.println("Updated:"+v);			
	}

	@Override
	public Item select(String k)  throws Exception{
		Item item = new Item(k,"pants",10000,new Date());
		return item;
	}

	@Override
	public ArrayList<Item> select()  throws Exception{
		ArrayList<Item> list = new ArrayList<Item>();
		list.add(new Item("it01","pants",10000,new Date()));
		list.add(new Item("it02","pants",20000,new Date()));
		list.add(new Item("it03","pants",30000,new Date()));
		list.add(new Item("it04","pants",40000,new Date()));
		list.add(new Item("it05","pants",50000,new Date()));
		return list;
	}

}
