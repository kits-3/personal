package com.booking.entity;

public class PriceEntity {
	private int idPrice;
	private int price;
	private String description;
	public PriceEntity() {}
	public PriceEntity(int idPrice, int price, String description) {
		super();
		this.idPrice = idPrice;
		this.price = price;
		this.description = description;
	}
	public int getIdPrice() {
		return idPrice;
	}
	public void setIdPrice(int idPrice) {
		this.idPrice = idPrice;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
