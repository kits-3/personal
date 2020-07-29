package vending;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = 0;
		String[] Drink = {"Coca", "Beer", "Milk"};
		int[] drinkPrice = {10,15,20};
		Vending venD = new VendingDrink();
		
		System.out.print("input money: ");
		money += sc.nextInt();
		
		while(venD.checkMore()) {
			if(venD.checkMoney(money)) {
				venD.showProduct();
				System.out.println("Your money: " + money);
				System.out.print("Your choose: ");
				int choose = sc.nextInt();
				switch(choose) {
				case 1:
					if(money >= drinkPrice[0]) {
						money -= drinkPrice[0];
						System.out.println("Your have: " + Drink[0]);
						System.out.println("Your money: " + money);
						break;
					}
					else {
						System.out.println("You haven't enough money");
						venD.inputMoney(money);
						money += venD.inputMoney(money);
						System.out.println("Your money: " + money);
						break;
					}
				case 2:
					if(money >= drinkPrice[1]) {
						money -= drinkPrice[1];
						System.out.println("Your have: " + Drink[1]);
						break;
					}
					else {
						System.out.println("You haven't enough money");
						venD.inputMoney(money);
						money += venD.inputMoney(money);
						break;
					}
				case 3:
					if(money >= drinkPrice[2]) {
						money -= drinkPrice[2];
						System.out.println("Your have: " + Drink[2]);
						System.out.println("Your money: " + money);
						break;
					}
					else {
						System.out.println("You haven't enough money");
						venD.inputMoney(money);
						money += venD.inputMoney(money);
						break;
					}
				}
			}
			else {
				System.out.print("input money: ");
				money += sc.nextInt();
				System.out.println("Your money: " + money);
			}
		}
		
		
	}
}
