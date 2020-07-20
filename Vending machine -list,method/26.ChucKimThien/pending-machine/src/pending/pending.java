package pending;

import java.util.Scanner;

public class pending {
	static int mincost= 10;
	static int pay;
	static boolean muatiep= true ;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("input money: ($)");
		int money = input.nextInt();
		System.out.println("You have: "+money+"$");
		while(true)
		{
		while(money<mincost&&muatiep) 
		{
			System.out.println("You don't have enough money!");
			System.out.println("Please recharge money!");
			System.out.println("input money: ($)");
			int moneyex = input.nextInt();
			money=money+moneyex;
			System.out.println("You have: "+money+"$");
			if(money>=mincost)
			{
				break;
			}
			break;
		}
		while(money>=mincost && muatiep)
		{
			System.out.println("You have enough money!");
			System.out.println("------------------------------------------------------------");
			System.out.println("Please choose your drink!");
			System.out.println("1.Cocacola 10$     2.Pepsi 11$       3.lemon 12$       4.Orange 13$");
			
			Scanner input2 = new Scanner(System.in);
			String product = input2.nextLine();
			switch(product)
			{
			case "1":
				pay = 10;
				System.out.println("You choose Cocacola.");
				System.out.println("Money to pay: "+pay+"$");
				money=money-pay;
				System.out.println("Your money current: "+money+"$");
				System.out.println("Here is your drink!");
				break;
			case "2":
				pay = 11;
				System.out.println("You choose Pepsi");
				System.out.println("Money to pay: "+pay+"$");
				money=money-pay;
				System.out.println("Your money current: "+money+"$");
				System.out.println("Here is your drink!");
				break;
			case "3":
				pay = 12;
				System.out.println("You choose Lemon");
				System.out.println("Money to pay: "+pay+"$");
				money=money-pay;
				System.out.println("Your money current: "+money+"$");
				System.out.println("Here is your drink!");
				break;
			case "4":
				pay=13;
				System.out.println("You choose Orange");
				System.out.println("Money to pay: "+pay+"$");
				money=money-pay;
				System.out.println("Your money current: "+money+"$");
				System.out.println("Here is your drink!");
				break;
			default:
				break;
			}
			 	System.out.println("------------------------------------------------------------");
				System.out.println("Get more drink?");
				System.out.println("1.Yes                          2.No");
				Scanner input3 = new Scanner(System.in);
				String a = input3.nextLine();
				switch(a)
				{
				case "1":
					
					System.out.println("Your money current: "+money+"$");
					break;
					
				case "2":
				
					System.out.println("See you!!!");
					muatiep = false;
					break;
				}
				
			//
			
			if(money<pay&&muatiep)
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("you don't have enough money!");
				System.out.println("1.Choose other drink             2.Recharge money       3.Exit");
				Scanner input4 = new Scanner(System.in);
				String option = input4.nextLine();
				switch(option)
				{
				case "1":
					System.out.println("------------------------------------------------------------");
					System.out.println("Please choose your drink!");
					System.out.println("1.Cocacola 10$     2.Pepsi 11$       3.lemon 12$       4.Orange 13$");
					break;
				case "2":
					System.out.println("input money: ($)");
					int moneyex = input.nextInt();
					money=money+moneyex;
					System.out.println("You have: "+money+"$");
					break;
				case "3":
					System.out.println("See you!!!");
					muatiep = false;
					break;
				default:
					break;
				}
				break;
			}
			
		}
	}
		
	}

}
