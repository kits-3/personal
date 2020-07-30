package vending;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingDrink implements Vending{
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void showProduct() {
		// TODO Auto-generated method stub
		System.out.println("Your select product: ");
		System.out.println("1. Coca");
		System.out.println("2. Beer");
		System.out.println("3. Milk");
	}

	

	@Override
	public boolean checkMoney(int money) {
		// TODO Auto-generated method stub
		int mincost = 10;
		if ( money < mincost) {
			System.out.println("You haven't enough money");
			return false;
		}
		else {
			return true;
		}
		
	}



	@Override
	public boolean checkMore() {
		// TODO Auto-generated method stub
		System.out.println("Want select products? 'y' or 'n' ?");
		System.out.print("Your choose: ");
		String select = sc.next();
		if(select.equals("y")) {
			return true;
		}
		return false;
	}



	@Override
	public int inputMoney(int money) {
		// TODO Auto-generated method stub
		System.out.print("input money: ");
		money += sc.nextInt();
		return money;
		
	}
	
	
	
}
