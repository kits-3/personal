package vendingmachine;

import java.util.*;

public class Product1 implements ProductImps{
	ArrayList<Product> list = new ArrayList<>();
	static int min = 100;
	public Product1() {
		Product pr1 = new Product("Orange", 100);
		Product pr2 = new Product("Banana", 150);
		Product pr3 = new Product("Apple", 200);
		Product pr4 = new Product("Mango", 250);
		list.add(pr1);
		list.add(pr2);
		list.add(pr3);
		list.add(pr4);
	};
	
	@Override
	public ArrayList getAllProduct() {
		return list;
	}
}
