package ocm.javalec.varex;

import java.util.Scanner;

public class VarEx {
	public static void main(String[] args) {
		System.out.println("1.coca: 10/ 2.pepsi:12/ 3.fanta: 14/ 4.mirinda: 15");
		System.out.println("----------------------------------------------");
		System.out.print("Input money: ");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int minPrice = 10;
		if (a<minPrice) {
			System.out.print("The min price is 10$. Add money: ");
			int c = scan.nextInt();
			a = a + c;
			System.out.println("Total money: " + a);
		}
		while (a>=10) {
			scan = new Scanner(System.in);
			System.out.print("Select product: ");
			int b = scan.nextInt();
			switch (b) {
			case 1:
			{
				if (a>=10) {
					System.out.println("This is cocacola for you!!!");
					a = a - 10;
					System.out.println("Your charged money: " +a);
				}
				else {
					System.out.println("don't enough money. choice other product or add more money!!!");
				}
			}
			break;
			case 2:
			{
				if (a>=12) {
					System.out.println("This is pepsi for you!!!");
					a = a - 12;
					System.out.println("Your charged money: " +a);
				}
				else {
					System.out.println("don't enough money. choice other product or add more money!!!");
				}
			}
			break;
			case 3:
			{
				if (a>=14) {
					System.out.println("This is fanta for you!!!");
					a = a - 14;
					System.out.println("Your charged money: " +a);
				}
				else {
					System.out.println("don't enough money. choice other product or add more money!!!");
				}
			}
			break;
			case 4:
			{
				if (a>=15) {
					System.out.println("This is mirinda for you!!!");
					a = a - 15;
					System.out.println("Your charged money: " +a);
				}
				else {
					System.out.println("don't enough money. choice other product or add more money!!!");
				}
			}
			break;

			default:
				break;
			}
		}
	}	
}
