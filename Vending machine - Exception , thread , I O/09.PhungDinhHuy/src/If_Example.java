import java.util.Scanner;

public class If_Example {

	public void If_ex1() {
		System.out.println("If");

		int aa = 1;
		if (aa == 2) {
			System.out.println("Do 1 ");
		} else if (aa == 3) {
			System.out.println("Do 2");
		} else if (aa == 1) {
			System.out.println("Do 3");
		}
	}

	public static void If_ex2() {

		Scanner sc = new Scanner(System.in);
		String tenThucUong = sc.nextLine();

		if (tenThucUong.equals("TraXanh") || tenThucUong.equals("Coca") || tenThucUong.equals("Orange juice")) {
			System.out.println("Drink");
		} else {
			System.out.println("Not Drink");
		}

		sc.close();
	}

	public static void If_ex3() {

		boolean a=true;
		while(a) {
		
		Scanner sc = new Scanner(System.in);
		String tenThucUong = sc.nextLine();

		

			switch (tenThucUong) {
			case "TraXanh":
				System.out.println("your order: " + tenThucUong);
				break;
			case "cola":
				System.out.println("your order2: " + tenThucUong);
				break;
			case "Orange":
				System.out.println("your order3: " + tenThucUong);
				break;
			case "Caphe":
				System.out.println("your order4: " + tenThucUong);
				break;
			case "k":
				a=false;
				break;
			default:
				System.out.println("Ko có trong danh sách");
			}
			

		sc.close();
		}
	}

	public static void main(String[] args) {
//		If_ex2();
		If_ex3();

	}

}
