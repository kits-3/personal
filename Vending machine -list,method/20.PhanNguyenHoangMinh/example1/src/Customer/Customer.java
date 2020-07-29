package Customer;

import java.util.*;

public class Customer {

	private List<Product> selectedProduct;
	private int totalMoney;
	
	public Customer(){
		this.selectedProduct = new ArrayList<Product>();
		this.totalMoney = 0;
	}
	
	public List<Product> getSelectProduct(){
		return this.selectedProduct;
	}
	
	public void setSelectedProduc(Product product){
		selectedProduct.add(product);
	}
	
	public int getTotalMoney(){
		return this.totalMoney;
	}
	
	public void setTotalMoney(int insertedMoney){
		this.totalMoney += insertedMoney;
	}
	
	public int selectProduct(Scanner scanner, Set<Product> productSet){
		displayProducts(productSet);
		int option = 0;
		while(true){
			try{
				System.out.print("Select product (enter number only): ");
				option = Integer.valueOf(scanner.next());
				if (checkProductExist(option, productSet.size())){
					break;
				}
			}catch(NumberFormatException nfe){
				System.out.println("Warning: Accept only number. Please enter again: ");
				continue;
			}
		}		
		return option;
	}
	
	private void displayProducts(Set<Product> productSet){
		System.out.println("LIST OF PRODUCTS:");
		System.out.println("No.\tPRODUCT NAME\tPRODUCT PRICE");
		Iterator<Product> productsIterator = productSet.iterator();
		int i=1;
		while(productsIterator.hasNext()){
			Product currentProduct = productsIterator.next();
			System.out.println(i + ".\t" + currentProduct.getProductName() + "\t\t" + currentProduct.getProductPrice());
			++i;
		}
	}
	
	private boolean checkProductExist(int option, int quantityOfProductType){
		option = Math.abs(option);
		if (option > 0 && option <= quantityOfProductType){
			return true;
		}
		System.out.println("Warning: The product does not exist. Please enter product from 1->" + quantityOfProductType);
		return false;
	}
	
	public int inputMoney(Scanner scanner){
		int insertedMoney = 0;
		System.out.println("=====USER======");
		System.out.print("Please insert money (USD): ");
		try{
			insertedMoney = Integer.parseInt(scanner.next());
		}catch(NumberFormatException nfe){
			System.out.println("Warning: Please enter number only!!!");
		}
		totalMoney += insertedMoney;
		return totalMoney;
	}
}
