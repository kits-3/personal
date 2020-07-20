package vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class example {
	static int money = 0;
	
	static List<String> listName = new ArrayList<String>();
	static List<Integer> listPrice = new ArrayList<Integer>();
	
	static public void getMenu() {
		System.out.println("Please select product: ");
		System.out.println("1. " + listName.get(0) + "\t\t\t" + listPrice.get(0));
		System.out.println("2. " + listName.get(1) + "\t\t" + listPrice.get(1));
		System.out.println("3. " + listName.get(2) + "\t\t\t" + listPrice.get(2));
		System.out.println("4. " + listName.get(3) + "\t\t" + listPrice.get(3));
		System.out.print("Choose product: ");
	}

	public static void main(String[] args) {
		
		boolean checkMoney = true;
		boolean checkMore = true;
		
		listName.add("Tea");
		listName.add("Juice");
		listName.add("Milk");
		listName.add("Orange");
		
		listPrice.add(100);
		listPrice.add(200);
		listPrice.add(300);
		listPrice.add(150);
		
		Scanner scan = new Scanner(System.in);
		while(checkMore) {
			System.out.print("Please input money: ");
			money += scan.nextInt();
			System.out.println("Check your money : "+ money);
			if(money < listPrice.get(0) && money < listPrice.get(1) && money < listPrice.get(2) && money < listPrice.get(3)) {
				System.out.println("Want more? please input y or n");
				String checkString = scan.next();
				if(checkString.equals("y")) {
					
				}else {
					System.out.println("Good bye!");
					checkMore = false;
				}
			}else {
				while(checkMore) {
					getMenu();
					String selectProduct = scan.next();
					if(selectProduct.equals(listName.get(0))) {
						System.out.println("Your select: "+listName.get(0));
						money = money - listPrice.get(0); 
					}else if(selectProduct.equals(listName.get(1))) {
						if(listPrice.get(1) > money) {
							checkMore = true;
							break;
						}
						System.out.println("Your select: "+listName.get(1));
						money = money - listPrice.get(1);
					}else if(selectProduct.equals(listName.get(2))) {
						if(listPrice.get(2) > money) {
							checkMore = true;
							break;
						}
						System.out.println("Your select: "+listName.get(2));
						money = money - listPrice.get(2);
					}else if(selectProduct.equals(listName.get(3))) {
						if(listPrice.get(3) > money) {
							checkMore = true;
							break;
						}
						System.out.println("Your select: "+listName.get(3));
						money = money - listPrice.get(3);
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
