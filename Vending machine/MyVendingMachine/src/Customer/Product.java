package Customer;

public class Product {

	private String productName;
	private int productPrice;
	private int numOfProducts;
	
	public Product(){
	}
	
	public Product(String productName, int productPrice, int numOfProducts){
		this.productName = productName;
		this.productPrice = productPrice;
		this.numOfProducts = numOfProducts;
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
	
	public void setNumOfProducts(int numOfProducts){
		this.numOfProducts = numOfProducts;
	}
	
	public int getNumOfProducts(){
		return this.numOfProducts;
	}
}
