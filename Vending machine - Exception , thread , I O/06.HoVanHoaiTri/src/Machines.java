import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

public abstract class Machines extends Thread {

	TypeFromKeyboard type = new TypeFromKeyboard();
	public String sav = " ";
	public String date = String.valueOf(java.time.LocalDate.now())+"  "+String.valueOf(java.time.LocalTime.now())+"\n";
	public abstract void showProduct();

	public void check(float curentMoney, int numberProduct, int[] priceProduct, String[] nameProduct) {
		Scanner scanner = new Scanner(System.in);
		writeBill wr = new writeBill();

		float money, moneyReturn;

		numberProduct = type.typeKeyboard();
		System.out.println("Your choose: " + numberProduct + "." + nameProduct[numberProduct - 1] + " "
				+ priceProduct[numberProduct - 1] + "$");
		//
		sav +=date+nameProduct[numberProduct - 1] + " " + priceProduct[numberProduct - 1] + "$" + "\n";
		//
		while (curentMoney < priceProduct[numberProduct - 1]) {
			System.out.print("Extra money: ");
			money = scanner.nextFloat();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
					String a = String.valueOf(curentMoney);
					sav += "Change money: " + a + "$";
					wr.setStringConvert(sav);
					wr.convert();
					System.out.println("Take your change money: " + curentMoney + "$");
					break;
				}
			}
		}
		if (k == 0) {
			String a = String.valueOf(curentMoney);
			sav += "Change money: " + a + "$";
			wr.setStringConvert(sav);
			wr.convert();
			System.out.println("Take your change money: " + curentMoney + "$");
		}
	}
	// public void Vending(int[] priceProduct, String[] nameProduct)
	public void Vending(int[] priceProduct, String[] nameProduct) {
		Scanner scanner = new Scanner(System.in);
		writeBill wr = new writeBill();
		float money, moneyReturn;

		for (int i = 0; i < priceProduct.length; i++) {
			System.out.print(i + 1 + "." + nameProduct[i] + ": " + priceProduct[i] + "$" + "\t");
		}
		int numberProduct = type.typeKeyboard();

		System.out.println("Your choose: " + numberProduct + "." + nameProduct[numberProduct - 1] + " "
				+ priceProduct[numberProduct - 1] + "$");

		//

		sav +=date+nameProduct[numberProduct - 1] + " " + priceProduct[numberProduct - 1] + "$" + "\n";

		//
		System.out.print("Enter money please $: ");
		money = scanner.nextFloat();

		while (money < priceProduct[numberProduct - 1]) {
			System.out.print("Extra money: ");
			money = scanner.nextFloat();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
					System.out.println("Curent money: " + moneyReturn + "$");
					check(moneyReturn, numberProduct, priceProduct, nameProduct);
//						break;

				} else if (confirm.equals("N")) {
					String a = String.valueOf(moneyReturn);
					sav += "Change money: " + a + "$";
					wr.setStringConvert(sav);
					wr.convert();
					System.out.println("Take your change money: " + moneyReturn + "$");
					break;
				}
			}
		}
		if (k == 0) {
			String a = String.valueOf(moneyReturn);
			sav += "Change money: " + a + "$";
			wr.setStringConvert(sav);
			wr.convert();
			System.out.println("Take your change money: " + moneyReturn + "$");
		}

	}

}
