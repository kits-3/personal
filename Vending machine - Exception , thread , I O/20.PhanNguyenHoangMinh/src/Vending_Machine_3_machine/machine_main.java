package Vending_Machine_3_machine;

import java.util.Scanner;

public class machine_main {
	static int money = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("order machine: 1-drink 2-food 3-computer");
		System.out.println("choose: 1 2 or 3");
		int key = scan.nextInt();
		switch (key) {
		case 1:
			 new machine_drink_food__computer("coffee","milk", "juice", 100, 200, 300, money);
			break;
		case 2:
			 new machine_drink_food__computer("chicken","crab", "mouse", 1000, 2000, 3000, money);
		break;
		case 3:
			 new machine_drink_food__computer("asus","dell", "msi", 10, 20, 30,money);
		break;
		default:
			break;
		}
	}

}
