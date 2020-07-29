package project.management.entity;

public class ProductEntity {
	private int id;
	private String name;
	private int price;
	private int total;
	private int status;
	private int storeMachineId;
	
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStoreMachineId() {
		return storeMachineId;
	}
	public void setStoreMachineId(int storeMachineId) {
		this.storeMachineId = storeMachineId;
	}
	

}
