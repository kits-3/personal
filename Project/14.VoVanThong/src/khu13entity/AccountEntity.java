package khu13entity;

public class AccountEntity {
	private int id;
	private String name;
	private String access;
	private String password;
	private int money;
	private String phone;
	private String typeofaccess;
	public AccountEntity() {
		super();
	}
	public AccountEntity(int id, String name, String access, String password, int money, String phone,String typeofaccess) {
		this.id = id;
		this.name = name;
		this.access = access;
		this.password = password;
		this.money = money;
		this.phone = phone;
		this.typeofaccess = typeofaccess;
	}
	public String getTypeofaccess() {
		return typeofaccess;
	}
	public void setTypeofaccess(String typeofaccess) {
		this.typeofaccess = typeofaccess;
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
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
