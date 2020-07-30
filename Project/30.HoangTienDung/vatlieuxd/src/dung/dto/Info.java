package dung.dto;

public class Info {
	
	public Info() {}
	
	public Info(int id, int users_id, String name, String address, String phone, double money) {
		this.id = id;
		this.users_id = users_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.money = money;
	}
	
	public String toString() {
		String print = "Id: "+id+"\tUsers_id: "+users_id+"\tName: "+name+"\tAddress: "+address+"\tPhone: "+phone+"\tMoney: "+money;
		return print;
	}

	private int id;
	private int users_id;
	private String name;
	private String address;
	private String phone;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
}
