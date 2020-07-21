package vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	static int money = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean checkMore = true;
		List<Product> listProduct = new ArrayList<>();
		Interface vendingMachine = new vendingmachine();
		Product selectedProduct = null;
		Scanner scan = new Scanner(System.in);

		vendingMachine.showMachine();
		int chooseMachine = scan.nextInt();

		listProduct = vendingMachine.chooseMachine(chooseMachine);

		while (checkMore) {
			System.out.println("please input money");
			money += scan.nextInt();
			if (money < vendingMachine.minPrice(listProduct)) {
				System.out.println("Not enough money");
				checkMore = vendingMachine.isContinue(money);
			} else {
				while (checkMore) {
					System.out.println("check your money : " + money);
					System.out.println("please select product");
					vendingMachine.showProduct(listProduct);
					
					System.out.println("Choose a number!");
					int chooseProduct = scan.nextInt();
					for(Product item :listProduct) {
						if(item.getId()==chooseProduct) selectedProduct = item ;
					}
					if (selectedProduct.getPrice() > money) {
						System.out.println("Not enough money");
						checkMore = vendingMachine.isContinue(money);
						break;
					}
					System.out.println("your select :" + selectedProduct.getName());
					money = money - selectedProduct.getPrice();
					checkMore = vendingMachine.isContinue(money);
					if(money< vendingMachine.minPrice(listProduct)) break;
				}
			}
		}
	}

}
