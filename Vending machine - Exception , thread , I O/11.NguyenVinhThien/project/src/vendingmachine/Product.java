package vendingmachine;

import java.util.ArrayList;

public class Product{
	ArrayList<Product> list = new ArrayList<>();
	String name;
	int price;
	static int min;
	public Product() {}
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
