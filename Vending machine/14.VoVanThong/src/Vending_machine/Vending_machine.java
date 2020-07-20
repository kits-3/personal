package Vending_machine;

import java.util.Scanner;

public class Vending_machine {
	static Scanner money=new Scanner(System.in);
	static int sc;
	static String sl;
	public static void main(String[] args) {
		int coin;
		do {
			System.out.print("Insert Money(USD):" );
		  sc=money.nextInt();
		}while ( sc%10 !=0);
		
     do {
    	 System.out.println("Please pick your choice: Coca:10$  Soju:20$ Heneiken:30$");
    	 	sl=money.next();
			if(sl.equals("coca")) {
				coin=sc;
				sc=sc-10;
				if(sc>=0) {
					if(coin==0) {
					System.out.println("Coca of you in here.Thank you!" );
					}
					else {
						System.out.println("Coca of you in here and your money:" +sc +"$");
						System.out.println("Do you want to buy again?" + "Yes/No" );
						sl=money.next();
					}
				}
				else {
					 System.out.println("Please input more money" );
				}
			}																												//Coca
			else if(sl.equals("soju")) {
				coin=sc;
				sc=sc-20;
				if(sc>=0) {
					if(coin==0) {
					System.out.println("Soju of you in here.Thank you!" );
					}
					else {
						System.out.println("Soju of you in here and your money:" +sc +"$");
						System.out.println("Do you want to buy again?" + "Yes/No" );
						sl=money.next();
					}
				}
				else {
					 System.out.println("Please input more money" );
				}
			}																														//Soju
			else if(sl.equals("heneiken")) {
				coin=sc;
				sc=sc-30;
				if(sc>=0) {
					if(coin==0) {
					System.out.println("Heneiken of you in here.Thank you!" );
					}
					else {
						System.out.println("Heneiken of you in here and your money:" +sc +"$");
						System.out.println("Do you want to buy again?" + "Yes/No" );
						sl=money.next();
					}
				}
				else {
					 System.out.println("Please input more money" );
				}
			}										
     }while(sl.equals("yes"));
     
//		}while()
//	select soju first
		
     }
	}
