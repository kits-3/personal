package vending;


import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
public class main {
//	static int money = 0;

	public static void main(String[] args) {

//
//		String[] product = { "beer", "juice", "milk" };
//		int[] productPrice = { 100, 200, 300 };
//
//
//		HashMap<String, Integer> orderProduct = new HashMap<>();
//
//		orderProduct.put(product[0], 0);
//		orderProduct.put(product[1], 0);
//		orderProduct.put(product[2], 0);
//
//	int PriceA = 100 ;
//	int PriceB = 200 ;
//	int PriceC = 300 ;
//
//	boolean checkMoney = true;
//	boolean checkMore = true;
//
//	Scanner scan = new Scanner(System.in);
//	while(checkMore) {
//		Scanner scan = new Scanner(System.in);
//		System.out.println("please input money");
//		money += scan.nextInt();
//		System.out.println("check your money : "+ money);
//		if(money < PriceA && money < PriceB && money < PriceC) {
//			System.out.println("want more? please input y or n");
//			String checkString = scan.next();
//			if(checkString.equals("y")) {
//
//			}else {
//				System.out.println("good bye");
//				checkMore = false;
//			}
//		}else {
//			while(checkMore) {
//				System.out.println("please select product 1."+product[0]+"("+PriceA+") 2."+product[1]+"("+PriceB+") 3."+product[2]+"("+PriceC+")");
//				String selectProduct = scan.next();
//				if(selectProduct.equals(product[0])) {
//					System.out.println("your select :"+product[0]);
//					money = money - PriceA; 
//				}else if(selectProduct.equals(product[1])) {
//					if(PriceB > money) {
//						checkMore = true;
//						break;
//					}
//					System.out.println("your select :"+product[1]);
//					money = money - PriceB;
//				}else if(selectProduct.equals(product[2])) {
//					if(PriceC > money) {
//						checkMore = true;
//						break;
//					}
//					System.out.println("your select :"+product[2]);
//					money = money - PriceC;
//				}
//
//				System.out.println("want more select product? y or n");
//				String checkMoreString = scan.next();
//				if(checkMoreString.equals("y")) {
//
//				}else {
//					System.out.println("your change : "+money+ " good bye");
//					checkMore = false; 
//				}
//			}
//		}
//	}
		Scanner scanner = new Scanner(System.in);
		System.out.println("select machine 1 2 3");
		int key = scanner.nextInt();
		switch (key) {
		case 1:
			new vending1();
			break;
		case 2:
			new vending2();
			break;
		case 3:
			new vending3();
			break;

		default:
			break;
		}
}

}




