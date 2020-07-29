package Vending_Machine_3_machine.interfaceMachine.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Scanner;

import Vending_Machine_3_machine.Thread2.thread;
import Vending_Machine_3_machine.interfaceMachine.IMachine;

public class Machine implements IMachine {

	@Override
	public boolean test_Product(String selectProduct, String product) {
		return selectProduct.equals(product);
	}

	@Override
	public boolean test_Product_Price(int productPrice, int money) {
		return productPrice > money;
	}

	@Override
	public int information(int productPrice, String product, int money) {
		System.out.println("your select : " + product);
		money -= productPrice;
		return money;
	}

	@Override
	public void order_machine(boolean checkMore, int money, String[] product, int[] productPrice, int count1,
			int count2, int count3, HashMap<String, Integer> orderProduct) {
		Scanner scan = new Scanner(System.in);
		IMachine machine = new Machine();
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
					if (machine.test_Product(selectProduct, product[0])) {
						if (machine.test_Product_Price(productPrice[0], money)) {
							checkMore = true;
							break;
						}
						count1++;
						orderProduct.put(product[0], count1);
						money = machine.information(productPrice[0], product[0], money);
					} else if (machine.test_Product(selectProduct, product[1])) {
						if (machine.test_Product_Price(productPrice[1], money)) {
							checkMore = true;
							break;
						}
						count2++;
						orderProduct.put(product[1], count2);
						money = machine.information(productPrice[1], product[1], money);
					} else if (machine.test_Product(selectProduct, product[2])) {
						if (machine.test_Product_Price(productPrice[2], money)) {
							checkMore = true;
							break;
						}
						count3++;
						orderProduct.put(product[2], count3);
						money = machine.information(productPrice[2], product[2], money);
					}

					System.out.println("want more select product? y or n");
					String checkMoreString = scan.next();
					if (checkMoreString.equals("y")) {

					} else {

						System.out.println("your chance: " + money + " good bye");
						System.out.println("product you buy: ");
						for (int i = 0; i < product.length; i++) {
							if (orderProduct.get(product[i]) > 0) {
								if (orderProduct.get(product[i]) > 2) {
									/*
									 * ------------------thread 2 when customer buy > 2 product have same name
									 * -----------------
									 */

									thread threads = new thread();
									threads.run();
								}
								System.out.println(product[i] + ": " + orderProduct.get(product[i]));
								recept(product[i], orderProduct.get(product[i]).toString(), Integer.toString(money));
							}
						}
						checkMore = false;
					}

				}
			}
		}
	}

	@Override
	public void recept(String product, String count, String chance) {
		/*
		 * try{ FileInputStream fin=new
		 * FileInputStream("src/Vending_Machine_3_machine/fileBill/bill.txt");
		 * FileOutputStream fo = new
		 * FileOutputStream("src/Vending_Machine_3_machine/fileBill/bill.txt"); int
		 * readByteNum; byte[] bytes = new byte[300]; StringBuffer buffer = new
		 * StringBuffer(); while((readByteNum = fin.read(bytes)) != -1){
		 * fo.write(bytes,0, readByteNum); buffer.append(new
		 * String(bytes,0,readByteNum)); } String str = buffer.toString();
		 * System.out.println("result = " + str); fo.flush(); fo.close(); fin.close(); }
		 * catch(Exception e){ System.out.println(e); }
		 */
		try {

			StringBuffer buffer = new StringBuffer();
			buffer.append("Your Bill \r");
			buffer.append("your order: " + product);
			buffer.append("\r");
			buffer.append(product + "-count: " + count + "\r");
			buffer.append("your chance: " + chance);

			FileOutputStream outputStream = new FileOutputStream("src/Vending_Machine_3_machine/fileBill/bill.txt");
			byte[] strToBytes = buffer.toString().getBytes();
			outputStream.write(strToBytes);
			outputStream.close();
			System.out.println();
			System.out.println(buffer.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
