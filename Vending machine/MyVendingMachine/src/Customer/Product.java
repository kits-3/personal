package Customer;

public class Product {

	private String productCode;
	private String productName;
	private int productPrice;
	private int productQuantity;
	private static int autoIndex = 1;
	
	public Product(){
	}
	
	public Product(String productName, int productPrice, int productQuantity){
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}
	
	public void setProductName(String productName){
		this.productName = productName;
	}
	
	public String getProductName(){
		return this.productName;
	}
	
	public void setProductPrice(int productPrice){
		this.productPrice = productPrice;
	}
	
	public int getProductPrice(){
		return this.productPrice;
	}
	
	public void setNumOfProducts(int productQuantity){
		this.productQuantity = productQuantity;
	}
	
	public int getProductQuantity(){
		return this.productQuantity;
	}
	
	public String getProductCode(){
		return this.getProductCode();
	}
	
	public void setProductCode(String productName){
		this.productCode = String.format("%03s", productName.substring(0, 1) + autoIndex);
		++autoIndex;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %d %d", productCode, productName, productPrice, productQuantity);
			
	}
}
