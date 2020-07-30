package dung.dto;

public class Product {
	
	private int id;
	private String name;
	private double price_in;
	private double price_out;
	private int quantity;
	
	public Product() {};
	
	public Product(int id, String name, double price_in, double price_out, int quantity) {
		this.id = id;
		this.name = name;
		this.price_in = price_in;
		this.price_out = price_out;
		this.quantity = quantity;
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
	public double getPrice_in() {
		return price_in;
	}
	public void setPrice_in(double price_in) {
		this.price_in = price_in;
	}
	public double getPrice_out() {
		return price_out;
	}
	public void setPrice_out(double price_out) {
		this.price_out = price_out;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
public String toString() {
		String print = "Id: "+id+"\tName: "+name+"\tPrice_in: "+price_in+"\tPrice_out: "+price_out+"\tQuantity: "+quantity;
		return print;
	}
}
