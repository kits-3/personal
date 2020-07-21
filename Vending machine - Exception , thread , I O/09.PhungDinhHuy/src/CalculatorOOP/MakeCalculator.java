package CalculatorOOP;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class MakeCalculator {

		// Update for above now we can use for operator * and /
		public static double realCalculator2() {
			String[] arr_dau = { "+", "-", "*", "/" };
			Scanner sc = new Scanner(System.in);
			String dataInput;
			String operatorInput;

			List<String> list = new ArrayList<String>();

			// add data input into a list
			// idea: save all values into a list, after that we will traverse list if meet
			// *,/,+,- , at position i
			// => we will set value of i-1 equal to value of i-1 + value of i+1
			// after that we remove value of i and i+1 from list
			do {
				// input a number1
				System.out.println("Input number:");
				dataInput = sc.nextLine();
				// add to list number
				list.add(dataInput);

				System.out.println("Input operator:");
				dataInput = sc.nextLine();
				// add to list number
				list.add(dataInput);

			} while (!(dataInput.equals("=")));

			// nhớ bỏ giá trị mảng cuối vì nó là dấu =

			// Xét trường hợp gặp dấu * và /
			boolean isContain = true;
			while (isContain) {
				isContain = false;
				for (int i = 0; i < list.size() - 1; i++) {
					if (list.get(i).equals("*")) {
						list.set(i - 1,
								String.valueOf(Double.parseDouble(list.get(i - 1)) * Double.parseDouble(list.get(i + 1))));
						list.remove(i);
						list.remove(i);
						isContain = true;
						break;
					}

					if (list.get(i).equals("/")) {
						list.set(i - 1,
								String.valueOf(Double.parseDouble(list.get(i - 1)) / Double.parseDouble(list.get(i + 1))));
						list.remove(i);
						list.remove(i);
						isContain = true;
						break;
					}
				}
			}
			
			// Xét trường hợp gặp dấu + và -
			isContain = true;
			while (isContain) {
				isContain = false;

				for (int i = 0; i < list.size() - 1; i++) {
					if (list.get(i).equals("+")) {
						list.set(i - 1,
								String.valueOf(Double.parseDouble(list.get(i - 1)) + Double.parseDouble(list.get(i + 1))));
						list.remove(i);
						list.remove(i);
						isContain = true;
						break;
					}

					if (list.get(i).equals("-")) {
						list.set(i - 1,
								String.valueOf(Double.parseDouble(list.get(i - 1)) - Double.parseDouble(list.get(i + 1))));
						list.remove(i);
						list.remove(i);
						isContain=true;
						break;
					}

				}

			}	

			return Double.parseDouble(list.get(0));
		}

		public static double addNumbers(String a, String b) {
			double a1 = Double.valueOf(a);
			double b1 = Double.valueOf(b);
			return a1 + b1;
		}

		public static double minusNumbers(String a, String b) {
			double a1 = Double.valueOf(a);
			double b1 = Double.valueOf(b);
			return a1 - b1;
		}

		public static double multiplyNumbers(String a, String b) {
			double a1 = Double.valueOf(a);
			double b1 = Double.valueOf(b);
			return a1 * b1;
		}

		public static double divideNumbers(String a, String b) {
			double a1 = Double.valueOf(a);
			double b1 = Double.valueOf(b);
			return a1 / b1;
		}

		public static void main(String[] args) {
//			simpleCalculator();

//			double rs = standardCalculator();
//			System.out.println(rs);

			String str1 = "2 / 2 + 3 * 4 * 9";  // => 109
			String str2 = "2 / 2 + 3 * 4 + 22 / 2 * 9 / 3 + 19 - 22 + 12 * 2"; // => 67
			double rs2 = realCalculator2();
			System.out.println("Result: "+rs2);
			double rs3 = realCalculator2();
			System.out.println("Result: "+rs3);
		}

}
