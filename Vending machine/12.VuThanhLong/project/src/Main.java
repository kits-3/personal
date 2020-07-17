import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int min = 10000;
		int coca = 15000;
		int pepsi = 20000;
		int c2 = 10000;
		int change = 0;
		int extramoney = 0;
		String isMore = "";
		System.out.println("Input money");
		int money = Integer.parseInt(scanner.nextLine());
		int choose = 0;
		System.out.println("You input: " + money);

		while (money < min) {
			System.out.println("Not enough money. Input more? Choose Yes or No");
			isMore = scanner.nextLine();
			if (isMore.equalsIgnoreCase("yes")) {
				System.out.println("Input money");
				extramoney = Integer.parseInt(scanner.nextLine());
				money += extramoney;
				System.out.println("You input: " + money);
				continue;
			}
			change = money;
			System.out.println("4. Cancel");
			choose = Integer.parseInt(scanner.nextLine());
			break;
		}
		if (choose == 0) {
			showMenu();
			choose = Integer.parseInt(scanner.nextLine());
		}

		while (choose != 4) {
			switch (choose) {
			case 1:
				System.out.println("You choosed Coca");
				if (money >= coca) {
					System.out.println("Take your drink");
					change = money - coca;
					money = money - coca;
					break;
				}
				System.out.println("Not enough money. Input more? Choose Yes or No");
				isMore = scanner.nextLine();
				if (isMore.equalsIgnoreCase("yes")) {
					System.out.println("Input money");
					extramoney = Integer.parseInt(scanner.nextLine());
					money += extramoney;
					System.out.println("You input: " + money);
					change = money;
					break;
				}
				System.out.println("4. Cancel");
				choose = Integer.parseInt(scanner.nextLine());
				change = money;
				break;
			case 2:
				System.out.println("You choosed Pepsi");
				if (money >= pepsi) {
					System.out.println("Take your drink");
					change = money - pepsi;
					money = money - pepsi;
					break;
				}
				System.out.println("Not enough money. Input more? Choose Yes or No");
				isMore = scanner.nextLine();
				if (isMore.equalsIgnoreCase("yes")) {
					System.out.println("Input money");
					extramoney = Integer.parseInt(scanner.nextLine());
					money += extramoney;
					System.out.println("You input: " + money);
					change = money;
					break;
				}
				System.out.println("4. Cancel");
				choose = Integer.parseInt(scanner.nextLine());
				change = money;
				break;
			case 3:
				System.out.println("You choosed C2");
				if (money >= c2) {
					System.out.println("Take your drink");
					change = money - c2;
					money = money - c2;
					break;
				}
				System.out.println("Not enough money. Input more? Choose Yes or No");
				isMore = scanner.nextLine();
				if (isMore.equalsIgnoreCase("yes")) {
					System.out.println("Input money");
					extramoney = Integer.parseInt(scanner.nextLine());
					money += extramoney;
					System.out.println("You input: " + money);
					change = money;
					break;
				}
				System.out.println("4. Cancel");
				choose = Integer.parseInt(scanner.nextLine());
				change = money;
				break;
			default:
				System.out.println("Choose again");
				break;
			}
			if (choose != 4) {
				System.out.println("Your change is: " + change);
				showMenu();
				choose = Integer.parseInt(scanner.nextLine());
			}
		}
		if (change > 0)
			System.out.println("Take your change: " + change);
		System.out.println("See you again!!!!!!!!!!!!");
		scanner.close();
		
		
	}
	public static void showMenu() {
		System.out.println("Please Choose ");
		System.out.println("1. Coca     15000");
		System.out.println("2. Pepsi    20000");
		System.out.println("3. C2       10000");
		System.out.println("4. Cancel");
	}
}