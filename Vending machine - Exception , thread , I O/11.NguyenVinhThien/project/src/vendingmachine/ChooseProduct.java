package vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChooseProduct {
	ArrayList<Product> list = new ArrayList<>();
	static public ProductImps getProduct() {
		ProductImps prdct = null;
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("---------- CHOOSE PRODUCT ----------");
			System.out.println("1. Fruit");
			System.out.println("2. Drink");
			System.out.println("3. Food");
			int pr = scan.nextInt();
			if(pr == 1) {
				prdct = new Product1();
			} else if(pr == 2) {
				prdct = new Product2();
			} else if(pr == 3) {
				prdct = new Product3();
			} else {
				throw new NullPointerException("Input number (1-3).");
			}
		} catch (NullPointerException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return prdct;
	}
}

