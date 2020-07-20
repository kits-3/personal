package ocm.javalec.varex.vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("select machine 1 2 3 ");
		int key = scan.nextInt();
		switch (key) {
		case 1: {
			new VendingMachineFirst();
			break;
		}
		case 2: {
			
			new VendingMachineSecond();
			break;
		}
		case 3: {
			new VendingMachineThird();
			break;
		}
		default:
			break;
		}

	}

}
