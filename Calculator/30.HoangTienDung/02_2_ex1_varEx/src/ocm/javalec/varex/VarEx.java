package ocm.javalec.varex;

import java.util.Scanner;

public class VarEx {
	
	public static void main (String[] args)
	{
		
		
		System.out.println("Input number1: ");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		System.out.println("Input operator: ");
		String b = scan.next();
		
			System.out.println("Input number2: ");
			int c = scan.nextInt();
			scan.close();
				
			switch (b) {
			case "+":
				System.out.println(a+c);
				break;
			case "-":
				System.out.println(a-c);
				break;
			case "*":
				System.out.println(a*c);
				break;
			case "/":
				System.out.println(a/c);
				break;
			
			}
			
		


	}
}
