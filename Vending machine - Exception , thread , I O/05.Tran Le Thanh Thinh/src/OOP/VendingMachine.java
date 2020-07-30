package OOP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

	static int money = 0;
	static String[] machineArray;
	static List<Products> list = new ArrayList<Products>();
	static List<Products> listReceipt = new ArrayList<Products>();
	static int minCost = 100;
	static boolean checkMoneyCurrent = true;
	static boolean checkAddMoreMoney = true;
	static boolean checkSelectMachine = true;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

//		Receipt receipt = new Receipt();

		RawMilkVendingMachine mc_1 = new RawMilkVendingMachine();
		mc_1.getName();
		CandyVendingMachine mc_2 = new CandyVendingMachine();
		mc_2.getName();
		SnacksAndSodaVending mc_3 = new SnacksAndSodaVending();
		mc_3.getName();

		machineArray = new String[3];
		machineArray[0] = mc_1.getName();
		machineArray[1] = mc_2.getName();
		machineArray[2] = mc_3.getName();

		while (checkSelectMachine) {
			displaySelectMachine();
			while (checkAddMoreMoney) {

				if (money < minCost) {
					plusMoney();
				} else {
					boolean m = true;
					while (checkAddMoreMoney && m) {
						displayItem();
						System.out.println("please choose product");
						Integer selectProduct = scan.nextInt();
						for (int i = 0; i < list.size(); i++) {
							if (selectProduct == (list.get(i).getId())) {
								System.out.println("your select :" + list.get(i).getName());
								if (money < list.get(i).getPrice()) {
									System.out.println(
											"price of " + list.get(i).getName() + "is" + " " + list.get(i).getPrice());
									System.out.println("Currently you have " + money);
									checkAddMoreMoney = false;
									break;
								} else {
									money = money - list.get(i).getPrice();
									addReceipt(list.get(i));
									m = false;
									checkAddMoreMoney = false;
									break;
								}

							}
						}
					}
					showQuestion();

				}

			}

		}
	}

	/*
	 * Systax :1. data Type[] Name Array = new data Type[Array size] 2.data Type[]
	 * Name Array = {value 0 , value 1 , value 2 , .... value N}
	 */
	public static void showQuestion() {
		System.out.println("Waiting to get your drink ...");
		System.out.println("want more select product ? y or n");
		ThreadMachine tr = new ThreadMachine();
		Thread thread = new Thread(tr);
		thread.start();
		String checkCofirm = scan.next();
		if (checkCofirm.equals("y")) {
			checkAddMoreMoney = true;

		} else {
			System.out.println("your change : " + money + " good bye");
			checkAddMoreMoney = false;
			writeReceipt(listReceipt);
			;
		}
	}

	public static List<Products> addReceipt(Products product) {
		listReceipt.add(product);
//		System.out.println(product.getName());
//		System.out.println(product.getPrice());
//		System.out.println(listReceipt.size());
		return listReceipt;
	}

	public static void writeReceipt(List<Products> list) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			buffer.append(list.get(i).getName()).append(" : ").append(list.get(i).getPrice()).append("\n");
		}

		String write = buffer.toString();
		writeReceipt(write);
	}

	public static void writeReceipt(String data) {
		File newfile = new File("D:/text.txt");
		OutputStream os = null;
		try {
			os = new FileOutputStream(newfile);
			os.write(data.getBytes(), 0, data.length());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static List<Products> checkSelectMachine(String input) {
		RawMilkVendingMachine mc_1 = new RawMilkVendingMachine();
		mc_1.getName();

		CandyVendingMachine mc_2 = new CandyVendingMachine();
		mc_2.getName();

		SnacksAndSodaVending mc_3 = new SnacksAndSodaVending();
		mc_3.getName();

		for (int i = 0; i < machineArray.length; i++) {
			if (input.equals(machineArray[i])) {
				System.out.println("You selected machine " + machineArray[i]);
				if (input.equals(mc_1.getName())) {
					list.add(new Products(1, "Milk 1", 5, 100));
					list.add(new Products(2, "Milk 2", 5, 150));
					list.add(new Products(3, "Milk 3", 5, 200));
				}
				if (input.equals(mc_2.getName())) {
					list.add(new Products(1, "Snickers", 5, 50));
					list.add(new Products(2, "Kit Kat", 5, 100));
					list.add(new Products(3, "Skittles", 5, 200));
				}
				if (input.equals(mc_3.getName())) {
					list.add(new Products(1, "Snack 1", 5, 220));
					list.add(new Products(1, "Snack 2", 5, 100));
					list.add(new Products(1, "Snack 3", 5, 330));
				}
			}

		}
		return list;
	}

	public static void displayItem() {
		for (int i = 0; i < list.size(); i++) {
//			System.out.println("please select item "+(i+1)+" "+ list.get(i) + "(" + priceItemA + ")");
			System.out.println("please select item " + (i + 1) + "." + list.get(i).getName());
			System.out.println("price : " + list.get(i).getPrice());
		}
		return;
	}

	public static void displaySelectMachine() {
		System.out.println("please select machine");
		for (int i = 0; i < machineArray.length; i++) {
			System.out.println((i + 1) + " " + machineArray[i]);
		}
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		checkSelectMachine(input);
	}

	public static int plusMoney() {
		System.out.println("please input money");
		Scanner sc = new Scanner(System.in);
		money += sc.nextInt();
		System.out.println("check your money : " + money);
		return money;
	}

	public static void addProduct() {

	}

}
