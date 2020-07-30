package VendingMachine;
import java.util.Scanner;

public class SimpleCalculator {

	public static int add(int num1, int num2){
		return num1 + num2;
	}
	
	public static int subtract(int num1, int num2){
		return num1 - num2;
	}
	
	public static int multiple(int num1, int num2){
		return num1 * num2;
	}
	
	public static int divide(int num1, int num2){
		return num1/num2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputList = {0, 0};
		int sum = 0;
		String operator = "";
		Scanner scanner = null;
		String option = "";
		
		while(true){
			scanner = new Scanner(System.in);
			for (int i=0; i < 2; ++i){
				System.out.print("Num " + (i+1) + ": ");
				inputList[i] = scanner.nextInt();
			}
			System.out.print("Please enter operator (+ - * /): ");
			operator = scanner.next();
			
			switch (operator) {
			case "+":
				sum = add(inputList[0], inputList[1]);
				break;
			case "-":
				sum = subtract(inputList[0], inputList[1]);
				break;
			case "*":
				sum = multiple(inputList[0], inputList[1]);
				break;
			case "/":
				sum = divide(inputList[0], inputList[1]);
				break;
			default:
				System.out.println("Out of scope");
				break;
			}
			System.out.println("Result is: " + sum);
			System.out.print("Do you want to continue (Y/N): " );
			option = scanner.next().toUpperCase();
			if (option.equals("Y")){
				
			}else{
				System.out.println("GOOD BYE.");
				scanner.close();
				break;
			}
		}
	}
}
