package vendingMachine;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vendingMachine {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int money = 0;
		int tienbandau = 0;
		boolean isNumber = true; 
		String cf; 
		objVendingMachine obj = new objVendingMachine();
		
		List<String> arrDrink = new ArrayList<>();
		
		money = obj.inputMoney(money, isNumber, sc);
	 
		do {
			System.out.print("you wants to buy: 1.coca(10VND) / 2.pessi(20VND) / 3.milk(30VND): ");
			int lc = sc.nextInt();
			if(lc == 1) {
				tienbandau = money;
				money = money - 10;
				 arrDrink.add("coca");
				if(money >= 0) {
					System.out.println("excess cash: " + money + "VND");
				}else if(money < 0) {
					arrDrink.remove(arrDrink.size() - 1);
					System.out.println("amount to pay: " + money + "VND" + " please add money");
					System.out.println("get money back: " + tienbandau + "VND" );
					for (int i = 0; i < arrDrink.size(); i++) {
							System.out.println("You have bought: " + arrDrink.get(i));
						}
					return;
				}
			}else if(lc == 2) {
				tienbandau = money;
				money -= 20;
				 arrDrink.add("pessi");
				if(money >= 0) {
					System.out.println("excess cash: " + money + "VND");
				}else if(money < 0) {
					arrDrink.remove(arrDrink.size() - 1);
					System.out.println("amount to pay: " + money + "VND" + " please add money");
					System.out.println("get money back: " + tienbandau + "VND" );
					for (int i = 0; i < arrDrink.size(); i++) {
							System.out.println("You have bought: " + arrDrink.get(i));
						}
					return;
				}
			}else if(lc == 3) {
				tienbandau = money;
				money -=30;
				 arrDrink.add("milk");
				if(money >= 0) {
					System.out.println("excess cash: " + money + "VND");
				}else if(money < 0) {
					arrDrink.remove(arrDrink.size() - 1);
					System.out.println("amount to pay: " + money + "VND" + "  please add money");
					System.out.println("get money back: " + tienbandau + "VND" );
					for (int i = 0; i < arrDrink.size(); i++) {
							System.out.println("You have bought: " + arrDrink.get(i));
						}
					return;
				}
			}else {
				System.out.println("We do not have  of this drink !");
				break;
			}
			System.out.println("You continue to buy Y/N ?");
			cf = sc.next();
		} while (cf.equalsIgnoreCase("Y"));
		if(money > 0) {
			System.out.println("get money back: " + money + "VND");
			 if(arrDrink.size() > 0) {
				 for (int i = 0; i < arrDrink.size(); i++) {
					System.out.println("You have bought: " + arrDrink.get(i));
				}
				 return;
			 }else {
				 return;
			 }
		}else {
			 if(arrDrink.size() > 0) {
				 for (int i = 0; i < arrDrink.size(); i++) {
					System.out.println("You have bought: " + arrDrink.get(i));
				}
				 return;
			 }else {
				 System.out.print("See you again!");
				 return;
			 }
		}
	}
	 

}
