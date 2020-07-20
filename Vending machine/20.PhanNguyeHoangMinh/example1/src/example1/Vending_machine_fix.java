package example1;

import java.util.Scanner;

public class Vending_machine_fix {
	static int money = 0;
	
	public static void main(String[] args) {
		String productA = "coke";
		String productB = "juice";
		String productC = "milk";
		
		int productAPrice = 100;
		int productBPrice = 200;
		int productCPrice = 300;
		
		boolean checkMoney = true;
		boolean checkMore = true;
		
		Scanner scan = new Scanner(System.in);
		while(checkMore) {
			System.out.println("Please input money: ");
			money += scan.nextInt();
			System.out.println("Check yours money: "+money);
			if(money < productAPrice || money < productBPrice || money < productCPrice) {
				System.out.println("Want more ? (Y/N)");
				String checkString = scan.next();
				if(checkString.equals("y")) {
					
				}else {
					System.out.print("Good bye!");
					checkMore = false;
				}
			};
		}
		
	}
}
