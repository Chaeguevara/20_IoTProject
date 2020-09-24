package com.component;

import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Service;
import com.vo.Item;

public class ItemService implements Service<String, Item> {

	Dao dao;
	
	public void setDao(Dao dao)  throws Exception{
		this.dao = dao;
	}
	
	@Override
	public void register(Item v)  throws Exception{
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(Item v) throws Exception {
		dao.update(v);
	}

	@Override
	public Item get(String k)  throws Exception{
		return (Item) dao.select(k);
	}

	@Override
	public ArrayList<Item> get()  throws Exception{
		return dao.select();
	}

}
