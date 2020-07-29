import java.util.Scanner;

public class machine {
	static int min_product = 100;
	static Scanner scanner = new Scanner(System.in);
	static int old_money = 0;
	static int money = 0;

	public static void main(String[] args) {

		inputmoney();
	}

	public static void inputmoney() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input money:");
		money = scanner.nextInt();
		money = money + old_money;
		System.out.println("You have "+ money +" money");
		if (money < min_product) {
			old_money = money;
			System.out.println(old_money);
			return_money();	
		} else {
			System.out.println("-----Product----------------------------------");
			System.out.println("---------------1. Orangred -100---------------");
			System.out.println("---------------2. Apple -200------------------");
			System.out.println("---------------3. Apricot -300----------------");
			System.out.println("---------------4. Persimmon-600---------------");
			System.out.println("---------------5. Mangosteen -1000------------");
			System.out.print("Choose product:");
			int product = scanner.nextInt();
			switch (product) {
			case 1:
				product = 100;
				break;
			case 2:
				product = 200;
				break;
			case 3:
				product = 300;
				break;
			case 4:
				product = 400;
				break;
			case 5:
				product = 1000;
				break;
			default:
				System.out.println("Please choose product on list");
				break;
			}
			if (money < product) {
				System.out.println("you do not have enough money");
				old_money = money;
				return_money();
			} else {
				money = money - product;
				old_money = money;
				System.out.println("You buy product success. You have " + money + " money");
				System.out.println("You will buy new product?");
				return_money();
			}
		}
	}

	public static void return_money() {
		System.out.println("Return money: y/n ?");
		String return_money = scanner.next();
		switch (return_money) {
		case "y":
			System.out.print("Money return to you. You have " + money + " money");
			break;
		default:
			inputmoney();
			break;
		}
	}
}
