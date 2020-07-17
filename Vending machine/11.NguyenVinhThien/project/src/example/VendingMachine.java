package example;

import java.util.Scanner;

public class VendingMachine {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] drinkName = new String[] {"COCACOLA", "PEPSI", "MIRINDA", "RED BULL", "ORANG JUICE", "NUMBER ONE", "NONE"};
		int min = 12000;
		String check = "YES";
		int check2 = 0;
		String con = "";
		int money = 0;
		int money2 = 0;
		int drink = 0;
		int extra = 0;
		while (check2 == 0) {
			if(extra > 0)
				System.out.println("YOUR BALANCE: " +extra);
			while((money < min && check.equalsIgnoreCase("YES")) || extra < 0) {
				System.out.print("ENTER MONEY: ");
				money2 = scan.nextInt();
				money += money2;
				System.out.println("YOUR AMOUT: " + money);
				scan.nextLine();
				if(money < min || (money2 + extra) < 0) {
					System.out.println("YOUR AMOUNT IS NOT ENOUGH!");
					System.out.print("DO YOU WANT TO CONTINUE? (YES/NO): ");
					check = scan.nextLine();
				}else {
					extra = 0;
				}
			}
			
			if(drink == 0 && check.equalsIgnoreCase("YES")) {
				System.out.println("---------- MENU ----------");
				System.out.println("1. COCACOLA \t\t 13000");
				System.out.println("2. PEPSI \t\t 14000");
				System.out.println("3. MIRINDA \t\t 12000");
				System.out.println("4. REDBULL \t\t 13000");
				System.out.println("5. ORANGE JUICE \t 15000");
				System.out.println("6. NUMBER ONE \t\t 12000");
				System.out.println("7. CANCEL");
				System.out.println("CHOOSE DRINKING WATER?");
				drink = scan.nextInt();
				scan.nextLine();
			}
			
			switch(drink) {
			case 1:
				extra = money - 13000;
				break;
			case 2:
				extra = money - 14000;
				break;
			case 3:
				extra = money - 12000;
				break;
			case 4:
				extra = money - 13000;
				break;
			case 5:
				extra = money - 15000;
				break;
			case 6:
				extra = money - 12000;
				break;
			case 7:
				extra = money;
				break;
			case 0:
				extra = money;
				check2 = 1;
				break;
			}
			if(extra < 0){
				check2 = 0;
			}else if (check.equalsIgnoreCase("YES")){
				check2 = 1;
				if(drink != 7)
					System.out.println("YOU HAVE BUY " + drinkName[(drink-1)] +" SUCCESS!");
				System.out.println("CURRENT AMOUNT: " + extra);
				System.out.println("DO YOU WANT TO CONTINUE? (YES/NO): ");
				con = scan.nextLine();
				
				if(con.equalsIgnoreCase("YES")) {
					check2 = 0;
					money = extra;
					drink = 0;
				} else {
					if (extra == 0)
						System.out.println("THANK YOU FOR YOUR PURCHASE!");
					else {
						System.out.println("THANK YOU FOR YOUR PURCHASE!");
						System.out.println("AMOUNT RETURNED: " + extra);
					}
				}
			} else {
				System.out.println("AMOUNT RETURNED: " + extra);
				System.out.println("THANK YOU FOR YOUR PURCHASE!");
			}
		}	
	}
}
