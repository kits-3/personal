package entity;

public class ReceiptEntity {
	private int id;
	private String name_customer;
	private int id_customer;
	private String phone_customer;
	private int id_game;
	private String name_game;
	private int price;
	private String producer;
	private double total;
	
	
	public ReceiptEntity() {
		super();
	}
	public ReceiptEntity(int id, String name_customer, int id_customer, String phone_customer, int id_game,
			String name_game, int price, String producer, double total) {
		super();
		this.id = id;
		this.name_customer = name_customer;
		this.id_customer = id_customer;
		this.phone_customer = phone_customer;
		this.id_game = id_game;
		this.name_game = name_game;
		this.price = price;
		this.producer = producer;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName_customer() {
		return name_customer;
	}
	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}
	public int getId_customer() {
		return id_customer;
	}
	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}
	public String getPhone_customer() {
		return phone_customer;
	}
	public void setPhone_customer(String phone_customer) {
		this.phone_customer = phone_customer;
	}
	public int getId_game() {
		return id_game;
	}
	public void setId_game(int id_game) {
		this.id_game = id_game;
	}
	public String getName_game() {
		return name_game;
	}
	public void setName_game(String name_game) {
		this.name_game = name_game;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
