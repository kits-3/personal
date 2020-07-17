package vending_machine;

import java.util.Scanner;

public class vending_machine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= new int[5];
		arr[0] = 10000; //coca (VND)
		arr[1] = 20000; //sprite (VND)
		arr[2] = 15000; //pepsi (VND)
		arr[3] = 30000; //redbull (VND)
		arr[4] = 5000; //water (VND)
		int minCost = arr[4];
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Money: ");
		int a = input.nextInt();
		
		if(a >= minCost) {		
			System.out.println("Your money is: "+ a + " VND");
			System.out.println("--Chose product--");
			System.out.println("1.Coca(10000 VND)   2.sprite(20000 VND)    3.Pepsi(15000 VND)    4.Redbull(30000 VND)    5.Water(5000 VND)");
			Scanner input2 = new Scanner(System.in);
			int b = input2.nextInt();
			switch (b) {
				case 1:
					if(a >= arr[0] ) {	
						int q = a-arr[0];
						System.out.println("excess cash: "+ q);
						System.out.println("your product Coca");
//						System.out.println("you want to more? 1.yes  2.no" );
					}else {
						
						System.out.println("your money price lower product price. Please get more money !");
						Scanner input5 = new Scanner(System.in);
						int h = input5.nextInt();
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
					if(a >= arr[1]) {
						int w = a-arr[1];
						System.out.println("excess cash: "+ w);
						System.out.println("your product Sprite");
//						System.out.println("you want to more? 1.yes  2.no" );
					}else {
						System.out.println("your money price lower product price. Please get more money or !");
						System.out.println("1.give your excess cash  2.Please get more money!");
						Scanner input5 = new Scanner(System.in);
						int g = input5.nextInt();
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
					if(a >= arr[2]) {
						int e = a-arr[2];
						System.out.println("excess cash: "+ e);
						System.out.println("your product Pepsi");
//						System.out.println("you want to more? 1.yes  2.no" );
					}else {
						System.out.println("your money price lower product price. Please get more money !");
						Scanner input5 = new Scanner(System.in);
						int j = input5.nextInt();
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
					if(a >= arr[3]) {
						int r = a-arr[3];
						System.out.println("excess casha: "+ r);
						System.out.println("your product Redbull");
//						System.out.println("you want to more? 1.yes  2.no" );
					}else {
						System.out.println("your money price lower product price. Please get more money !");
						Scanner input5 = new Scanner(System.in);
						int k = input5.nextInt();
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
				case 5:
					if(a >= arr[4]) {
						int t = a-arr[4];
						System.out.println("excess cash: "+ t);
						System.out.println("your product Water");
//						System.out.println("you want to more? 1.yes  2.no" );
					}else {
						System.out.println("your money price lower product price. Please get more money !");
						Scanner input5 = new Scanner(System.in);
						int l = input5.nextInt();
						switch (l) {
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
			System.out.println("your money price lower product price. Please get more money !");
			System.out.println("Enter money less 5000 VND");
			System.out.print("Enter Money: ");
			Scanner input4 = new Scanner(System.in);
			int d = input4.nextInt();
			int f = a + d;
			System.out.println("current money: "+ f);
		}
	}
}
