package exercise;

import java.util.Scanner;

public class CalculatorEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("First number: ");
		int n1 = sc.nextInt();
		String symbol;
		while(true) {
			symbol = sc.next();
			if(symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/")) break;
			System.out.println("not operator!");
		}
		System.out.println("Operator: " + symbol);
		System.out.print("Second number: ");
		int n2 = sc.nextInt();
		String symbol2;
		while(true) {
			symbol2 = sc.next();
			if(symbol2.equals("=")) break;
			System.out.println("not valid");
		}
		switch (symbol) {
		case "+":
			System.out.println("Result: "+ n1 + " + " + n2+ " = " +  (n1+n2));
			break;
		case "-":
			System.out.println("Result: "+ n1 + " - " + n2+ " = " +  (n1-n2));
			break;
		case "*":
			System.out.println("Result: "+ n1 + " * " + n2+ " = " +  (n1*n2));
			break;
		case "/":
			if(n2 == 0) {
				System.out.println("Not divide by zero");
			}
			else {
				System.out.println("Result: "+ n1 + " / " + n2+ " = " +  (n1/n2));
			}
			break;
		default:
			break;
		}
		
		sc.close();
	}

}
