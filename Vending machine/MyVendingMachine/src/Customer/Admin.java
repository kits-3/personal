package Customer;

import java.util.Scanner;

public class Admin {

	public Product insertProductsIntoVendingMachine(Scanner scanner){
		String productName="";
		int productPrice=0;
		int productQuantity=0;
		System.out.println("==============START Import Product===============");
		productName = enterProductName(scanner);
		productPrice = enterProductPrice(scanner);
		productQuantity = enterProductQuantity(scanner);
		System.out.println("==============END Import Product===============");
		return new Product(productName.toUpperCase(), productPrice, productQuantity);
	}
	
	private String enterProductName(Scanner scanner){
		System.out.print("Please enter product name: ");
		String productName = scanner.next();
		return productName;
	}
	
	private int enterProductPrice(Scanner scanner){
		int productPrice = 0;
		
		while(true){
			try{
				System.out.print("Please enter product price: ");
				productPrice = Integer.valueOf(scanner.next());
			}catch(NumberFormatException nfe){
				System.out.println("Warning: Please enter number for price!!!");
				continue;
			}
			break;
		}
		return productPrice;
	}
	
	private int enterProductQuantity(Scanner scanner){
		int productQuantity=0;
		while(true){
			try{
				System.out.print("Please enter product quantity: ");
				productQuantity = Integer.valueOf(scanner.next());
			}catch(NumberFormatException nfe){
				System.out.println("Warning: Please enter number for num of product!!!");
				continue;
			}
			break;
		}
		return productQuantity;
	}
}
