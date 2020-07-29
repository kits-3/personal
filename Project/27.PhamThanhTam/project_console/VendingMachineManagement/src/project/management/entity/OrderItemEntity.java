package project.management.entity;

public class OrderItemEntity {
	private int id;
	private String name;
	private int moneytotal;
	private int storemachineid;
	private int status;
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
	public int getMoneytotal() {
		return moneytotal;
	}
	public void setMoneytotal(int moneytotal) {
		this.moneytotal = moneytotal;
	}
	public int getStoremachineid() {
		return storemachineid;
	}
	public void setStoremachineid(int storemachineid) {
		this.storemachineid = storemachineid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
