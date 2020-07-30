package atm.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		boolean check = true;
		while(check) {
			
			int n = 0;
			while(n < 1 || n > 2) {
				try {
					Scanner scan = new Scanner(System.in);
					System.out.println("------------------------------");
					System.out.println("1. ATM");
					System.out.println("2. Panel");
					System.out.print("Select: ");
					n = scan.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Error: Input number (1 - 2)!!");
				}
			}
			if(n == 1) {
				ATM atm = new ATM();
				check = atm.getATM();
			} else {
				Panel pa = new Panel();
				check = pa.getPanel();
			}
			
		}
	}
}
