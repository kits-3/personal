package VendingMaChineOOP2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

	public String getNameMachine() {
		return nameMachine;
	}

	public void setNameMachine(String nameMachine) {
		this.nameMachine = nameMachine;
	}

	public void setId(int id) {
		this.id = id;
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

	public abstract void addProductInCart(double moneyCurrent, Product product);

	public void displayCurrentProductInCart(List<Product> listProductChoose) {
		System.out.println("=====================    Current product in Cart    =======================");
		double totalPrice = 0;
		for (Product product : listProductChoose) {
			totalPrice += product.getPrice();
			System.out.printf("Product name: %s , Price: %f\n", product.getName(), product.getPrice());
		}
		System.out.println("==> Total price is : " + totalPrice);
		System.out.println("=====================    Current product in Cart    =======================");
	}

	// I/O
	public void receipt(List<Product> listProductChoose) {

		// get a string from product
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < listProductChoose.size(); i++) {
			buffer.append(listProductChoose.get(i).getName() + listProductChoose.get(i).getPrice()).append("\n");
		}

		String str = buffer.toString();

		writeReceipt(str);

	}

	// Write file java using OutPut stream
	private void writeReceipt(String data) { 
		File newfile = new File("C:/Users/PC09/Desktop/exam/text2.txt");
		OutputStream os = null;
		try {
			os = new FileOutputStream(newfile);
			os.write(data.getBytes(), 0, data.length());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void printReceipt(List<Product> listProductChoose) {
		Scanner sc = new Scanner(System.in);
		// Print receipt
		System.out.println("Do you want to print receipt? Y/N");
		String choice = sc.nextLine();
		boolean isPrintReceipt = false;
		if (choice.equalsIgnoreCase("Y")) {
			isPrintReceipt = true;
		} else {
			isPrintReceipt = false;
			return;
		}

		if (isPrintReceipt) {
			receipt(listProductChoose);
		}
	}
	
	// Call Thread
	public void threadDelay(String s) {
		Thread_Example thread_Example=new Thread_Example(s);
		Thread thread=new Thread(thread_Example);
		thread.start();
		
	}

	// Run machine ...
	public abstract void run() throws InvalidException, InvalidConfirmException;

}
