import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class MakeCalculator {

	// Simple calculator
	public static void simpleCalculator() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập số a:");
		String a = sc.next();
		System.out.println("Nhập số b:");
		String b = sc.next();

		System.out.println("Nhập phép toán");
		String dau = sc.next();

		double rs = 0;

		switch (dau) {
		case "+":
			rs = addNumbers(a, b);
			break;
		case "-":
			rs = minusNumbers(a, b);
			break;
		case "*":
			rs = multiplyNumbers(a, b);
			break;
		case "/":
			rs = divideNumbers(a, b);
			break;
		default:
			System.out.println("Bạn ko dc nhập chữ");
			break;
		}
		System.out.println("Kết quả: " + rs);
	}

	// Update calculator can't not input zero value for num1/num2
	public static double standardCalculator() {
		String[] arr_dau = { "+", "-", "*", "/" };
		int[] arr_number = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		String operator = "";

		Scanner sc = new Scanner(System.in);
		String dataInput;
		String dataInput2;

		// Input first number
		do {
			System.out.println("Input number 1st:");
			dataInput = sc.nextLine();
		} while (Double.valueOf(dataInput) == 0);

		// If dataInput!=0 => input operator
		boolean isExisted = false;
		do {
			System.out.println("Input operator");
			operator = sc.nextLine();

			for (int i = 0; i < arr_dau.length; i++) {
				if (operator.equals(arr_dau[i])) {
					isExisted = true;
					break;
				}
			}
		} while (isExisted == false);

		// Input second number
		do {
			System.out.println("Input number 2st:");
			dataInput2 = sc.nextLine();

		} while (Double.valueOf(dataInput2) == 0);

		int rs = 0;
		switch (operator) {
		case "+":
			rs += addNumbers(dataInput, dataInput2);
			break;
		case "-":
			rs += minusNumbers(dataInput, dataInput2);
			break;
		case "*":
			rs += multiplyNumbers(dataInput, dataInput2);
			break;
		case "/":
			rs += divideNumbers(dataInput, dataInput2);
			break;
		default:
		}

		return rs;
	}

	// Update for more calculation
	// Sử dụng cách cộng dồn giá trị
	public static double realCalculator() {
		String[] arr_dau = { "+", "-", "*", "/", "=" };
		Scanner sc = new Scanner(System.in);
		String dataInput;
		String operatorInput;
		double result = 0;

		List<String> listNum = new ArrayList<>();
		List<String> listOperator = new ArrayList<>();
		List<String> listResult = new ArrayList<>();

		int i_num = 0;
		int i_operator = 0;
		int i_rs = 0;

		do {
			// input a number1
			System.out.println("Input number:");
			dataInput = sc.nextLine();
			// add to list number
			listNum.add(dataInput);

			boolean isExisted = false;
			do {
				System.out.println("Input operator");
				operatorInput = sc.nextLine();

				for (int i = 0; i < arr_dau.length; i++) {
					if (operatorInput.equals(arr_dau[i])) {
						isExisted = true;
						break;
					}
				}

			} while (isExisted == false);

			// add to list operator
			listOperator.add(operatorInput);

		} while (!(operatorInput.equals("=")));

		int n = listOperator.size() - 1; // ta phải trừ 1 vì để loại bỏ trường hợp dấu "=" dc lưu ở cuối mảng
											// listOperator
		// Vì listResult sẽ dc gán vị trí i0 là giá trị nhập vào đầu tiên nên
		// =>listResult sẽ bắt đầu dc tính tại index 1
		listResult.add(listNum.get(0));

		while (n > 0) {

			if (listOperator.get(i_operator).equals("+")) {
				result = addNumbers(listResult.get(i_rs), listNum.get(i_num + 1));
				i_num++;
				listResult.add(String.valueOf(result));
				i_rs++;
				i_operator++;
			}

			if (listOperator.get(i_operator).equals("-")) {
				result = minusNumbers(listResult.get(i_rs), listNum.get(i_num + 1));
				i_num++;
				listResult.add(String.valueOf(result));
				i_rs++;
				i_operator++;
			}

			if (listOperator.get(i_operator).equals("*")) {
				result = multiplyNumbers(listResult.get(i_rs), listNum.get(i_num + 1));
				i_num++;
				listResult.add(String.valueOf(result));
				i_rs++;
				i_operator++;
			}

			if (listOperator.get(i_operator).equals("/")) {
				result = divideNumbers(listResult.get(i_rs), listNum.get(i_num + 1));
				i_num++;
				listResult.add(String.valueOf(result));
				i_rs++;
				i_operator++;
			}
			n--;
		}
		return result;
		// => this way just can use for operator + and -
	}

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
//		simpleCalculator();

//		double rs = standardCalculator();
//		System.out.println(rs);

		String str1 = "2 / 2 + 3 * 4 * 9";  // => 109
		String str2 = "2 / 2 + 3 * 4 + 22 / 2 * 9 / 3 + 19 - 22 + 12 * 2"; // => 67
		double rs2 = realCalculator2();
		System.out.println("Result: "+rs2);
		double rs3 = realCalculator2();
		System.out.println("Result: "+rs3);
	}

}
