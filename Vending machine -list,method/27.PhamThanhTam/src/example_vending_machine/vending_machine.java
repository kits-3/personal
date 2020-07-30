package example_vending_machine;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class vending_machine {
	static int money = 0;

	public static void main(String[] args) {
		String[] product = { "cake", "juice", "milk" };
		int[] productPrice = { 100, 200, 300 };


		HashMap<String, Integer> orderProduct = new HashMap<>();

		orderProduct.put(product[0], 0);
		orderProduct.put(product[1], 0);
		orderProduct.put(product[2], 0);

		Boolean checkMore = true;
		int countCake = 0;
		int countJuice = 0;
		int countMilk = 0;
		Scanner scan = new Scanner(System.in);
		while (checkMore) {
			System.out.println("please input money");
			money += scan.nextInt();
			System.out.println("check your money: " + money);
			if (money < productPrice[0] && money < productPrice[1] && money < productPrice[2]) {

				System.out.println("want more ? please input y or n");
				String chechString = scan.next();
				if (chechString.equals("y")) {

				} else {
					System.out.println("good bye");
					checkMore = false;
				}
			} else {
				while (checkMore) {
					System.out.println("please select product 1." + product[0] + "(" + productPrice[0] + ") 2."
							+ product[1] + "(" + productPrice[1] + ") 3." + product[2] + "(" + productPrice[2] + ")");
					String selectProduct = scan.next();
					if (test_Product(selectProduct, product[0])) {
						if (test_Product_Price(productPrice[0], money)) {
							checkMore = true;
							break;
						}
						countCake++;
						orderProduct.put(product[0], countCake);
						information(productPrice[0], product[0]);
					} else if (test_Product(selectProduct, product[1])) {
						if (test_Product_Price(productPrice[1], money)) {
							checkMore = true;
							break;
						}
						countJuice++;
						orderProduct.put(product[1], countJuice);
						information(productPrice[1], product[1]);
					} else if (test_Product(selectProduct, product[2])) {
						if (test_Product_Price(productPrice[2], money)) {
							checkMore = true;
							break;
						}
						countMilk++;
						orderProduct.put(product[2], countMilk++);
						information(productPrice[2], product[2]);
					}

					System.out.println("want more select product? y or n");
					String checkMoreString = scan.next();
					if (checkMoreString.equals("y")) {

					} else {
						System.out.println("your change: " + money + " good bye");
						System.out.println("product you buy: ");
						for (int i = 0; i < product.length; i++) {
							if (orderProduct.get(product[i]) > 0) {
								System.out.println(product[i] + ": " + orderProduct.get(product[i]));
							}
						}
						checkMore = false;
					}

				}
			}
		}

	}

	public static boolean test_Product(String selectProduct, String product) {
		return selectProduct.equals(product);
	}

	public static boolean test_Product_Price(int productPrice, int cash) {
		return productPrice > money;
	}

	public static void information(int productPrice, String product) {
		System.out.println("your select : " + product);
		money -= productPrice;
	}
}
