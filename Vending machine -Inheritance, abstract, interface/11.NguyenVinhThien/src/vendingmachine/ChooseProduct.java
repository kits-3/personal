package vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChooseProduct {
	ArrayList<Product> list = new ArrayList<>();
	static int min = 0;
	public ArrayList<Product> getProduct() {
		Scanner scan = new Scanner(System.in);
		System.out.println("---------- CHOOSE PRODUCT ----------");
		System.out.println("1. Fruit");
		System.out.println("2. Drink");
		System.out.println("3. Food");
		int pr = scan.nextInt();
		if(pr == 1) {
			Product1 pr1 = new Product1();
			list = pr1.getAllProduct();
			min = pr1.min;
		} else if(pr == 2) {
			Product2 pr1 = new Product2();
			list = pr1.getAllProduct();
			min = pr1.min;
		} else if(pr == 3) {
			Product3 pr1 = new Product3();
			list = pr1.getAllProduct();
			min = pr1.min;
		}
		return list;
	}
	
	public void getMenu() {
		System.out.println("---------- MENU ----------");
		for (Product pr : list) {
			System.out.println(pr.name + "\t\t\t\t" + pr.getPrice());
		}
	}
}
