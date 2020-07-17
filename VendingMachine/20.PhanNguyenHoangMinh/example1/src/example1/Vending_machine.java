package example1;

import java.util.Scanner;

public class Vending_machine {

	public static void main(String[] args) {
		int input;
		Scanner scan = new Scanner(System.in);
	
		int choose=0;
		
		System.out.println("------Product------");
		System.out.println("                   ");
		System.out.println("1. Cola    15000VND");
		System.out.println("2. Pepsi   15000VND");
		System.out.println("3. 7up     20000VND");
		System.out.println("                   ");
		System.out.println("-------------------");
		
		do {
			System.out.print("Insert yours money back: ");
			input = scan.nextInt();
			scan.nextLine();
			if(input < 10000) {
				System.out.println("More than 10000VND!");
			} 
		}while(input<10000);
		
		do {
			System.out.print("Yours choice: " );
			choose = scan.nextInt();
			scan.nextLine();
			if (choose < 1 || choose > 3) {
				System.out.println("Wrong!! Choose again.");
			}
		}while (choose < 1 || choose > 3);
		
		
		switch(choose) {
			case 1: {
				int re_choice;
				int re_input;
				int choice;
				int cola = 15000;
				while(input < 15000) {
					System.out.println("Not enough money! Yours money has return");
					System.out.println("Insert yours money: ");
					input = scan.nextInt();
				} 
					int re_cash = input - cola;
					System.out.println("Yours choice: Cola was chosen");
					System.out.printf("Yours re_cash: %d VND\n",re_cash);
					while(re_cash>0) {
						System.out.println("Do you want Cola more? (1.Yes/2.No)");
						choice = scan.nextInt();
						if (choice == 2) {
							System.out.printf("Give yours money back!!");break;
						}else {
//							System.out.print("Yours re choice: " );
//							choose = scan.nextInt();
							if(re_cash<15000) {
								System.out.println("Not enough money!");
								System.out.println("Insert yours money: ");
								re_input = scan.nextInt();
								int re_money = re_input + re_cash;
								System.out.println("Money you insert: "+re_money);
								re_choice = re_money - cola; 
								System.out.println("Yours choice: Cola was chosen");
								System.out.printf("Yours re_cash: %d VND\n",re_choice);
							}
								else {
								System.out.println("Yours choice: Cola was chosen");
								re_choice = re_cash -cola;
								System.out.printf("Yours re_cash: %d VND\n",re_choice);
							}
						}
					
				}
				
			} break;
			case 2: {
				int re_choice;
				int re_input;
				int choice;
				int pepsi = 15000;
				while(input < 15000) {
					System.out.println("Not enough money! Yours money has return");
					System.out.println("Insert yours money: ");
					input = scan.nextInt();
				} 
					int re_cash = input - pepsi;
					System.out.println("Yours choice: Pepsi was chosen");
					System.out.printf("Yours re_cash: %d VND\n",re_cash);
					while(re_cash>0) {
						System.out.println("Do you want Pepsi more? (1.Yes/2.No)");
						choice = scan.nextInt();
						if (choice == 2) {
							System.out.printf("Give yours money back!!");break;
						}else {
//							System.out.print("Yours re choice: " );
//							choose = scan.nextInt();
							if(re_cash<15000) {
								System.out.println("Not enough money!");
								System.out.println("Insert yours money: ");
								re_input = scan.nextInt();
								int re_money = re_input + re_cash;
								System.out.println("Money you insert: "+re_money);
								re_choice = re_money - pepsi; 
								System.out.println("Yours choice: Pepsi was chosen");
								System.out.printf("Yours re_cash: %d VND\n",re_choice);
							}else {
								System.out.println("Yours choice: Pepsi was chosen");
								re_choice = re_cash -pepsi;
								System.out.printf("Yours re_cash: %d VND\n",re_choice);
							}
						}
					
				}
				
			} break;
			case 3: {
				int re_choice;
				int re_input;
				int choice;
				int SevenUp = 15000;
				while(input < 15000) {
					System.out.println("Not enough money! Yours money has return");
					System.out.println("Insert yours money: ");
					input = scan.nextInt();
				} 
					int re_cash = input - SevenUp;
					System.out.println("Yours choice: 7up was chosen");
					System.out.printf("Yours re_cash: %d VND\n",re_cash);
					while(re_cash>0) {
						System.out.println("Do you want 7up more? (1.Yes/2.No)");
						choice = scan.nextInt();
						if (choice == 2) {
							System.out.printf("Give yours money back!!");break;
						}else {
//							System.out.print("Yours re choice: " );
//							choose = scan.nextInt();
							if(re_cash<15000) {
								System.out.println("Not enough money!");
								System.out.println("Insert yours money: ");
								re_input = scan.nextInt();
								int re_money = re_input + re_cash;
								System.out.println("Money you insert: "+re_money);
								re_choice = re_money - SevenUp; 
								System.out.println("Yours choice: 7up was chosen");
								System.out.printf("Yours re_cash: %d VND\n",re_choice);
							}else {
								System.out.println("Yours choice: 7up was chosen");
								re_choice = re_cash -SevenUp;
								System.out.printf("Yours re_cash: %d VND\n",re_choice);
							}
						}
					}
				}break;
			default: 
				break;
		}
	}
	

}
