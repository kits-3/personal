package ocm.javalec.varex;

import java.util.Scanner;

public class VarEx {
	public static final int orangejuice = 12000;
	public static final int lemonjuice = 10000;
	
	public static void main(String[] args) {
		System.out.print("Input your money: ");
		Scanner scanner = new Scanner(System.in);
		int myMoney = scanner.nextInt();
		boolean status = true;
		inner:
		while(status == true) {
			if (myMoney < lemonjuice) {
				System.out.print("Your money is very low. Do you want to continue? (Y/N)");
				String choose = scanner.next();
				if (choose.equals("Y") || choose.equals("y")) {
					System.out.println("Now. Your money has value: " + myMoney);
					System.out.print("Input your money: ");
					myMoney = myMoney + scanner.nextInt();
					status = true;
				} else {
					System.out.println("Good bye. See you again");
					status = false;
				}
			} else {
				System.out.println("Now. Your money has value: " + myMoney);
				System.out.println("==========================");
				System.out.println("1. Orangejuice: " + orangejuice);
				System.out.println("2. Lemonjuice: " + lemonjuice);
				System.out.println("Do you like ? (1/2)");
				int youChoose = scanner.nextInt();
				switch(youChoose) {
				case 1:
					if (myMoney < orangejuice) {
						System.out.println("Your money is not enough to buy orangejuice. Do you want to input your money ? (Y/N)");
						String choose = scanner.next();
						if (choose.equals("Y") || choose.equals("y")) {
							System.out.println("Now. Your money has value: " + myMoney);
							System.out.print("Input your money: ");
							myMoney = myMoney + scanner.nextInt();
							status = true;
							continue inner;
						} else {
							status = false;
							break;
						}
					} else {
						System.out.println("You bought a can of orange juice");
						myMoney = myMoney - orangejuice;
						System.out.println("Now. Your money has value: " + myMoney);
						break;
					}
				case 2:
						System.out.println("You bought a can of lemon juice");
						myMoney = myMoney - lemonjuice;
						System.out.println("Now. Your money has value: " + myMoney);
						break;
				default:
					System.out.println("Your product doesn't exist in my list");
					break;
				}
				System.out.print("Thank you. Do you want to continue: (Y/N)");
				String choose = scanner.next();
				if (choose.equals("Y") || choose.equals("y")) {
					status = true;
					continue inner;
				} else {
					System.out.println("Now. Your money has value: " + myMoney);
					System.out.println("Good bye. See you again");
					status = false;
				}
			}
		}
	}
}
