
import java.util.Scanner;

public class Main {
	static int money = 0;

	public static void main(String[] args) {
		String[] product = { "beer", "juice", "coke" };
		int[] productPrice = { 100, 200, 300 };
		boolean checkMore = true;
		Scanner scan = new Scanner(System.in);
		while (checkMore) {
			System.out.println("please input money");
			money += scan.nextInt();
			if (money < productPrice[0] && money < productPrice[1] && money < productPrice[2]) {
				System.out.println("Not enough money");
				checkMore = isContinue();
			} else {
				while (checkMore) {
					System.out.println("check your money : " + money);
					System.out.println("please select product 1." + product[0] + "(" + productPrice[0] + ") 2."
							+ product[1] + "(" + productPrice[1] + ") 3." + product[2] + "(" + productPrice[2] + ")");
					int selectProduct = scan.nextInt();
					if (productPrice[selectProduct - 1] > money) {
						System.out.println("Not enough money");
						checkMore = isContinue();
						continue;
					}
					System.out.println("your select :" + product[selectProduct - 1]);
					money = money - productPrice[selectProduct - 1];
					checkMore = isContinue();
				}
			}
		}
	}
	public static boolean isContinue() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Your money is: " + money);
		System.out.println("want more select product? y or n");
		String checkMoreString = scan.next();
		if (checkMoreString.equals("n")) {
			System.out.println("your change : " + money + " good bye");
			 return false;
		}
		return true;
	}
}
