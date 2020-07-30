package Example;

import java.util.ArrayList;
import java.util.Scanner;

import Example.VendingMachine;
import Example.Drink;
public class Main {
	static int money = 0;
	public static void main(String[] args)
	{
		VendingMachine vendingMachine = new VendingMachine();
		ArrayList<Drink> List = new ArrayList<Drink>();
		List = vendingMachine.getList();
		vendingMachine.outPut();
		int[] arrMoney = {vendingMachine.getLowestMoney(money)};
		int lowestMoney = arrMoney[0];
		for (int i = 0; i < arrMoney.length; i++) {
			if(lowestMoney > arrMoney[i]) {
				lowestMoney = arrMoney[i];
			}
		}
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("input money: ");
			money = scanner.nextInt();
		} while (money < lowestMoney);
		boolean transaction = true;
		while (transaction) {

			System.out.println("1. Drink ------- 2. Food --------- 3. Clothes");
			System.out.print("Select a compatible transaction number: ");
			int tran = scanner.nextInt();
			switch (tran) {
			case 1:
				vendingMachine.displayList();
				System.out.println("---------------------------------");
				System.out.print("Choose a drink you want to buy:");
				int productNum = scanner.nextInt();
				money = money - vendingMachine.selectProduct(money, productNum);
				System.out.println("---------------------------------");
				System.out.print("Your change is: "+money);
				transaction = false;
				break;
			case 2:
				vendingMachine.displayList1();
				System.out.println("---------------------------------");
				System.out.print("Choose a food you want to buy:");
				int productNum1 = scanner.nextInt();
				money = money - vendingMachine.selectProduct1(money, productNum1);
				System.out.println("---------------------------------");
				System.out.print("Your change is: "+money);
				transaction = false;
				break;
			case 3:

				break;

			default:
				break;
			}


		scanner.close();
	}
}
}