package vendingmachine;

import java.util.ArrayList;
import java.util.Scanner;

public class Example {
	public static void main(String[] args) {
		ArrayList<Product> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		System.out.println("---------- CHOOSE PRODUCT ----------");
		System.out.println("1. Fruit");
		System.out.println("2. Drink");
		System.out.println("3. Food");
		System.out.print("Select product: ");
		int pr = scan.nextInt();
		if(pr == 1) {
			ProductImps listPr = new Product1();
			list = listPr.getAllProduct();
		} else if(pr == 2) {
			ProductImps listPr = new Product2();
			list = listPr.getAllProduct();
		} else if(pr == 3) {
			ProductImps listPr = new Product3();
			list = listPr.getAllProduct();
		}
		for (Product prr : list) {
			System.out.println(prr.name);
		}
	}
}
