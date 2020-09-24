package vo;

import java.util.ArrayList;

public class User {
	private String id;
	private String pwd;
	private String name;
	
	ArrayList<UserItem> userItems;
	
	public User() {
	}
	
	public User(String id, String pwd, String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}
	
	public User(String id, String pwd, String name, ArrayList<UserItem> userItems) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.userItems = userItems;
	}

	public ArrayList<UserItem> getUserItems() {
		return userItems;
	}

	public void setUserItems(ArrayList<UserItem> userItems) {
		this.userItems = userItems;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", name=" + name + ", userItems=" + userItems + "]";
	}

	
}
