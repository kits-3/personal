package entity;

public class Customer {
	
	private int id;
	private String name;
	private String address;
	private String phone;
	private String order_date;
	private String order_item;
	private int total;
	
	public Customer(int id, String name, String address, String phone,String order_date,String order_item,int total) {

		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.order_date = order_date;
		this.order_item = order_item;
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getOrder_item() {
		return order_item;
	}

	public void setOrder_item(String order_item) {
		this.order_item = order_item;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public Customer() {

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
