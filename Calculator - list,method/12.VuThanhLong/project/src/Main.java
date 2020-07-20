import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Please input");

		int a = Integer.parseInt((scanner.nextLine()));
		String operator = scanner.nextLine();
		int b = Integer.parseInt(scanner.nextLine());
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

		while (!operator.equals("=")) {

			b = Integer.parseInt(scanner.nextLine());

			result = doMath(operator, result, b);

			operator = scanner.nextLine();
		}

		System.out.println(result);

		scanner.close();
	}
	public static float doMath(String operator, float result, int b) {
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
		return result;
	}
}
