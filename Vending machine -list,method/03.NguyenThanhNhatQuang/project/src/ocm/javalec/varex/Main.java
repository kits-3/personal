package ocm.javalec.varex;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String[][] listProducts = {{"ORANGE JUICE", "15000"}, {"LEMON JUICE", "10000"}, {"COFFEE", "12500"}, {"Milk", "17500"}, {"Coke", "11000"}};
		
		int minPrice = findProductMinPrice(listProducts);
		
		int yourMoney = 0;
		
		yourMoney = yourMoney + inputMoney();
		
		boolean status = true;
		
		inner:
		while(status) {
			if (checkMoney(yourMoney, minPrice)) {
				showMenu(yourMoney, listProducts);
				int yourProduct = chooseProduct(listProducts);
				if (yourProduct == listProducts.length) {
					outputMoney(yourMoney);
					break;
				} else {
					if (yourProduct != -1) {
						if (isYourMoneyMoreThanProductSelect(yourMoney, yourProduct, listProducts)) {
							alertBuyProductSuccess(yourProduct, listProducts);
							yourMoney = yourMoney - Integer.parseInt(listProducts[yourProduct][1]);
							String choose = ynQuestion();
							if (isUserContinue(choose)) {
								System.out.println("=====");
								continue inner;
							} else {
								outputMoney(yourMoney);
								break;
							}
						} else {
							alertMoneyLessSelectProductCost(yourMoney, yourProduct, listProducts);
							int moneyNeedToBuyProduct = theAmountMoneyYouNeed(yourMoney, yourProduct, listProducts);
							System.out.println("To buy it you need: " + moneyNeedToBuyProduct);
							String choose = ynQuestion();
							if (isUserContinue(choose)) {
								System.out.println("=====");
								yourMoney = yourMoney + inputMoney();
								continue inner;
							} else {
								outputMoney(yourMoney);
								break;
							}
						}
					} else {
						System.out.println("Sorry. The product does not exist in my list.");
						String choose = ynQuestion();
						if (isUserContinue(choose)) {
							continue inner;
						} else {
							outputMoney(yourMoney);
							break;
						}
					}
				}
			} else {
				alertMoneyLessMinProductCost(yourMoney, minPrice);
				String choose = ynQuestion();
				if (isUserContinue(choose)) {
					System.out.println("=====");
					yourMoney = yourMoney + inputMoney();
					continue inner;
				} else {
					outputMoney(yourMoney);
					break;
				}
			}
		}
	}
	
	public static int inputMoney () {
		System.out.print("Input your money: ");
		Scanner scanner = new Scanner(System.in);
		int yourMoney = scanner.nextInt();
		return yourMoney;
	}
	
	public static void outputMoney (int yourMoney) {
		System.out.println("=====");
		System.out.println("Here is your change: " + yourMoney);
		System.out.println("Good bye. See you again!");
	}
	
//	public static void changeMoney(int yourMoney, int yourProduct, String[][] listProducts) {
//		System.out.println("=====");
//		System.out.println("Here is your change: " + (yourMoney - Integer.parseInt(listProducts[yourProduct][1])));
//		System.out.println("Good bye. See you again!");
//	}
	
	public static void currentMoney (int yourMoney) {
		System.out.println("=====");
		System.out.println("Your money: " + yourMoney);
	}
	
	public static int findProductMinPrice (String[][] listProducts) {
		int minPrice = Integer.parseInt(listProducts[0][1]);
		for (int i = 0; i < listProducts.length; i++) {
			if (minPrice > Integer.parseInt(listProducts[i][1])) {
				minPrice = Integer.parseInt(listProducts[i][1]);
			}
		}
		return minPrice;
	}
	
	public static void showMenu (int yourMoney, String[][] listProducts) {
		System.out.println("=====");
		System.out.println("Your money current: " + yourMoney);
		System.out.println("----- Welcome -----");
		for (int i = 0; i < listProducts.length; i++) {
			System.out.println(i + ". " + listProducts[i][0] + " : " + listProducts[i][1]);
		}
		System.out.println(listProducts.length + ". Exit");
	}
	
	public static boolean checkMoney (int yourMoney, int productMoney) {
		return yourMoney >= productMoney ? true : false;
	}
	
	public static boolean isUserContinue (String choose) {
		boolean flag = true;
		if (!choose.equals("Y") && !choose.equals("y")) {
			flag = false;
		}
		return flag;
	}
	
	public static boolean isYourMoneyMoreThanProductSelect(int yourMoney, int yourProduct, String[][] listProducts) {
		boolean flag = false;
		if (yourMoney >= Integer.parseInt(listProducts[yourProduct][1])) {
			flag = true;
		}
		return flag;
	}
	
	public static void alertMoneyLessMinProductCost (int yourMoney, int minCost) {
		currentMoney(yourMoney);
		System.out.println("Currently. Your money must be more " + minCost);
	}
	
	public static void alertMoneyLessSelectProductCost (int yourMoney, int yourProduct, String[][] listProducts) {
		currentMoney(yourMoney);
		System.out.println("Currently. Your money is not enough to buy " + listProducts[yourProduct][0]);
	}
	
	public static void alertBuyProductSuccess(int yourProduct, String[][] listProducts) {
		System.out.println("You bought successfully " + listProducts[yourProduct][0]);
	}
	
	public static int theAmountMoneyYouNeed(int yourMoney, int yourProduct, String[][] listProducts) {
		return Integer.parseInt(listProducts[yourProduct][1]) - yourMoney;
	}
	
	public static String ynQuestion () {
		System.out.print("Do you want to continue (Y/N) : ");
		Scanner scanner = new Scanner(System.in);
		String choose = scanner.next();
		return choose;
	}
	
	public static int chooseProduct(String[][] listProducts) {
		System.out.println("-----");
		String label = "What do you want to buy? ";
		String numberProduct = "Input number :";
		System.out.print(label + numberProduct);
		Scanner scanner = new Scanner(System.in);
		int choose = scanner.nextInt();
		if (choose < 0 || choose > listProducts.length) {
			choose = -1;
		}
		return choose;
	}
	
}
