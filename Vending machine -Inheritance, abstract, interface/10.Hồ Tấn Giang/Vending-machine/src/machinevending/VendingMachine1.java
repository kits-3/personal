package machinevending;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine1 {
	static int money = 0;
	static boolean checkBuyMore = false;
	static Scanner sc = new Scanner(System.in);
	static List<Product> list;
	static final int MIN_COST = 100;

	public static void main(String[] args) {
		System.out.println("1. Drink Machine");
		System.out.println("2. Noodle Machine");
		System.out.println("3. Candy Machine");
		System.out.println("Select machine: ");
		int machine = sc.nextInt();
		selectMachine(machine);
		System.out.println("Input your money please....");
		money = sc.nextInt();
		
		boolean checkLoop = false;
		String s;
		while (true) {
			while (money < MIN_COST || checkLoop == true && money < MIN_COST || checkBuyMore == true) {
				checkLoop = false;
				s = "Your money not enough! Do you want to add your money(y) or get your money current(n)?";
				if (askReturnMoney(s, MIN_COST)) {
					break;
				}
				checkBuyMore = false;
			}
			if (money >= MIN_COST && checkLoop == true) {
				s = "Do you want to buy more (y or n)?";
				if (askReturnMoney(s, MIN_COST)) {
					break;
				}
			}
			if (money == 0) {
				System.out.println("Thank you !");
				break;
			}
			System.out.println("Select you want to drink");
			int[] productCost = new int[list.size() + 1];
			int i = 1;
			for (Product items: list) {
				System.out.println(i + ". " + items.getName() + " " + items.getCost());
				productCost[i++] = items.getCost();
			}
			int select;
			Product product = null;
			while (true) {
				System.out.print("Your select: ");
				select = sc.nextInt();
				if (select > 0 || select <= list.size()) {
					if(list.get(select-1) instanceof Candy) {
						product = new Candy();
						product = list.get(select-1);
					}else if(list.get(select-1) instanceof Noodle) {
						product = new Noodle();
						product = list.get(select-1);
					}else if(list.get(select-1) instanceof Drink) {
						product = new Drink();
						product = list.get(select-1);
					}
//					Check count product to announce
					if(product.getCount() == 0) {
						if(product instanceof Candy) {
							((Candy) product).count();
						}else if(product instanceof Noodle) {
							((Noodle) product).count();
						}else if(product instanceof Drink) {
							((Drink) product).count();
						}
					}
					break;	
				}else {
					System.out.println("Your select not found! please select again");
				}
			}
			if(product.getCount() != 0) {
				selectProduct(productCost[select], product);
			}
			checkLoop = true;
		}
		sc.close();
	}

	public static boolean askReturnMoney(String s, int minCost) {
		System.out.println("Your money current: " + money);
		System.out.println(s);
		String answer = sc.next();
		if (answer.equalsIgnoreCase("n")) {
			money = 0;
			System.out.println("Your money is back");
			return true;
		} else if (answer.equalsIgnoreCase("y")) {
			if (money < minCost || checkBuyMore == true) {
				System.out.print("You want to add: ");
				int extraMoney = sc.nextInt();
				money += extraMoney;
				System.out.println("Your money current: " + money);
			} else {

			}
		}
		return false;
	}

	public static void selectProduct(int productCost, Product product) {
		checkBuyMore = true;
		while(checkBuyMore) {
			if (money >= productCost) {
				money -= productCost;
				product.setCount(product.getCount()-1);
				System.out.println("You can get your order");
				checkBuyMore = false;
			} else {
				checkBuyMore = true;
				String s = "Your money not enough to buy this! Do you want to add your money(y) or get your money current(n)?";
				if(askReturnMoney(s, MIN_COST)) break;
			}
		}
	}
	
	public static void selectMachine(int machine) {
		list = new ArrayList<Product>();
		switch (machine) {
		case 1:
			list.add(new Drink(100, "coke",3));
			list.add(new Drink(140, "pepsi",3));
			list.add(new Drink(100, "orange",3));
			break;
		case 2:
			list.add(new Noodle(100, "Gấu đỏ",3));
			list.add(new Noodle(160, "Lẩu thái",3));
			list.add(new Noodle(180, "Hảo Hảo",3));
			break;
		case 3:
			list.add(new Candy(100, "coffe",3));
			list.add(new Candy(120, "mentos",3));
			list.add(new Candy(130, "chocolate",3));
			break;
		default:
			break;
		}
	}
	
	
}
