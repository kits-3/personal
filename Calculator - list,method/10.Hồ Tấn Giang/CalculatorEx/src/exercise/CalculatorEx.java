package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorEx {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("First number: ");
		int n1 = sc.nextInt();
		List<String> operators = new ArrayList<String>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
		String operator = "";
		boolean flag = true;
		while (flag) {
			System.out.print("Operator: ");
			operator = sc.next();
			for (int i = 0; i < operators.size();i++) {
				if (operator.equals(operators.get(i))) {
					flag = false;
					break;
				}
			}
			if(flag) System.out.println("not operator!");
		}
		System.out.println("Operator: " + operator);
		System.out.print("Second number: ");
		int n2 = sc.nextInt();
		String equal;
		while (true) {
			System.out.print("Equal: ");
			equal = sc.next();
			if (equal.equals("="))
				break;
			System.out.println("not valid");
		}
		result(n1, n2, operator);

		sc.close();
	}

	public static void result(int n1, int n2, String operator) {
		switch (operator) {
		case "+":
			System.out.println("Result: " + n1 + " + " + n2 + " = " + (n1 + n2));
			break;
		case "-":
			System.out.println("Result: " + n1 + " - " + n2 + " = " + (n1 - n2));
			break;
		case "*":
			System.out.println("Result: " + n1 + " * " + n2 + " = " + (n1 * n2));
			break;
		case "/":
			if (n2 == 0) {
				System.out.println("Not divide by zero");
			} else {
				System.out.println("Result: " + n1 + " / " + n2 + " = " + (n1 / n2));
			}
			break;
		default:
			break;
		}
	}
}
