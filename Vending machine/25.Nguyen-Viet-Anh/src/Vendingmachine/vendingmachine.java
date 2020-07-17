package Vendingmachine;

import java.util.Scanner;

public class Vendingmachine {
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choose;
		int Coca = 10000;
		int _7up = 15000;
		int Hamburger = 20000;
		
		System.out.print("Input Money: ");
		int a = sc.nextInt();
		do {
			
			if ( a >= Coca) {
				System.out.println("--------------------------------------");
				System.out.println("Your money: " + a);
				System.out.println("--------------------------------------");
				System.out.println("1.Coca: 10000");
				System.out.println("2.7up: 15000");
				System.out.println("3.Hamburger: 20000");
				System.out.print("You choose: ");
				int b = sc.nextInt();
				switch(b) {
					case 1:
						System.out.println("--------------------------------------");
						System.out.println("You choose Coca success !");
						System.out.println("Your money: " + (a - Coca));
						a -= Coca;
						break;
					case 2:
						if(a >= _7up) {
							System.out.println("--------------------------------------");
							System.out.println("You choose 7up success !");
							System.out.println("Your money: " + (a - _7up));
							a-= _7up;
							break;
						}
						else
							System.out.println("--------------------------------------");
							System.out.println("Amount is not enough !");
							break;
					case 3:
						if (a >= Hamburger) {
							System.out.println("--------------------------------------");
							System.out.println("You choose Hamburger success !");
							System.out.println("Your money: " + (a - Hamburger));
							a-= Hamburger;
							break;
						}
						else
							System.out.println("--------------------------------------");
							System.out.println("Amount is not enough !");
					default:
						System.out.println("--------------------------------------");
						System.out.println("Not found ~");
						break;
				}
			}
			else {
				System.out.println("--------------------------------------");
				System.out.println("Amount is not enough !");
				System.out.println("You want input Amount ?");
				System.out.println("1.Yes");
				System.out.println("2.No");
				System.out.print("Choose: ");
				choose = sc.nextInt();
				sc.nextLine();
				switch(choose) {
				case 1:
					System.out.println("--------------------------------------");
					System.out.print("You add Amount: ");
					int c = sc.nextInt();
					a += c;
					break;
				case 2:
					System.out.println("--------------------------------------");
					System.out.println("Your amount: " + a);
					break;
				default:
					System.out.println("--------------------------------------");
					System.out.println("Not found ~");
					break;
				}
			}
			
			System.out.println("--------------------------------------");
			System.out.println("You want get Drink ?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			System.out.print("You choose: ");
			choose = sc.nextInt();
			sc.nextLine();
		}while(choose == 1);
		System.out.println("--------------------------------------");
		System.out.println("Your Money: " + a);
		
	}
		
		
		
}
