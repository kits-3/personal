package com.javalec.forEx;

import java.util.ArrayList;
import java.util.Scanner;


public class ForEx {

	public static void main(String[] args) {
		ArrayList<Product> arrProducts = new ArrayList<Product>();
		arrProducts.add(new Product(0,"coca", 10000));
		arrProducts.add(new Product(1,"pepsi", 20000));
		arrProducts.add(new Product(2,"aquafina", 5000));
		int minPrice = arrProducts.get(0).getPrice();
		for(int i = 0;i<arrProducts.size();i++) {
			if(minPrice > arrProducts.get(i).getPrice()) {
				minPrice = arrProducts.get(i).getPrice();
			}
		}
		for(int i = 0;i<arrProducts.size();i++) {
			System.out.println(arrProducts.get(i).getName()+". Price: "+arrProducts.get(i).getPrice()+". ID: "+i);
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input money: ");
		int inputMoney = scanner.nextInt();
//		System.out.println(minPrice);
		int condition = 0;
		
		if(minPrice > inputMoney) {
			condition = 1;
		}
		while (condition == 1) {
			System.out.println("==========================");
			System.out.println("Input 0 to finish");
			System.out.println("Input money again: ");
				inputMoney = scanner.nextInt();
			if(inputMoney > minPrice) {
				condition = 0;
			}
			if(inputMoney == 0) {
				return;
			}
		}
		
		int transaction = 1;
		while (transaction > 0) {
			System.out.println("================================================================");
			System.out.println("Please choose your drink with compatible number: ");
			int num = scanner.nextInt();
			for(int i = 0;i<arrProducts.size();i++) {
				if(num == arrProducts.get(i).getId()) {
					
					if(inputMoney >= arrProducts.get(i).getPrice()) {
						inputMoney -= arrProducts.get(i).getPrice();
						System.out.printf("Your change is %d will return in a second...",inputMoney);
						System.out.println();
						System.out.println("Your "+arrProducts.get(i).getName()+" will return in a second!");
					}
					else if (inputMoney < minPrice) {
						System.out.println("You dont have enough money to pay more");
						return;
					}
				}
			}
			System.out.println("Continue buying? (input 1 for YES, 0 for NO): ");
			int b  = scanner.nextInt();
			if(b == 1) {
				transaction = 1;
			}{
				System.out.println("================================");
				System.out.println("Thank you for using our machine!");
				return;
			}
		}
		scanner.close();
		
	}
	
}

