package vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Home {
	public static void main(String[] args) {
		ArrayList<Product> list = new ArrayList<>();
		ChooseProduct c = new ChooseProduct();
		list = c.getProduct();
		int min = c.min;
		
		boolean checkMoney = true;
		boolean checkMore = true;
		int money = 0;
		
		Scanner scan = new Scanner(System.in);
		while(checkMore) {
			System.out.print("Please input money: ");
			money += scan.nextInt();
			System.out.println("Check your money : "+ money);
			if(money < min) {
				System.out.println("Want more? please input y or n");
				String checkString = scan.next();
				if(checkString.equals("y")) {
					
				}else {
					System.out.println("Good bye!");
					checkMore = false;
				}
			}else {
				while(checkMore) {
					c.getMenu();
					String selectProduct = scan.next();
					for(Product listPr : list) {
						if(selectProduct.equals(listPr.name)) {
							if(listPr.price > money) {
								checkMore = true;
								break;
							}
							System.out.println("Your select: "+listPr.name);
							money = money - listPr.price;
							System.out.println(money);
						}
					}
					System.out.println("Want more select product? y or n");
					String checkMoreString = scan.next();
					if(checkMoreString.equals("y")) {
						
					}else {
						System.out.println("Your change: "+money);
						System.out.println("Good bye!");
						checkMore = false; 
					}
				}
			}
		}
	}
}
