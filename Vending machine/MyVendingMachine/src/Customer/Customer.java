package Customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Customer {

	private List<Product> selectedProduct;
	private int currentMoney;

	public Customer() {
		this.selectedProduct = new ArrayList<Product>();
		this.currentMoney = 0;
	}

	public List<Product> getSelectProduct() {
		return this.selectedProduct;
	}

	public void setSelectedProduc(Product product) {
		selectedProduct.add(product);
	}

	public int getTotalMoney() {
		return this.currentMoney;
	}

	public void setTotalMoney(int insertedMoney) {
		this.currentMoney += insertedMoney;
	}

	public int selectProduct(Scanner scanner, Set<Product> productSet) {
		displayProducts(productSet);
		int option = 0;
		while (true) {
			try {
				System.out.print("Select product (enter number only): ");
				option = Integer.valueOf(scanner.next());
				if (checkProductExist(option, productSet.size())) {
					break;
				}
			} catch (NumberFormatException nfe) {
				System.out.println("WARNING: ACCEPT ONLY NUMBER. PLEASE ENTER AGAIN: ");
				
				continue;
			}
		}
		return option;
	}

	private void displayProducts(Set<Product> productSet) {
		System.out.println("LIST OF PRODUCTS:");
		System.out.println("No.\tPRODUCT NAME\tPRODUCT PRICE");
		Iterator<Product> productsIterator = productSet.iterator();
		int i = 1;
		while (productsIterator.hasNext()) {
			Product currentProduct = productsIterator.next();
			System.out.println(i + ".\t" + currentProduct.getProductName() + "\t\t" + currentProduct.getProductPrice());
			++i;
		}
	}

	private boolean checkProductExist(int option, int quantityOfProductType) {
		option = Math.abs(option);
		if (option > 0 && option <= quantityOfProductType) {
			return true;
		}
		System.out
				.println("WARNING: THE PRODUCT DOES NOT EXIST. PLEASE ENTER PRODUCT FROM 1->" + quantityOfProductType);
		
		return false;
	}

	public void inputMoney(Scanner scanner) {
		int insertedMoney = 0;
		System.out.println("=====USER======");
		System.out.print("Please insert money (USD): ");
		try {
			insertedMoney = Integer.parseInt(scanner.next());
		} catch (NumberFormatException nfe) {
			System.out.println("WARNING: PLEASE ENTER NUMBER ONLY!!!");
		}
		currentMoney += insertedMoney;
		System.out.println("Your current money is: " + currentMoney);
	}
}
