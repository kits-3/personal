import java.util.Scanner;

public class machineVen {

	static int hang(int a) {
		int price = 0;
		switch (a) {
		case 1:
			price = 20;
			break;
		case 2:
			price = 30;
			break;
		case 3:
			price = 30;
			break;
		default:
			break;
		}
		return price;
	}

	static int you(int d) {
		int e = 0;
		switch (d) {
		case 1:
			e = 1;
			break;
		case 2:
			e = 0;
			break;
		default:
			break;
		}
		return e;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("input money: ");
		int money = scanner.nextInt();
		int minCProduct = 20;

		//

		while (money >= minCProduct) {
			if (money >= minCProduct) {
				System.out.print("selec product: ");
				System.out.println("1:apple, 2:banana,3:cocacola ");
				System.out.println("choose product you want: ");
				int a = scanner.nextInt();

				if (hang(a) <= money) {
					int moneyd = money - hang(a);
					System.out.println("product under and Money is left in the device: " + moneyd);
					money = moneyd;
					System.out.println("Do you want to buy half? ");
					System.out.println("If not buy, choose number 1: ");
					int d = scanner.nextInt();
					if (you(d) == 1) {
						System.out.println("Here is your money: " + money);
						System.exit(money);
					} else {
						System.out.println(" Money is left in the device: " + money);
						if (you(d) == 0) {
							System.out.println("add Money: ");
							int moneyR = scanner.nextInt();
							money = money + moneyR;
							System.out.println(money);
							if (money <minCProduct) {
								System.out.println("lack of money");
								System.out.println("add money");
								int c = scanner.nextInt();
								money +=c;
							}
						}
					}
				} else {
					System.out.println("Do you want to buy half? ");
					System.out.println("If not buy, choose number 1: ");
					int d = scanner.nextInt();
					if (you(d) == 1) {
						System.out.println("Here is your money: " + money);
						System.exit(money);
					} else {
						System.out.println("add Money: ");
						int moneyR = scanner.nextInt();
						money = money + moneyR;
						System.out.println(money);
					}
				}

			}

		}

	}

}
