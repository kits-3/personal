package VendingMaChineOOP2;

import java.util.List;
import java.util.Scanner;

public abstract class VendingMachine {

	final static double MIN_COST = 5000;

	protected List<Product> listProduct;
	List<Product> listProductChoose;

	protected int id;
	protected String nameMachine;

	public VendingMachine() {
	}

	public VendingMachine(List<Product> listProduct, int id, String nameMachine) {
		this.listProduct = listProduct;
		this.id = id;
		this.nameMachine = nameMachine;

	}

	public int getId() {
		return id;
	}

	public String nameMachine() {
		return nameMachine;
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
	public abstract int chooseProduct();

	// get element from array list
	public abstract Product getProductList(int index_Product);

	public abstract boolean isWantContinue(String str);
	
	public abstract void addProductInCart(double moneyCurrent,Product product);

	public void displayCurrentProductInCart(List<Product> listProductChoose) {
		System.out.println("=====================    Current product in Cart    =======================");
		double totalPrice=0;
		for(Product product:listProductChoose) {
			totalPrice+=product.getPrice();
			System.out.printf("Product name: %s , Price: %f\n",product.getName(),product.getPrice());
		}
		System.out.println("==> Total price is : "+totalPrice);
		System.out.println("=====================    Current product in Cart    =======================");
	}
	
	// Run machine ...
	public abstract void run();
}
