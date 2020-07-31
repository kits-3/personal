package dung.dto;



public class Order {
	
	public Order(int id, int users_id, int info_id, int pro_id, int quantity, double mount, String status_check) {
		this.id = id;
		this.users_id = users_id;
		this.info_id = info_id;
		this.pro_id = pro_id;
		this.quantity = quantity;
		this.mount = mount;
		this.status_check = status_check;
	}
	
	public Order() {};
	
	private int id;
	private int users_id;
	private int info_id;
	private int pro_id;
	private int quantity;
	private double mount;
	private String status_check;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	public int getInfo_id() {
		return info_id;
	}
	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getMount() {
		return mount;
	}
	public void setMount(double mount) {
		this.mount = mount;
	}
	public String getStatus_check() {
		return status_check;
	}
	public void setStatus_check(String status_check) {
		this.status_check = status_check;
	}
	
	public String toString() {
		String print = "id: "+id+"\tusers_id: "+users_id+"\tinfo_id: "+info_id+"\tpro_id: "+pro_id+"\tquantity: "+quantity+"\tmount: "+mount+"\tstatus_check: "+status_check;
		return print;
	}
}
