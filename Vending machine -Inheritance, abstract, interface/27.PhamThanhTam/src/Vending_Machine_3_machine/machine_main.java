package Vending_Machine_3_machine;

import java.util.Scanner;

public class machine_main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("order machine: 1 2 or 3");
		int key = scan.nextInt();
		switch (key) {
		case 1:
			machine_1_drink drink = new machine_1_drink("coffee","milk", "juice", 100, 200, 300);
			break;
		case 2:
			machine_2_food food = new machine_2_food("FOOD_1","FOOD_2", "FOOD_3", 1000, 2000, 3000);
		break;
		case 3:
			machine_3_computer computer = new machine_3_computer("COMPUTER_E","COMPUTER_D", "COMPUTER_F", 10, 20, 30);
		break;
		default:
			break;
		}
	}

}
