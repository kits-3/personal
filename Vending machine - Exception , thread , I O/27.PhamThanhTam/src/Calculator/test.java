package Calculator;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int s = 0;
		System.out.println("input number");
		int a = scanner.nextInt();
		System.out.println("input operator");
		String b = scanner.next();
		System.out.println("input number ");
		int c = scanner.nextInt();
		switch (b) {
		case "+":
			s = a + c;
			break;
		case "-":
			s = a - c;
			break;
		case "*":
			s = a * c;
			break;
		case "/":
			s = a / c;
			break;
		case "%":
			s = a + c;
			break;

		default:
			System.out.println("it no operator");
			break;
		}
		String n = "";
		System.out.println("equal: " + s);
		while (!n.equals("=")) {
			System.out.println("what do you want to more? YES or NO");
			String condition = scanner.next();
			
			if (condition.equals("YES")) {
				System.out.println("input operator to continues");
				String k = scanner.next();
				System.out.println("input number to continues");
				int l = scanner.nextInt();
				switch (k) {
				case "+":
					s += l;
					break;
				case "-":
					s -= l;
					break;
				case "*":
					s *= l;
					break;
				case "/":
					s /= l;
					break;
				case "%":
					s %= l;
					break;

				default:
					System.out.println("it no operator");
					break;
				}

			}else {
				n = "=";
			}
			System.out.println("equal: " + s);
		}
	}
	public static void name() {
		
	}

}
