import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please input");

		float a = Float.parseFloat((scanner.nextLine()));
		String operator = scanner.nextLine();
		float b = Float.parseFloat(scanner.nextLine());
		float result = 0;
		
		
		if (operator.equals("+")) {
			result = a + b;
		}
		
		if (operator.equals("-")) {
			result = a - b;
		}
		
		if (operator.equals("*")) {
			result = a * b;
		}
		
		if (operator.equals("/")) {
			result = a / b;
		}
		
		operator = scanner.nextLine();
		
		while(!operator.equals("=")) {
			b = Integer.parseInt(scanner.nextLine());
			
//			Switch case
			
//			switch(operator) {
//			case "+":
//				result = result + b;
//				break;
//			case "-":
//				result = result - b;
//				....
//			}
			if (operator.equals("+")) {
				result = result + b;
			} 
			
			if (operator.equals("-")) {
				result = result - b;
			} 
			
			if (operator.equals("*")) {
				result = result * b;
			} 
			
			if (operator.equals("/")) {
				result = result / b;
			} 
			
			operator = scanner.nextLine();
			
		}
		
		System.out.println(result);
		
 
		
		scanner.close();
	}

}
