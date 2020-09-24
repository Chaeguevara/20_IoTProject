package vo;

public class UserItem {
	private String id;
	private String user_id;
	private int item_id;
	private int qt;
	private String item_name;
	public UserItem() {
	}
	public UserItem(String id) {
		this.id = id;
	}
	public UserItem(String user_id, int item_id, int qt) {
		this.user_id = user_id;
		this.item_id = item_id;
		this.qt = qt;
	}
	public UserItem(String id, String user_id, int item_id, int qt, String item_name) {
		this.id = id;
		this.user_id = user_id;
		this.item_id = item_id;
		this.qt = qt;
		this.item_name = item_name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getQt() {
		return qt;
	}
	public void setQt(int qt) {
		this.qt = qt;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	@Override
	public String toString() {
		return "UserItem [id=" + id + ", user_id=" + user_id + ", item_id=" + item_id + ", qt=" + qt + ", item_name="
				+ item_name + "]";
	}
	
}





