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
			food.list2.add(20);
			food.list2.add(30);
			food.list2.add(40);
			food.list2.add(10);
			
			food.list3.add("food1");
			food.list3.add("food2");
			food.list3.add("food3");
			food.list3.add("food4");
			int money = 0;
			food.vending_machine(money);
			
			food.vending_machine(money);
		}
		if(choose.equals("drink")){
			vending_machine2 drink = new vending_machine2();
			drink.list2.add(20);
			drink.list2.add(30);
			drink.list2.add(40);
			drink.list2.add(10);
			
			drink.list3.add("drink1");
			drink.list3.add("drink2");
			drink.list3.add("drink3");
			drink.list3.add("drink4");
			int money = 0;
			drink.vending_machine(money);
			
			drink.vending_machine(money);
		}
		
		
	}
}
