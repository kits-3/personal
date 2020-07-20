package ex1;

import java.util.Scanner;




public class vendingmachine {
	
	public static int add_money(int money) {
		Scanner sc3 = new Scanner (System.in);
		System.out.println("add money");
		money = sc3.nextInt();
		return money;
	}
	
	
	
	
	public static int vending_machine(int money ) {
		final int price_coca = 20;
		final int price_pepsi = 30;
		final int price_milk = 40;
		final int price_water = 10;
		final int price_min =10;
		
		 money += add_money(money);
		 int excess_money = money;
		if(money >= price_min) {
			System.out.println("choose the drink for you");
			System.out.println("press 1 to choose coca, press 2 to choose pepsi, press 3 to choose milk, press 4 to choose water ");
			Scanner sc = new Scanner (System.in);
			int type_drink = sc.nextInt();
			
			switch(type_drink) {
			case 1:
				excess_money -= price_coca ; 
				if(excess_money >= 0) {
					System.out.println("want more");
					Scanner sc2 = new Scanner(System.in);
					String choose2 = sc2.nextLine();
					if(choose2.equals("yes")) {
						return vending_machine(excess_money);
					}else if(choose2.contentEquals("no")) {
						System.out.println("here is your drink");
						System.out.println("here is your excess_money " + excess_money);
					}
				}else {
					System.out.println("return money ?");
					Scanner sc1 = new Scanner(System.in);
					String choose = sc1.nextLine();
					if(choose.equals("yes")) {
						System.out.println("your money "+money+" was return");
					}else if(choose.contentEquals("no")) {
						return vending_machine(money+add_money(money));
					}
				
				}
				
				break;
			case 2:
				excess_money -= price_pepsi ; 
				if(excess_money >= 0) {
					System.out.println("want more");
					Scanner sc2 = new Scanner(System.in);
					String choose2 = sc2.nextLine();
					if(choose2.equals("yes")) {
						return vending_machine(excess_money);
					}else if(choose2.contentEquals("no")) {
						System.out.println("here is your drink");
						System.out.println("here is your excess_money " + excess_money);
					}
				}else {
					System.out.println("return money ?");
					Scanner sc1 = new Scanner(System.in);
					String choose = sc1.nextLine();
					if(choose.equals("yes")) {
						System.out.println("your money "+money+" was return");
					}else if(choose.contentEquals("no")) {
						return vending_machine(money+add_money(money));
					}
				
				}
			
				break;
			case 3:
				excess_money -= price_milk ; 
				if(excess_money >= 0) {
					System.out.println("want more");
					Scanner sc2 = new Scanner(System.in);
					String choose2 = sc2.nextLine();
					if(choose2.equals("yes")) {
						return vending_machine(excess_money);
					}else if(choose2.contentEquals("no")) {
						System.out.println("here is your drink");
						System.out.println("here is your excess_money " + excess_money);
					}
				}else {
					System.out.println("return money ?");
					Scanner sc1 = new Scanner(System.in);
					String choose = sc1.nextLine();
					if(choose.equals("yes")) {
						System.out.println("your money "+money+" was return");
					}else if(choose.contentEquals("no")) {
						return vending_machine(money+add_money(money));
					}
				
				}
			case 4:
				excess_money -= price_water ; 
				if(excess_money >= 0) {
					System.out.println("want more");
					Scanner sc2 = new Scanner(System.in);
					String choose2 = sc2.nextLine();
					if(choose2.equals("yes")) {
						return vending_machine(excess_money);
					}else if(choose2.contentEquals("no")) {
						System.out.println("here is your drink");
						System.out.println("here is your excess_money " + excess_money);
					}
				}else {
					System.out.println("return money ?");
					Scanner sc1 = new Scanner(System.in);
					String choose = sc1.nextLine();
					if(choose.equals("yes")) {
						System.out.println("your money "+money+" was return");
					}else if(choose.contentEquals("no")) {
						return vending_machine(money+add_money(money));
					}
				
				}
//			}
//			System.out.println(excess_money);
		}
	}
		return 0;}
	public static void main(String[] args) {
	int money =0;

	

		vending_machine(money);
	}

	
}
