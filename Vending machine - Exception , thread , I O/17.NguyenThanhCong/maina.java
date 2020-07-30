package ex1;
import java.util.Scanner;

//import ex1.vending_machine1;
//import ex1.vending_machine2;//
public class maina extends vendingmachine implements ChooseProduct{
	


	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Drink vending machine: press1, Food vending machine: press 2, Gift vending machine: press 3");
		String choose = sc.next();
		if(choose.equals("1")){
			vending_machine1 food = new vending_machine1();
			food.name_price();
			int money = 0;
		
			
			food.vending_machine(money);
			stop stop1 = new stop();
		}
		if(choose.equals("2")){
			vending_machine2 drink = new vending_machine2();
			drink.name_price();
			int money = 0;
		
			
			drink.vending_machine(money);
			stop stop1 = new stop();
			
		}
		if(choose.equals("3")){
			vending_machine3 gift = new vending_machine3();
			gift.name_price();
			int money = 0;
		
			
			gift.vending_machine(money);
			stop stop1 = new stop();
			
		}
		
		
	}
}
