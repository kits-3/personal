package shoeshop.entity;

public class orderItemEntity {
	private int orderItemID; 
	public ProductEntity product;
	private int quantity;
	private String CustomerLoginID;
	private String ProductName;
	
	public orderItemEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public orderItemEntity(int orderItemID, ProductEntity product, int quantity, String customerLoginID,
			String productName) {
		super();
		this.orderItemID = orderItemID;
		this.product = product;
		this.quantity = quantity;
		CustomerLoginID = customerLoginID;
		ProductName = productName;
	}

	public int getOrderItemID() {
		return orderItemID;
	}

	public void setOrderItemID(int orderItemID) {
		this.orderItemID = orderItemID;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCustomerLoginID() {
		return CustomerLoginID;
	}

	public void setCustomerLoginID(String customerLoginID) {
		CustomerLoginID = customerLoginID;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}
	
	
}
