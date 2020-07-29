package vendingmachine;

import java.util.*;

public class Product3 implements ProductImps{
	ArrayList<Product> list = new ArrayList<>();
	static int min = 500;
	public Product3() {
		Product pr1 = new Product("Soup", 500);
		Product pr2 = new Product("Pizza", 600);
		Product pr3 = new Product("Bread", 700);
		Product pr4 = new Product("KFC", 800);
		list.add(pr1);
		list.add(pr2);
		list.add(pr3);
		list.add(pr4);
	};
	
	@Override
	public ArrayList getAllProduct() {
		return list;
	}
	
	@Override
	public void getMenu() {
		System.out.println("---------- MENU ----------");
		for (Product pr : list) {
			System.out.println(pr.name + "\t\t\t\t" + pr.getPrice());
		}
	}
	
	@Override
	public int getMin() {
		return min;
	}
}
