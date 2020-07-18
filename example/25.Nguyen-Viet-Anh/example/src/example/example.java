package example;

import java.util.Scanner;

public class example {
	static int money = 0;
	public static void main(String[] args) {
		String productA = "beer";
		String productB = "juice";
		String productC = "milk";
		
		int productAPrice = 100 ;
		int productBPrice = 200 ;
		int productCPrice = 300 ;
		
		boolean checkMoney = true;
		boolean checkMore = true;
		
		Scanner scan = new Scanner(System.in);
		while(checkMore) {
			System.out.print("Please input money: ");
			money += scan.nextInt();
			System.out.println("Check your money : "+ money);
			if(money < productAPrice && money < productBPrice && money < productCPrice) {
				System.out.println("Want more? please input y or n");
				String checkString = scan.next();
				if(checkString.equals("y")) {
					
				}else {
					System.out.println("Good bye");
					checkMore = false;
				}
			}else {
				while(checkMore) {
					System.out.println("Please select product: ");
					System.out.println("1." + productA + ": " + productAPrice);
					System.out.println("2." + productB + ": " + productBPrice);
					System.out.println("3." + productC + ": " + productCPrice);
					System.out.print("You choose: ");
					String selectProduct = scan.next();
					if(selectProduct.equals(productA)) {
						System.out.println("Your select :"+productA);
						money = money - productAPrice;
						System.out.println("Your money: " + money);
					}else if(selectProduct.equals(productB)) {
						if(productBPrice > money) {
							checkMore = true;
							break;
						}
						System.out.println("Your select :"+productB);
						money = money - productBPrice;
						System.out.println("Your money: " + money);
					}else if(selectProduct.equals(productC)) {
						if(productCPrice > money) {
							checkMore = true;
							break;
						}
						System.out.println("Your select :"+productC);
						money = money - productCPrice;
						System.out.println("Your money: " + money);
					}
					
					System.out.println("Want more select product? y or n");
					System.out.print("You choose: ");
					String checkMoreString = scan.next();
					if(checkMoreString.equals("y")) {
						
					}else {
						System.out.println("Your change : "+money+ "\n" + "Good bye");
						checkMore = false; 
					}
				}
			}
		}

	}
	
}
