package VendingMachine;

import java.util.Scanner;

public class VendingMachine {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int a;
		
		System.out.print("Please insert money: ");
		a = sc.nextInt();
		int minCost =10000;
		boolean status = true;
		inner:
		while(status) {
			if (a < minCost) {
				System.out.println("Your money isn't enough" );
				System.out.println("Do you want to recive money? Y/N");
				String y = sc.next();
				if(y.equals("Y") || y.equals("y")) { 
					System.out.print("See you later");
					status = false;
					break;
				} else {
					System.out.print("Please insert money: ");
					a = a + sc.nextInt();
					status = true;
					if (a < minCost) {
						continue inner;
					}
				}
				
			} 
		
		else {
			System.out.println("Select your option ");
			System.out.println("1.Soda\n2.Soju\n3.Apple Juice");
			System.out.println("Your choose is: ");
			
				int b = sc.nextInt();
				int sodaPrice = 10000;
				int sojuPrice=20000;
				int apPrice=20000;
				
				switch(b) {
			
				case 1:
					System.out.println("Price is: " + sodaPrice + "VND ");
					status = false;
					
					break;
				case 2:
					System.out.println("Price is: " + apPrice + "VND");
					status = false;
					 if( a<apPrice)
					 {
						 int moInsert ;
						 moInsert=apPrice - a;
						 System.out.println("You need more: " + moInsert+"VND" );
						 System.out.println("Do you want to recive money? Y/N");
						 String y = sc.next();
						 if(y.equals("Y") || y.equals("y")) { 
								System.out.println("See you later");
								status = false;
								break;
							} else {
								System.out.println("Please insert money: ");
								a = a + sc.nextInt();
								status = true;
								if (a < minCost) {
									continue inner;
								}
							}
					
					 }
					 status=false;
						System.out.println("Here you are");
						System.out.println("Do you want to buy another product? Y/N?");
						String y = sc.next();
					break;
			
				
				case 3:
					System.out.println("Price is: " + sojuPrice + "VND");
					status = false;
					 if( a<sojuPrice)
					 {
						 int moInsert ;
						 moInsert=sojuPrice - a;
						 System.out.println("You need more: " + moInsert+"VND" );
						 System.out.println("Do you want to recive money? Y/N");
						  y = sc.next();
						 if(y.equals("Y") || y.equals("y")) { 
								System.out.println("See you later");
								status = false;
								break;
							} else {
								System.out.println("Please insert money: ");
								a = a + sc.nextInt();
								status = true;
								if (a < minCost) {
									continue inner;
								}
							}
					
					 }
					 status=false;
						System.out.println("Here you are");
						System.out.println("Do you want to buy another product? Y/N?");
						 y = sc.next();
					break;
					
					 	
				}
				
				
			}
			
		}
	
		
	}
}
		
		
		
		
			
		
		

	


