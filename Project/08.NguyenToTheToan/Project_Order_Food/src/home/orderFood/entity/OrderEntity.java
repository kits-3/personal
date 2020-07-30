package home.orderFood.entity;

public class OrderEntity {
	private int id;
	private String customerName;
	private String CityCustomer;
	private String PhoneCustomer;
	private String addressCustomer;
	private String warCustomer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCityCustomer() {
		return CityCustomer;
	}
	public void setCityCustomer(String cityCustomer) {
		CityCustomer = cityCustomer;
	}
	public String getPhoneCustomer() {
		return PhoneCustomer;
	}
	public void setPhoneCustomer(String phoneCustomer) {
		PhoneCustomer = phoneCustomer;
	}
	public String getAddressCustomer() {
		return addressCustomer;
	}
	public void setAddressCustomer(String addressCustomer) {
		this.addressCustomer = addressCustomer;
	}
	public String getWarCustomer() {
		return warCustomer;
	}
	public void setWarCustomer(String warCustomer) {
		this.warCustomer = warCustomer;
	}
	
	
	
	
}
