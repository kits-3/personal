package ex1;
import java.util.Scanner;

import ex1.vending_machine1;
import ex1.vending_machine2;
public class maina {
	


	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("choose food or drink ");
		String choose = sc.next();
		if(choose.equals("food")){
			vending_machine1 food = new vending_machine1();
			int money = 0;
			food.vending_machine(money);
		}
		if(choose.equals("drink")){
			vending_machine2 drink = new vending_machine2();
			int money = 0;
			drink.vending_machine(money);
		}
		
		
	}
}
