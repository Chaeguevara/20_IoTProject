package vo;

import java.util.Date;

public class Item {
	private int id;
	private String name;
	private int price;
	private Date regdate;
	public Item() {
	}
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public Item(int id, String name, int price, Date regdate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.regdate = regdate;
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

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", regdate=" + regdate + "]";
	}
	
}
