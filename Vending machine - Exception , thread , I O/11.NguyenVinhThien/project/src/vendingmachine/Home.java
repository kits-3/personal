package vendingmachine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Home {
	public static void main(String[] args) {
		ArrayList<Product> list = new ArrayList<>();
		
		ProductImps prdct = ChooseProduct.getProduct();
		list = prdct.getAllProduct();
		int min = prdct.getMin();
		String selectProduct = "";
		List<Product> listBuy = new ArrayList<Product>();
		
		boolean checkMoney = true;
		boolean checkMore = true;
		int money = 0;
		int minProduct = 0;
		
		Scanner scan = new Scanner(System.in);
		while(checkMore) {
			if(money < min || money < minProduct) {
				System.out.println("Min input: " + min);
				System.out.print("Please input money: ");
				money += scan.nextInt();
			}
			System.out.println("Check your money : "+ money);
			if(money < min) {
				System.out.print("Want more? please input y or n: ");
				String checkString = scan.next();
				if(checkString.equals("y")) {
					
				}else {
					System.out.println("Good bye!");
					checkMore = false;
				}
			}else {
				while(checkMore) {
					if(selectProduct == "") {
						prdct.getMenu();
						System.out.print("Select product: ");
						selectProduct = scan.next();
					}
		
					for(Product listPr : list) {
						if(selectProduct.equals(listPr.name)) {
							if(listPr.price > money) {
								checkMore = true;
								minProduct = listPr.price;
								break;
							}
							System.out.println("Your select: "+listPr.name);
							money = money - listPr.price;
							
							MakeTime wait = new MakeTime();
							wait.start();
							
							listBuy.add(listPr);
							System.out.println("Your money: " + money);
							selectProduct = "";
						}
					}
					System.out.println("Want more select product? y or n");
					String checkMoreString = scan.next();
					if(checkMoreString.equals("y")) {
						break;
					}else {
						System.out.print("Your want export invoice? Please input y or n: ");
						String checkInvoice = scan.next();
						if(checkInvoice.equals("y")) {
							Invoice inv = new Invoice();
							inv.exportInvoice(listBuy);
							System.out.println("Export invoice success!");
						}
						System.out.println("Your change: "+money);
						System.out.println("Good bye!");
						checkMore = false; 
					}
				}
			}
		}
	}
}
