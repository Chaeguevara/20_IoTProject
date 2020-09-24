package com.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ShopVO {
	private int id;
	private String name;
	private int price;
	private Date regdate;
	private String img;
	MultipartFile mf;
	public ShopVO() {
	}
	public ShopVO(String name, int price, String img) {
		this.name = name;
		this.price = price;
		this.img = img;
	}
	public ShopVO(int id, String name, int price, Date regdate, String img, MultipartFile mf) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.regdate = regdate;
		this.img = img;
		this.mf = mf;
	}
	public ShopVO(int id, String name, int price, Date regdate, String img) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.regdate = regdate;
		this.img = img;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public MultipartFile getMf() {
		return mf;
	}
	public void setMf(MultipartFile mf) {
		this.mf = mf;
	}
	@Override
	public String toString() {
		return "ShopVO [id=" + id + ", name=" + name + ", price=" + price + ", regdate=" + regdate + ", img=" + img
				+ ", mf=" + mf + "]";
	}
	
}






