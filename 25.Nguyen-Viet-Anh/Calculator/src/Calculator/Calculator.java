package Caculator;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		float num1, num2;
		String pt;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhap a: ");
		num1 = sc.nextFloat();
		System.out.print("Nhap b: ");
		num2 = sc.nextFloat();
		System.out.print("Nhap phep tinh: ");
		pt = sc.next();
		
		
		
		switch (pt) {
			case "+":
				System.out.println("KQ:  " + (num1 + num2));
				break;
			case "-":
				System.out.println("KQ: " + (num1 - num2));
				break;
			case "*":
				System.out.println("KQ: " + (num1 * num2));
				break;
			case "/":
				if (num2 == 0) {
					System.out.println("Not found !");
					break;
				}
				else
					System.out.println("KQ: " + (num1 / num2));
					break;
			default:
				System.out.println("Not found !");
				break;
		}
		
		
	}
}
