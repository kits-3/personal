package vending_machine;

import java.util.Scanner;

public class vending_machine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 10000; //coca (VND)
		int n = 20000; //sprite (VND)
		int b =  5000; //pepsi (VND)
		int l = 30000; //redbull (VND)
		int minCost = b;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Money: ");
		int a = input.nextInt();
		
		
		
		if(a >= minCost) {		
			System.out.println("Your money is: "+ a + " VND");
			System.out.println("--Chose product--");
			System.out.println("1.Coca(10000 VND)   2.sprite(20000 VND)    3.Pepsi(15000 VND)    4.Redbull(30000 VND)    5.Water(5000 VND)");
			Scanner input2 = new Scanner(System.in);
			int d = input2.nextInt();
			switch (d) {
				case 1:
					if(a >= m ) {	
						int q = a-m;
						System.out.println("excess cash: "+ q);
						System.out.println("your product Coca");
						System.out.println("you want to more? 1.yes  2.no" );
						int moreMoney = input.nextInt();
						
						int currentMoney = 0;
							currentMoney += moreMoney;
						
					}else {
						
						System.out.println("your money price lower product price. Please get more money !");
						int h = input.nextInt();
						switch (h) {
						case 1:
							System.out.println("give your excess cash");
							break;
						case 2:
							System.out.println("Please get more money!");
							break;

						default:
							break;
						}
					}
					break;
				case 2:
					if(a >= n) {
						int w = a-n;
						System.out.println("excess cash: "+ w);
						System.out.println("your product Sprite");
						System.out.println("you want to more? 1.yes  2.no" );
					}else {
						System.out.println("your money price lower product price. Please get more money or !");
						System.out.println("1.give your excess cash  2.Please get more money!");
						int g = input.nextInt();
						switch (g) {
						case 1:
							System.out.println("give your excess cash");
							break;
						case 2:
							System.out.println("Please get more money!");
							break;

						default:
							break;
						}
					}
					break;
				case 3:
					if(a >= b) {
						int e = a-b;
						System.out.println("excess cash: "+ e);
						System.out.println("your product Pepsi");
						System.out.println("you want to more? 1.yes  2.no" );
					}else {
						System.out.println("your money price lower product price. Please get more money !");
						int j = input.nextInt();
						switch (j) {
						case 1:
							System.out.println("give your excess cash");
							break;
						case 2:
							System.out.println("Please get more money!");
							break;

						default:
							break;
						}
					}
					
					break;
				case 4:
					if(a >= l) {
						int r = l;
						System.out.println("excess casha: "+ r);
						System.out.println("your product Redbull");
						System.out.println("you want to more? 1.yes  2.no" );
					}else {
						System.out.println("your money price lower product price. Please get more money !");
						int k = input.nextInt();
						switch (k) {
						case 1:
							System.out.println("give your excess cash");
							break;
						case 2:
							System.out.println("Please get more money!");
							break;

						default:
							break;
						}
					}				
					break;
				default:
					System.out.println("--None Pruduct--");
			}
		}else {
			while (a < minCost) {
				System.out.println("your money: "+ a +"VND");
				System.out.println("you want to more? please ");
				int checkString = input.nextInt();
			}
		}
		
//		
	}
}
