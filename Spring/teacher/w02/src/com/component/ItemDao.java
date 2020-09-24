package com.component;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.frame.Search;
import com.vo.Item;
@Repository("itemdao")
public class ItemDao implements Dao<String, Item>,
Search<Integer,Integer,Item>{

	@Override
	public void insert(Item v) {
		System.out.println("Inserted:"+v);		
	}

	@Override
	public void delete(String k) {
		System.out.println("Deleted:"+k);		
	}

	@Override
	public void update(Item v) {
		System.out.println("Updated:"+v);			
	}

	@Override
	public Item select(String k) {
		Item item = new Item(k,"pants",10000,new Date());
		return item;
	}

	@Override
	public ArrayList<Item> select() {
		ArrayList<Item> list = new ArrayList<Item>();
		list.add(new Item("it01","pants",10000,new Date()));
		list.add(new Item("it02","pants",20000,new Date()));
		list.add(new Item("it03","pants",30000,new Date()));
		list.add(new Item("it04","pants",40000,new Date()));
		list.add(new Item("it05","pants",50000,new Date()));
		return list;
	}

	@Override
	public ArrayList<Item> search(Integer k) {
		ArrayList<Item> list = new ArrayList<Item>();
		list.add(new Item("it01","pants",10000,new Date()));
		list.add(new Item("it02","pants",20000,new Date()));
		return list;
	}

	@Override
	public ArrayList<Item> search(Integer k1, Integer k2) {
		ArrayList<Item> list = new ArrayList<Item>();
		list.add(new Item("it01","pants",10000,new Date()));
		list.add(new Item("it02","pants",20000,new Date()));
		list.add(new Item("it03","pants",30000,new Date()));
		return list;
	}
	
	

}



