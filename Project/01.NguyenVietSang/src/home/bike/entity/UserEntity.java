package home.bike.entity;

public class UserEntity {
	private int id_customer;
	private int id_card;
	private int phone;
	private int role_id;
	private String name;
	private String add;
	private String user;
	private String password;
	 public UserEntity() {
		 
	 }
	public UserEntity(int id_customer, int id_card, int phone, int role_id, String name, String add, String user,
			String password) {
		super();
		this.id_customer = id_customer;
		this.id_card = id_card;
		this.phone = phone;
		this.role_id = role_id;
		this.name = name;
		this.add = add;
		this.user = user;
		this.password = password;
	}
	public int getId_customer() {
		return id_customer;
	}
	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}
	public int getId_card() {
		return id_card;
	}
	public void setId_card(int id_card) {
		this.id_card = id_card;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

