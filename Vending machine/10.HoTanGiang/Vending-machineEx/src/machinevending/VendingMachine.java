package machinevending;

import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input your money please....");
		int money = sc.nextInt();
		final int MIN_COST = 100;
		boolean flag = false;
		while (true) {
			while (money < MIN_COST || flag == true && money < MIN_COST) {
				System.out.println("Your money current: " + money);
				System.out.println("Your money not enough! Do you want to take back your money?");
				flag = false;
				String answer = sc.next();
				if (answer.equalsIgnoreCase("yes")) {
					money = 0;
					System.out.println("Your money is back");
					break;
				} else if (answer.equalsIgnoreCase("no")) {
					System.out.print("You want to add: ");
					int extraMoney = sc.nextInt();
					money += extraMoney;
					System.out.println("Your money current: " + money);
				} else {
					
				}
			}
			if (money == 0) {
				System.out.println("Thank you !");
				break;
			}
			if(money >= MIN_COST && flag == true) {
				System.out.println("Your money current: " + money);
				System.out.println("Do you want to take back your money?");
				String answer = sc.next();
				if (answer.equalsIgnoreCase("yes")) {
					money = 0;
					System.out.println("Your money is back");
					System.out.println("Thank you !");
					break;
				}else if (answer.equalsIgnoreCase("no")){
					
				}
				flag = false;
			}
			// Coca : 100 , pepsi : 140 , orange : 100
			System.out.println("Select you want to drink");
			System.out.println("1. Coca 100");
			System.out.println("2. Pepsi 140");
			System.out.println("3. Orange 100");
			int select;
			while (true) {
				System.out.print("Your select: ");
				select = sc.nextInt();
				if (select > 0 || select < 4)
					break;
				System.out.println("Your select not found! please select again");
			}
			switch (select) {
			case 1:
				if (money >= 100) {
					money -= 100;
					System.out.println("You can get your drink");
				} else {
					System.out.println("Your money current: " + money);
					System.out.println("Your money not enough to buy this");
				}
				break;
			case 2:
				if (money >= 140) {
					money -= 140;
					System.out.println("You can get your drink");
				} else {
					System.out.println("Your money current: " + money);
					System.out.println("Your money not enough to buy this");
				}
				break;
			case 3:
				if (money >= 100) {
					money -= 100;
					System.out.println("You can get your drink");
				} else {
					System.out.println("Your money current: " + money);
					System.out.println("Your money not enough to buy this");
				}
				break;
			default:
				break;
			}
			flag = true;
		}
		sc.close();
	}
}
