package project.management.entity;

public class OrderItemProductEntity {
	private int id;
	private int productid;
	private int orderid;
	private int countOrdered;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getCountOrdered() {
		return countOrdered;
	}
	public void setCountOrdered(int countOrdered) {
		this.countOrdered = countOrdered;
	}
	
	
}
