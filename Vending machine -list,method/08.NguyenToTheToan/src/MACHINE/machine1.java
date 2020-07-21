package MACHINE;

import java.util.Scanner;

public class machine1 {
	static String select;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input your money above 100 please....");
		System.out.println("Input your money:");
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
//	/ Coca : 100 , pepsi : 140 , orange : 100	
		System.out.println("Select you want to drink:");
		select=sc.next();
		switch (select) {
				
				case "coca":
					System.out.println("Select you size:");
					String select2=sc.nextLine();
					String select1=sc.nextLine();
					switch (select1) {
					
					case "large glass:":
						System.out.println("price 100");
						System.out.println("You can get your drink");
						break;
					case "small glass:":
						System.out.println("price 50");
						System.out.println("You can get your drink");
						break;	
		
					default:
						break;
					}
					break;
				case "pepsi":
					switch (select) {
					case "large glass:":
						System.out.println("price 100");
						System.out.println("You can get your drink");
						break;
					case "small glass:":
						System.out.println("price 50");
						System.out.println("You can get your drink");
						break;	
		
					default:
						break;
					}
					break;
				case "switter":
					switch (select) {
					case "large glass:":
						System.out.println("price 100");
						System.out.println("You can get your drink");
						break;
					case "small glass:":
						System.out.println("price 50");
						System.out.println("You can get your drink");
						break;
					case "orange":
					switch (select) {
					case "large glass:":
						System.out.println("price 100");
						System.out.println("You can get your drink");
						break;
					case "small glass:": 
						System.out.println("price 50");
						System.out.println("You can get your drink");
						break;	
			
					default:
						break;
					}		
					}
			break;
		default:
			break;
		}
		switch (select) {
		case "1":
			if (money >= 100) {
				money -= 100;
				System.out.println("You can get your drink");
			} else {
				System.out.println("Your money current: " + money);
				System.out.println("Your money not enough to buy this");
			}
			break;
		case "2":
			if (money >= 140) {
				money -= 140;
				System.out.println("You can get your drink");
			} else {
				System.out.println("Your money current: " + money);
				System.out.println("Your money not enough to buy this");
			}
			break;
		case "3":
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
	

