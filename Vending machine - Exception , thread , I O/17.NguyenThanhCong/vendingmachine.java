package ex1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vendingmachine {
	static List<String> list3 = new ArrayList();
	static List<Integer> list2 = new ArrayList();
	static List<String> listp = new ArrayList();
	static List<Integer> addmoney = new ArrayList();
	static int excess_money;
	public static int add_money(int money) {
		Scanner sc3 = new Scanner (System.in);
		System.out.println("add money");
		money = sc3.nextInt();
//		System.out.println("your money " + money);
		return money;
	}
	
	public static void vending_machine(int money ) {
		
		final int price_min =10;
		
		 money += add_money(money);
		 System.out.println("your money " + money);
		  excess_money = money;
		if(money >= price_min) {

			
		
			
			Scanner sc = new Scanner (System.in);
			System.out.println("choose your product");
			for (int i = 0; i < list3.size(); i++) {
				System.out.print(list3.get(i) + " " + list2.get(i) + " ");
			}
			String type_drink = sc.next();	
			for (int i = 0; i < list3.size(); i++) {
				if (type_drink.equals(list3.get(i))){
					excess_money -= list2.get(i);
					if(excess_money >=0) {
						listp.add(list3.get(i));
						addmoney.add(list2.get(i));
						System.out.println("here is your " + type_drink);
						
						System.out.println("your excess_money " + excess_money);
						System.out.println("want more ? yes or no ");
						Scanner sc2 = new Scanner (System.in);
						String choose2 = sc2.next();
						if (choose2.equals("yes") || choose2.equals("y")) {
							 vending_machine(excess_money);
							}else if(choose2.equals("no")) {
								//System.out.println("here is your " + type_drink);
								System.out.println("here is your excess_money " + excess_money);
							}
						}else {
							System.out.println("return money ? yes or no ?");
							Scanner sc1 = new Scanner(System.in);
							String choose = sc1.nextLine();
							if(choose.equals("yes") || choose.equals("y")) {
								
								System.out.println("your money "+money+" was return");
							}else if(choose.equals("no") || choose.equals("n")) {

								vending_machine(money);
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

				vending_machine(money);
				
			}else if(choose.equals("yes") || choose.equals("y"))
			{
				System.out.println("your money " + money + " is paying back");
				System.out.println("bye");
			}
		}
	
		}
	public static void name_price(){
		list2.add(20);
		list2.add(30);
		list2.add(40);
		list2.add(10);
		
		list3.add("a");
		list3.add("b");
		list3.add("c");
		list3.add("d");
	}
public void stop() {
	
}
	public static void main(String[] args) throws IOException {
		name_price();
		int money = 0;
		vending_machine(money);
//		String pasteDir = "C:/Users/phaml/Desktop/1.txt";
//		int sum = 0;
//		for (int i = 0; i < addmoney.size(); i++) {
//			sum += addmoney.get(i);
//		}
//		int total= excess_money + sum;
//		try {
//			FileOutputStream outputStream = new FileOutputStream(pasteDir);
//			
//			for (int i = 0; i < listp.size(); i++) {
//				String a = "\n" +listp.get(i) +"\t\t\t" + addmoney.get(i) ;			
//				byte[] b = a.getBytes();
//				outputStream.write(b);
//				
//			}
//			String a = " \nTotal money:\t\t" + total + "\nyour excess_money\t" + excess_money;
//			byte[] b = a.getBytes();
//			outputStream.write(b);
//			
//			outputStream.close();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
	}
}
