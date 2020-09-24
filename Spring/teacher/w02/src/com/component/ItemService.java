package com.component;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.frame.Dao;
import com.frame.Search;
import com.frame.Service;
import com.vo.Item;
@org.springframework.stereotype.Service("itemservice")
public class ItemService implements Service<String, Item>,
Search<Integer,Integer,Item>{
	@Resource(name="itemdao")
	Dao dao;
	
	@Resource(name="itemdao")
	Search search;
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	@Override
	public void register(Item v) {
		dao.insert(v);
	}

	@Override
	public void remove(String k) {
		dao.delete(k);
	}

	@Override
	public void modify(Item v) {
		dao.update(v);
	}

	@Override
	public Item get(String k) {
		return (Item) dao.select(k);
	}

	@Override
	public ArrayList<Item> get() {
		return dao.select();
	}

	@Override
	public ArrayList<Item> search(Integer k) {
		return search.search(k);
	}

	@Override
	public ArrayList<Item> search(Integer k1, Integer k2) {
		return search.search(k1,k2);
	}



	
}






