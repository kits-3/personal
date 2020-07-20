package vendingmachine;

import java.util.Scanner;

public class vendingchine {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("input money:");
		int a = scan.nextInt();
		
		int b = 10;// b min price product
		int c = 10,d = 15, e = 20;// price product
		if(a >= b) {
			System.out.print("input your product(c,d,e)");
			int f = scan.nextInt();
			a = a - f;
//			if ( a >= 0) {
				System.out.println(" your product");
				System.out.println(" your money:" + a);
//				}
//			else {
//				System.out.print(" input again");
				
			}
				
		
//			if (a >= 0) {
//			
//				}
//		}
////			else if {
//				System.out.println(" you dont enough money");
//				}
		else  {
			System.out.println(" you dont enough money");
			System.out.print(" your money:" + a);
			return;
			}
		
		
	}	
}