package ocm.javalec.varex.Interface.impl;

import java.util.List;
import java.util.Scanner;

import ocm.javalec.varex.Interface.IMachine;

public class Machine implements IMachine {

	@Override
	public int inputMoney() {
		System.out.print("Input your money: ");
		Scanner scanner = new Scanner(System.in);
		int yourMoney = scanner.nextInt();
		return yourMoney;
	}

	@Override
	public void outputMoney(int yourMoney) {
		System.out.println("=====");
		System.out.println("Here is your change: " + yourMoney);
		System.out.println("Good bye. See you again!");
	}

	@Override
	public void currentMoney(int yourMoney) {
		System.out.println("=====");
		System.out.println("Your money: " + yourMoney);
	}

	@Override
	public int findProductMinPrice(List<String> productName, List<String> price) {
		int minPrice = Integer.parseInt(price.get(0));
		for (int i = 0; i < price.size(); i++) {
			if (minPrice > Integer.parseInt(price.get(i))) {
				minPrice = Integer.parseInt(price.get(i));
			}
		}
		return minPrice;
	}

	@Override
	public void showMenu(int yourMoney, List<String> productName, List<String> price) {
		System.out.println("=====");
		System.out.println("Your money current: " + yourMoney);
		System.out.println("----- Welcome -----");
		for (int i = 0; i < price.size(); i++) {
			System.out.println(i + ". " + productName.get(i) + " : " + price.get(i));
		}
		System.out.println(price.size() + ". Exit");
	}

	@Override
	public boolean checkMoney(int yourMoney, int productMoney) {
		return yourMoney >= productMoney ? true : false;
	}

	@Override
	public boolean isUserContinue(String choose) {
		boolean flag = true;
		if (!choose.equals("Y") && !choose.equals("y")) {
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean isYourMoneyMoreThanProductSelect(int yourMoney, int yourProduct, List<String> productName,List<String> price) {
		boolean flag = false;
		if (yourMoney >= Integer.parseInt(price.get(yourProduct))) {
			flag = true;
		}
		return flag;
	}

	@Override
	public void alertMoneyLessMinProductCost(int yourMoney, int minCost) {
		currentMoney(yourMoney);
		System.out.println("Currently. Your money must be more " + minCost);
	}

	@Override
	public void alertMoneyLessSelectProductCost(int yourMoney, int yourProduct, List<String> productName,List<String> price) {
		currentMoney(yourMoney);
		System.out.println("Currently. Your money is not enough to buy " + productName.get(yourProduct));
	}

	@Override
	public void alertBuyProductSuccess(int yourProduct, List<String> productName, List<String> price) {
		System.out.println("You bought successfully " + productName.get(yourProduct));
	}

	@Override
	public int theAmountMoneyYouNeed(int yourMoney, int yourProduct, List<String> productName, List<String> price) {
		return Integer.parseInt(price.get(yourProduct)) - yourMoney;
	}

	@Override
	public String ynQuestion() {
		System.out.print("Do you want to continue (Y/N) : ");
		Scanner scanner = new Scanner(System.in);
		String choose = scanner.next();
		return choose;
	}

	@Override
	public int chooseProduct(List<String> productName, List<String> price) {
		System.out.println("-----");
		String label = "What do you want to buy? ";
		String numberProduct = "Input number :";
		System.out.print(label + numberProduct);
		Scanner scanner = new Scanner(System.in);
		int choose = scanner.nextInt();
		if (choose < 0 || choose > price.size()) {
			choose = -1;
		}
		return choose;
	}

	@Override
	public void machine_main(List<String> productName, List<String> price, int yourMoney, boolean status) {
		System.out.println("input money:");
		Scanner scan = new Scanner(System.in);
		yourMoney += scan.nextInt();
		inner:
		while(status) {
			if (checkMoney(yourMoney, findProductMinPrice(productName, price))) {
				showMenu(yourMoney, productName, price);
				int yourProduct = chooseProduct(productName, price);
				if (yourProduct == productName.size()) {
					outputMoney(yourMoney);
					break;
				} else {
					if (yourProduct != -1) {
						if (isYourMoneyMoreThanProductSelect(yourMoney, yourProduct, productName, price)) {
							alertBuyProductSuccess(yourProduct, productName, price);
							yourMoney = yourMoney - Integer.parseInt(price.get(yourProduct));
							String choose = ynQuestion();
							if (isUserContinue(choose)) {
								System.out.println("=====");
								continue inner;
							} else {
								outputMoney(yourMoney);
								break;
							}
						} else {
							alertMoneyLessSelectProductCost(yourMoney, yourProduct, productName, price);
							int moneyNeedToBuyProduct = theAmountMoneyYouNeed(yourMoney, yourProduct, productName, price);
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
				alertMoneyLessMinProductCost(yourMoney, findProductMinPrice(productName, price));
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

}
