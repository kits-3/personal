<<<<<<< HEAD:Vending machine - Exception , thread , I O/12.VuThanhLong/project/src/Product.java
=======
package com.entity;
>>>>>>> origin/team_5:Vending machine - Exception , thread , I O/28.VuManhDuc/VendingIO/src/com/entity/Drink.java

public class Drink{
	private int id;
	private String name;
	private int price;
<<<<<<< HEAD:Vending machine - Exception , thread , I O/12.VuThanhLong/project/src/Product.java

	public Product() {
		super();
	}

	public Product(int id, String name, int price) {
=======
	
	public Drink() {
	}
	
	public Drink(int id, String name, int price) {
>>>>>>> origin/team_5:Vending machine - Exception , thread , I O/28.VuManhDuc/VendingIO/src/com/entity/Drink.java
		super();
		this.name = name;
		this.price = price;
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
