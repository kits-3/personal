package vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vendingmachine implements Interface {

	@Override
	public boolean isContinue(int money) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Your money is: " + money);
		System.out.println("want more select product? y or n");
		String checkMoreString = scan.next();
		if (checkMoreString.equals("n")) {
			System.out.println("your change : " + money + " good bye");
			 return false;
		}
		return true;
	}

	@Override
	public List<Product> chooseMachine(int choose) {
		List<Product> listProduct = new ArrayList<>();
		switch(choose) {
		case 1:
			listProduct.add(new Product(1,"Beer",100));
			listProduct.add(new Product(2,"Coke",200));
			listProduct.add(new Product(3,"Juice",300));
			break;
		case 2:
			listProduct.add(new Product(1,"Swing",100));
			listProduct.add(new Product(2,"Lays",200));
			listProduct.add(new Product(3,"Poca",300));
			break;
		case 3:
			listProduct.add(new Product(1,"Burger",100));
			listProduct.add(new Product(2,"Banh Mi",200));
			listProduct.add(new Product(3,"Toppoki",300));
			break;
		default:
			break;
		}
		
		return listProduct;
	}

	@Override
	public void showMachine() {
		System.out.println("Choose machine type");
		System.out.println("1. Drink Vending Machine ");
		System.out.println("2. Snack Vending Machine");
		System.out.println("3. Food Veding Machine");
		
	}

	@Override
	public void showProduct(List<Product> listProduct) {
		for(Product item: listProduct) {
			System.out.println("ID: "+ item.getId()+", " + "Name: "+item.getName()+", "+"Price: "+item.getPrice());
		}
		
	}

	@Override
	public int minPrice(List<Product> listProduct) {
		int result = Integer.MAX_VALUE;
		for(Product item: listProduct) {
			if(item.getPrice()<result) result = item.getPrice();
		}
		return result;
	}

}
