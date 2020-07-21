package vending;

import java.util.Scanner;

public class method_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true){
			String drink = "";
			Scanner scan = new Scanner(System.in);
			int money = inputMoney(0);
			if(money > 100){
				System.out.println("Select drink ");
				drink = scan.next();
			}else{
				System.out.println("Input money: ");
				inputMoney(money);
			}
			System.out.println("drink: " + drink);
		}
	}
	static int inputMoney(int money){
		Scanner scan = new Scanner(System.in);
		System.out.println("Input money: ");
		int inputMoney = scan.nextInt();
		money += inputMoney;
		return money;
	}
}
