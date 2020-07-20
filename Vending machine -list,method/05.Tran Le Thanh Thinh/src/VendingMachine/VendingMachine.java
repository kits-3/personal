package VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
	static int money = 0;

	public static void main(String[] args) {
		String itemA = "itemA";
		String itemB = "itemB";
		String itemC = "itemC";
		
		List<String> list = new ArrayList<String>();
		list.add("itemA");
		list.add("itemB");
		list.add("itemC");
		
		
		

		int [] itemArr = new int[3];
		itemArr[0] = 100;
		itemArr[1] = 200;
		itemArr[2] = 300;

		int minCost = 100;
		int priceItemA = 100;
		int priceItemB = 200;
		int priceItemC = 300;

		boolean checkMoneyCurrent = true;
		boolean checkAddMoreMoney = true;

		Scanner scan = new Scanner(System.in);
		while (checkAddMoreMoney) {
			System.out.println("please input money");
			money += scan.nextInt();
			System.out.println("check your money : " + money);
//			if (money < minCost) {
//
//			}
			if (checkMincost(money, minCost)) {

			}else {
				while (checkAddMoreMoney) {
					for (int i = 0; i < list.size(); i++) {
//						System.out.println("please select item "+(i+1)+" "+ list.get(i) + "(" + priceItemA + ")");
						System.out.println("please select item "+(i+1)+"."+ list.get(i));
						System.out.println("price : " + itemArr[i]);
					}
					
//					System.out.println("please select item 1." + itemA + "(" + priceItemA + ") 2." + itemB + "("
//							+ priceItemB + ") 3." + itemC + "(" + priceItemC + ")");
					String selectProduct = scan.next();
					if (selectProduct.equals(itemA)) {
						System.out.println("your select :" + itemA);
						if (money < priceItemA) {
							System.out.println("price of itemA is " + priceItemA);
							System.out.println("Currently you have " + money);
//							checkAddMoreMoney = true;
							break;
						}
						money = money - priceItemA;
					} else if (selectProduct.equals(itemB)) {
						System.out.println("your select :" + itemB);
						if (money < priceItemB) {
							System.out.println("price of itemB is " + priceItemB);
							System.out.println("Currently you have " + money);
							break;
						}
						money = money - priceItemB;
					} else if (selectProduct.equals(itemC)) {
						System.out.println("your select :" + itemC);
						if (money < priceItemC) {
							System.out.println("price of itemC is " + priceItemC);
							System.out.println("Currently you have " + money);
						}
						money = money - priceItemC;
					}
					System.out.println("want more select product? y or n");
					String checkCofirm = scan.next();
					if (checkCofirm.equals("y")) {
						
					} else {
						System.out.println("your change : " + money + " good bye");
						checkAddMoreMoney = false;
					}
				}

			}
		}

	}
	
	/*Systax :1. data Type[] Name Array = new data Type[Array size]
	 * 2.data Type[] Name Array = {value 0 , value 1 , value 2 , .... value N}
	 * */
//	String [] itemArr = new String[3];
//	itemArr[0] = "Pepsi";
//	itemArr[1] = "Coca";
//	itemArr[2] = "7up";
//	
//	readArr(itemArr);
//	
//	int [] arrNumber = {20 , 12 , 96};
//	
//	numberArr(arrNumber);
//	
//}
//public static String[] readArr (String[] arrInput) {
//	for (int i = 0; i < arrInput.length; i++) {
//		System.out.println(arrInput[i]);
//	}
//	return arrInput;
//}
//
//public static int[] numberArr (int[] input) {
//	for(int i = 0; i < input.length; i++) {
//		System.out.println(input[i]);
//	}
//	return input;
//}
	
	public static boolean checkMincost(int a , int b) {
		if(a < b ) {
			
		}
		return true;
	}
	


	
}
