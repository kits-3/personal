package home.computer.entity;

import java.sql.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class orderEntity {
	private int id;
	private String id_user, id_product, OrderName;
	private Date OrderDate;
	
	public orderEntity() {
		super();
	}

	public orderEntity(int id, String id_user, String id_product, String orderName, Date orderDate) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.id_product = id_product;
		OrderName = orderName;
		OrderDate = orderDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getId_product() {
		return id_product;
	}

	public void setId_product(String id_product) {
		this.id_product = id_product;
	}

	public String getOrderName() {
		return OrderName;
	}

	public void setOrderName(String orderName) {
		OrderName = orderName;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	
	
	
	
	
}
