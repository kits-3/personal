import java.util.Scanner;

import Customer.Product;

public class ProductProcess {
	
	public ProductProcess(){
	}
	
	public Product insertProductsIntoVendingMachine(Scanner scanner){
		String productName="";
		int productPrice=0;
		int numOfProducts=0;
		System.out.println("==============START Import Product===============");
		System.out.print("Please enter product name: ");
		productName = scanner.next();
		System.out.print("Please enter product price: ");
		try{
			productPrice = Integer.valueOf(scanner.next());
		}catch(NumberFormatException nfe){
			System.out.println("Please enter number for price!!!");
		}
		System.out.print("Please enter number of products: ");
		try{
			numOfProducts = Integer.valueOf(scanner.next());
		}catch(NumberFormatException nfe){
			System.out.println("Please enter number for num of product!!!");
		}
		System.out.println("==============END Import Product===============");
		return new Product(productName, productPrice, numOfProducts);
	}
	
}
