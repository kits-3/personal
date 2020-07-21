import java.util.Scanner;

public abstract class Machines {
	
	TypeFromKeyboard type = new TypeFromKeyboard();

	public abstract void showProduct();

	public void check(float curentMoney, int numberProduct, int[] priceProduct, String[] nameProduct) {
		Scanner scanner = new Scanner(System.in);

		float money, moneyReturn;

		System.out.println("Your choose: " + numberProduct + "." + nameProduct[numberProduct - 1] + " "
				+ priceProduct[numberProduct - 1] + "$");

		while (curentMoney < priceProduct[numberProduct - 1]) {
			System.out.print("Extra money: ");
			money = scanner.nextFloat();
		}
		System.out.println("Enjoy your drink");
		curentMoney = curentMoney - priceProduct[numberProduct - 1];
		int k = 0;

		for (int i = 0; i < priceProduct.length; i++) {
			if (curentMoney >= priceProduct[i]) {
				k = k + 1;
				System.out.print("Want more? Y/N: ");
				String confirm = scanner.next();
				confirm = confirm.toUpperCase();
				if (confirm.equals("Y")) {
					System.out.println("Enter number onkeyboard");
					System.out.println("Curent money: " + curentMoney + "$");
					check(curentMoney, numberProduct, priceProduct, nameProduct);
					break;

				} else if (confirm.equals("N")) {
					System.out.println("Take your change money: " + curentMoney + "$");
					break;
				}
			}
		}
		if (k == 0) {
			System.out.println("Take your change money: " + curentMoney + "$");
		}
	}

	public void Vending(int[] priceProduct, String[] nameProduct) {
		Scanner scanner = new Scanner(System.in);

		float money, moneyReturn;

		for (int i = 0; i < priceProduct.length; i++) {
			System.out.print(i + 1 + "." + nameProduct[i] + ": " + priceProduct[i] + "$" + "\t");
		}
		int numberProduct = type.typeKeyboard();

		System.out.println("Your choose: " + numberProduct + "." + nameProduct[numberProduct - 1] + " "
				+ priceProduct[numberProduct - 1] + "$");
		System.out.print("Enter money please $: ");
		money = scanner.nextFloat();

		while (money < priceProduct[numberProduct - 1]) {
			System.out.print("Extra money: ");
			money = scanner.nextFloat();
		}
		System.out.println("Enjoy your drink");
		moneyReturn = money - priceProduct[numberProduct - 1];
		int k = 0;

		for (int i = 0; i < priceProduct.length; i++) {
			if (moneyReturn >= priceProduct[i]) {
				k = k + 1;
				System.out.print("Want more? Y/N: ");
				String confirm = scanner.next();
				confirm = confirm.toUpperCase();
				if (confirm.equals("Y")) {
//					System.out.println("Enter number onkeyboard");
//					break;
					System.out.println("Curent money: " + moneyReturn + "$");
					check(moneyReturn, numberProduct, priceProduct, nameProduct);
					break;

				} else if (confirm.equals("N")) {
					System.out.println("Take your change money: " + moneyReturn + "$");
					break;
				}
			}
		}
		if (k == 0) {
			System.out.println("Take your change money: " + moneyReturn + "$");
		}
	}

}
