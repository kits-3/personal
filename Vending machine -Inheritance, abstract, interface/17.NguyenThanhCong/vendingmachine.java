package ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vendingmachine {
	static List<String> list3 = new ArrayList();
	static List<Integer> list2 = new ArrayList();
	public static int add_money(int money) {
		Scanner sc3 = new Scanner (System.in);
		System.out.println("add money");
		money = sc3.nextInt();
		return money;
	}
	
	public static int vending_machine(int money ) {
		
		final int price_min =10;
		
		 money += add_money(money);
		 int excess_money = money;
		if(money >= price_min) {

			
		
			
			Scanner sc = new Scanner (System.in);
			System.out.println("choose your drink");
			for (int i = 0; i < list3.size(); i++) {
				System.out.print(list3.get(i) + " " + list2.get(i) + " ");
			}
			String type_drink = sc.next();	
			for (int i = 0; i < list3.size(); i++) {
				if (type_drink.equals(list3.get(i))){
					excess_money -= list2.get(i);
					if(excess_money >=0) {
						System.out.println("want more ? yes or no ");
						Scanner sc2 = new Scanner (System.in);
						String choose2 = sc2.next();
						if (choose2.equals("yes") || choose2.equals("y")) {
							
							return vending_machine(excess_money);
							}else if(choose2.contentEquals("no")) {
								System.out.println("here is your drink");
								System.out.println("here is your excess_money " + excess_money);
							}
						}else {
							System.out.println("return money ? yes or no ?");
							Scanner sc1 = new Scanner(System.in);
							String choose = sc1.nextLine();
							if(choose.equals("yes") || choose.equals("y")) {
								
								System.out.println("your money "+money+" was return");
							}else if(choose.equals("no") || choose.equals("n")) {
								money += add_money(money);
								return vending_machine(money);
							}
						}
						}
					}				
				}
		else {
			System.out.println("return money ?");
			Scanner sc1 = new Scanner(System.in);
			String choose = sc1.nextLine();
			if(choose.equals("no") || choose.equals("n")) {
				money += add_money(money);
				return vending_machine(money);
				
			}else if(choose.equals("yes") || choose.equals("y"))
			{
				System.out.println("your money " + money + " is paying back");
				System.out.println("bye");
			}
		}
		return 0;
		}
	
	public static void main(String[] args) {
		list2.add(20);
		list2.add(30);
		list2.add(40);
		list2.add(10);
		
		list3.add("product1");
		list3.add("product2");
		list3.add("product3");
		list3.add("product4");
		int money = 0;
		vending_machine(money);
		
	}
}
