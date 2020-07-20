package VendingMaChineOOP2;

import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachineHN extends VendingMachine{

	final static double MIN_COST = 15000;

	ArrayList<Product> listProduct;
	ArrayList<Product> listProductChoose;

	public VendingMachineHN() {
		listProduct = new ArrayList<Product>();

		Product product1 = new Product("Coca", 15000);
		Product product2 = new Product("Pepsi", 16000);
		Product product3 = new Product("Orange juice", 17000);
		Product product4 = new Product("7Up", 18000);
		Product product5 = new Product("Sochu", 19000);

		listProduct.add(product1);
		listProduct.add(product2);
		listProduct.add(product3);
		listProduct.add(product4);
		listProduct.add(product5);
	}

	// check Money Min Cost Product
	public boolean checkMoneyMinCostProduct(double soTien) {
		return (soTien > MIN_COST);
	}

	// User insert money
	public double insertMoney() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Insert money (Minimun cost is %.2f) : ", MIN_COST);
		double soTien = sc.nextDouble();

		return soTien;
	}

	// Choose product
	public int chooseProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose product (plz input from 1->5): ");
		int indexProduct = sc.nextInt() - 1;

		return indexProduct;
	}

	// get element from array list
	public Product getProductList(int index_Product) {
		return listProduct.get(index_Product);
	}

	//
	public boolean isWantContinue(String str) {

		return (str.equalsIgnoreCase("Yes")) ? true : false;
	}
	
	@Override
	public void run() {
		super.run();
	}

}
