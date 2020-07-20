package com.javalec.make_calculator;

import java.util.Scanner;

public class MakeCalculator {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double numberOne = 0.0;
		double numberTwo = 0.0;
		char operator = 0;
		char equal = 0;
//		String stop = "=";
		boolean runNext = true;
		double result = 0.0;
		double total = 0.0;
		
		while (runNext == true) {
			System.out.println("Please enter first number");
			numberOne = sc.nextDouble();
			System.out.println("Please enter second number");
			numberTwo = sc.nextDouble();
			System.out.println("Please select 1 of 4 operation : + - * / ");
			operator = sc.next().charAt(0);
			switch (operator) {
			case '+':
				result = numberOne + numberTwo;
				break;
			case '-':
				result = numberOne - numberTwo;
				break;
			case '*':
				result = numberOne * numberTwo;
				break;
			case '/':
				result = numberOne / numberTwo;
				break;

			default:
				System.out.println("not found operator");
				break;
			}
			System.out.println("Please enter key word = to seen result or t to continue operator next ");
			equal = sc.next().charAt(0);
			switch (equal) {
			case '=':
				runNext = false;
				total += result;
				System.out.println(numberOne + " " + operator + " " + numberTwo + " " + "= " + result);
				System.out.println("total current : " + total);
				break;
			case 't':
				System.out.println("enter key t to continue and enter number " );				
				total = total + result;
				runNext = true;
				System.out.println("total current : " + total);
				break;
			default:
				System.out.println(" to continue . . . ");
				runNext = true;
				break;
			}
			
		}

	}

}