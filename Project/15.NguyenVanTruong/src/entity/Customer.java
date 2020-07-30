package entity;

public class Customer {
	private int id_customer;
	private int id_user;
	private String name_customer;
	private String numberphone;
	private String mail;
	private int money;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int id_customer, int id_user, String name_customer, String numberphone, String mail, int money) {
		super();
		this.id_customer = id_customer;
		this.id_user = id_user;
		this.name_customer = name_customer;
		this.numberphone = numberphone;
		this.mail = mail;
		this.money = money;
	}
	public int getId_customer() {
		return id_customer;
	}
	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getName_customer() {
		return name_customer;
	}
	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}
	public String getNumberphone() {
		return numberphone;
	}
	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}
