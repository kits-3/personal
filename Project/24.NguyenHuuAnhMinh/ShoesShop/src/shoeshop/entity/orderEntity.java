package shoeshop.entity;

import java.util.List;

public class orderEntity {
	private int orderID;
	private UserEntity user;
	private List<orderItemEntity> items;
	private int TotalPrice;
	public orderEntity() {
		super();
	}
	public orderEntity(int orderID, UserEntity user, List<orderItemEntity> items, int totalPrice) {
		super();
		this.orderID = orderID;
		this.user = user;
		this.items = items;
		TotalPrice = totalPrice;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public List<orderItemEntity> getItems() {
		return items;
	}
	public void setItems(List<orderItemEntity> items) {
		this.items = items;
	}
	public int getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}
	
}
