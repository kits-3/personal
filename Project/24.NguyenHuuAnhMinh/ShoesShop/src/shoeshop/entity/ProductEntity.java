package shoeshop.entity;

public class ProductEntity {
	private int ProductID;
	private String ProductName;
	private int ProductPrice;
	private int ProductQuantity;
	public ProductEntity() {
		super();
	}
	public ProductEntity(int productID, String productName, int productPrice, int productQuantity) {
		super();
		ProductID = productID;
		ProductName = productName;
		ProductPrice = productPrice;
		ProductQuantity = productQuantity;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(int productPrice) {
		ProductPrice = productPrice;
	}
	public int getProductQuantity() {
		return ProductQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}
}
