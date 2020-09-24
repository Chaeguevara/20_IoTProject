package com.mapper;

import java.util.ArrayList;

import com.vo.Item;

public interface ItemMapper {
	public void insert(Item obj);
	public void delete(String obj);
	public void update(Item obj);
	public Item select(String obj);
	public ArrayList<Item> selectall();
}



