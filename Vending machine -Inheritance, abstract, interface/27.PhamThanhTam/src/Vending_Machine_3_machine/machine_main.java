package Vending_Machine_3_machine;

import java.util.Scanner;

public class machine_main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("order machine: 1-drink 2-food 3-computer");
		System.out.println("choose: 1 2 or 3");
		int key = scan.nextInt();
		switch (key) {
		case 1:
			machine_drink_food__computer drink = new machine_drink_food__computer("coffee","milk", "juice", 100, 200, 300);
			break;
		case 2:
			machine_drink_food__computer food = new machine_drink_food__computer("FOOD_1","FOOD_2", "FOOD_3", 1000, 2000, 3000);
		break;
		case 3:
			machine_drink_food__computer computer = new machine_drink_food__computer("COMPUTER_E","COMPUTER_D", "COMPUTER_F", 10, 20, 30);
		break;
		default:
			break;
		}
	}

}
