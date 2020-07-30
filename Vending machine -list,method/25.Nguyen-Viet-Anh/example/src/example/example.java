package example;

import java.util.Scanner;

public class example {
	static int money = 0;
	public static void main(String[] args) {
		String productA = "beer";
		String productB = "juice";
		String productC = "milk";
		
		int productAPrice = 100;
		int productBPrice = 200;
		int productCPrice = 300;
		
		boolean checkmoney = true;
		boolean checkmore = true;
		
		Scanner scan = new Scanner(System.in);
		while(checkmore) {
			System.out.print("please input money: ");
			money += scan.nextInt();
			System.out.println("check your money : "+ money);
			if(money < productAPrice && money < productBPrice && money < productCPrice) {
				System.out.println("want more? please input y or n");
				String checkString = scan.next();
				if(checkString.equals("y")) {
					
				}else {
					System.out.println("good bye");
					checkmore = false;
				}
			}else {
				while(checkmore) {
					System.out.println("please select product 1."+productA+"("+productAPrice+") 2."+productB+"("+productBPrice+") 3."+productC+"("+productCPrice+")");
					String selectProduct = scan.next();
					if(selectProduct.equals(productA)) {
						System.out.println("your select :"+productA);
						money = money - productAPrice; 
					}else if(selectProduct.equals(productB)) {
						if(productBPrice > money) {
							checkmore = true;
							break;
						}
						System.out.println("your select :"+productB);
						money = money - productBPrice;
					}else if(selectProduct.equals(productC)) {
						if(productCPrice > money) {
							checkmore = true;
							break;
						}
						System.out.println("your select :"+productC);
						money = money - productCPrice;
					}
					System.out.println("your money: " + money);
					System.out.println("want more select product? y or n");
					String checkMoreString = scan.next();
					if(checkMoreString.equals("y")) {
						
					}else {
						System.out.println("your change : "+money+ " good bye");
						checkmore = false; 
					}
				}
			}
		}
	}
	
}
