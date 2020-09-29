package com.biz;

public class Click {
	private String id;
	private String item;
	private String act;
	private String gender;
	private String age;
	public Click() {
		super();
	}
	public Click(String id, String item, String act, String gender, String age) {
		super();
		this.id = id;
		this.item = item;
		this.act = act;
		this.gender = gender;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getAct() {
		return act;
	}
	public void setAct(String act) {
		this.act = act;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Click2 [id=" + id + ", item=" + item + ", act=" + act + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	
}
