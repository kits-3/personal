package vendingmachine;

import java.util.*;

public class Product2 implements ProductImps{
	ArrayList<Product> list = new ArrayList<>();
	static int min = 200;
	public Product2() {
		Product pr1 = new Product("Milk", 200);
		Product pr2 = new Product("Beer", 300);
		Product pr3 = new Product("RedBull", 400);
		Product pr4 = new Product("Coffee", 500);
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
