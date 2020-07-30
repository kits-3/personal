package dung.dto;


public class Input {
	
	public Input() {};
	
	public Input(int id, int users_id, int pro_id, int quantity, double money) {
		this.id = id;
		this.users_id = users_id;
		this.pro_id = pro_id;
		this.quantity = quantity;
		this.money = money;
	}
	
	
	
	private int id;
	private int users_id;
	private int pro_id;
	private int quantity;
	private double money;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String toString() {
		String print = "Id: "+id+"\tUsers_id: "+users_id+"\tPro_id: "+pro_id+"\tQuantity: "+quantity+"\tMoney: "+money;
		return print;
	}

}
