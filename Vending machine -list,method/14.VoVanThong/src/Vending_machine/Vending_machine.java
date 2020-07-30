package Vending_machine;

import java.util.Scanner;

public class Vending_machine {
	static Scanner money=new Scanner(System.in);
	static int sc;
	static String sl;
	public static void main(String[] args) {
		
		do {
			System.out.print("Insert Money(USD):" );
		  sc=money.nextInt();
		}while ( sc%10 !=0);
		int coin=sc;
     do {
    	 String[] array = {"coca 10$","soju 20$","heneiken 30$"};
    	
    	 for (int i = 0; i < array.length; i++) {
    		 System.out.println("Please pick your choice: " +array[i] );
		}
    	 
    	  sl=money.next();
			if(sl.equals("coca")) {
				 coin = changecoin(coin,sc,sl,money);
				if(coin>=0) {
					if(coin==0) {
					System.out.println("Coca of you in here.Thank you!" );
					}
					else {
						System.out.println("Coca of you in here and your money:" +coin +"$");
						System.out.println("Do you want to buy again?" + "Yes/No" );
						sl=money.next();
					}
				}
				else {
					 System.out.println("Please input more money" );
				}
			}																												//Coca
			else if(sl.equals("soju")) {
				 coin = changecoin(coin,sc,sl,money);
				if(coin>=0) {
					if(coin==0) {
					System.out.println("Soju of you in here.Thank you!" );
					}
					else {
						System.out.println("Soju of you in here and your money:" +coin +"$");
						System.out.println("Do you want to buy again?" + "Yes/No" );
						sl=money.next();
					}
				}
				else {
					 System.out.println("Please input more money" );
				}
			}																																		//Soju
			else if(sl.equals("heneiken")) {
				 coin = changecoin(coin,sc,sl,money);
				if(coin>=0) {
					if(coin==0) {
					System.out.println("Heneiken of you in here.Thank you!" );
					}
					else {
						System.out.println("Heneiken of you in here and your money:" +coin +"$");
						System.out.println("Do you want to buy again?" + "Yes/No" );
						sl=money.next();
					}
				}
				else {
					 System.out.println("Please input more money" );
				}
			}																						
     }while(sl.equals("yes"));
     
     }
	public static int changecoin(int coin, int sc,String sl , Scanner scanner) {
		 do {
		if(sl.equals("coca")){
			sc=coin;
			coin=sc-10;
		}
		else if(sl.equals("soju")){
			sc=coin;
			coin=sc-20;
		}
		else if(sl.equals("heneiken")){
			sc=coin;
			coin=sc-30;
		}
		}while(sl.equals("yes"));
			return coin ;
	}
}
