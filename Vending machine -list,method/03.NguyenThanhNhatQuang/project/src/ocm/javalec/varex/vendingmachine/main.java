package ocm.javalec.varex.vendingmachine;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Select Machine: \n1.Machine Drink\n2.Machine Food\n3.Machine Snake ");
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
