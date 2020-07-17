import java.util.Scanner;

public class ex {

	public static void main(String[] args) {
		int num1, num2;
		String op;
		Scanner sc = new Scanner(System.in);
		System.out.print("Input 1: ");
		num1 = sc.nextInt();
		System.out.print("Input 2: ");
		num2 = sc.nextInt();
		System.out.print("Operator: ");
		op = sc.next();
		int total;
		
			switch (op) {
			
				case "+":
					total = num1 + num2;
					System.out.println(num1 + " + " + num2 + " = " + total);
					break;
				case "-":
					total = num1 - num2;
					System.out.println(num1 + " - " + num2 + " = " + total);
					break;
				case "*":
					total = num1 * num2;
					System.out.println(num1 + " * " + num2 + " = " + total);
					break;
				case "/":
					total = num1 / num2;
					System.out.println(num1 + " / " + num2 + " = " + total);
					break;
				default: 
					System.out.println("Khong co phep toan " + op);
			}

		}



}
