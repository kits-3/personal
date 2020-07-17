package com.javalec.ifEx;

import java.util.Scanner;

public class IfEx {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("a = ");
		float a = scanner.nextInt();
		System.out.print("b = ");
		float b = scanner.nextInt();

		System.out.print("Input cal: ");
		String c = scanner.next();
		switch (c) {
		case "+":
			System.out.printf("%.2f %s %.2f = %.2f",a ,c, b, a+b);
			break;
		case "-":
			System.out.printf("%.2f %s %.2f = %.2f",a ,c, b, a-b);
			break;
		case "*":
			System.out.printf("%.2f %s %.2f = %.2f",a ,c, b, a*b);
			break;
		case "/":
			System.out.printf("%.2f %s %.2f = %.2f",a ,c, b, a/b);
			break;
		case "%":
			System.out.printf("%.2f %s %.2f = %.2f",a ,c , b, a%b);
			break;

		default:
			break;
		}
		
		scanner.close();
	}
}
