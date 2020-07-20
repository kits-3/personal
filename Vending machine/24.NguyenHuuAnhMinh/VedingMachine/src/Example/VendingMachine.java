package Example;
import java.util.Scanner;

public class VendingMachine {
	public static void main(String[] args){0
		int money = 0;
		int extra_money=0;
		int changeMoney=0;
		int min_cost= 6000;
		int product_item = 1;
		Scanner sc = new Scanner(System.in);
		System.out.print("Input money: ");
		money = sc.nextInt();
		while(money < min_cost)
		{
			if(money < min_cost)
			{
				System.out.println("You don't have enough money to buy, do you want to input more money?");
				System.out.println("Press 1 to input more money, Press 0 to get back your money");
				int ys = sc.nextInt();
				if(ys==1)
				{
					System.out.println("Input your extra money: ");
					extra_money=sc.nextInt();
					money += extra_money;
				}
				else
					System.out.println("You got back your money");
			}
			else{
				
			}
		}
		
		while(product_item != 0)
		{
			System.out.println("Press the number of product you want");
			System.out.println("----------Product--------");
			System.out.println("1.Coca : 12000");
			System.out.println("2.PepSi: 8000");
			System.out.println("3.7up : 6000");
			System.out.println("4.Mirinda : 11000");
			System.out.println("-------------------------");
			System.out.println("Press 0 to exit");
			product_item = sc.nextInt();
			switch(product_item){
			case 1:
				if(money > 12000)
				{
					changeMoney = money - 12000;
					System.out.println("You bought Coca, you have " + changeMoney + "$ left");
					money = changeMoney;
					break;
				}
				else
				{
					System.out.println("You don't have enought money to buy this product");
					System.out.println("You only have "+ money+"$");
					while(money < min_cost)
					{
						if(money < min_cost)
						{
							System.out.println("Press 1 to input more money, Press 0 to get back your money");
							int ys = sc.nextInt();
							if(ys==1)
							{
								System.out.println("Input your extra money: ");
								extra_money=sc.nextInt();
								money += extra_money;
							}
							else
								System.out.println("You got back your money");
							break;
						}
						else{
							
						}
					}
					break;
				}
				
			case 2:
				if(money > 10000)
				{
					changeMoney = money - 10000;
					System.out.println("You bought Pepsi, you have " + changeMoney + "$ left");
					money = changeMoney;
					break;
				}
				else
				{
					System.out.println("You don't have enought money to buy this product");
					System.out.println("You only have "+ money+"$");
					while(money < min_cost)
					{
						if(money < min_cost)
						{
							System.out.println("Press 1 to input more money, Press 0 to get back your money");
							int ys = sc.nextInt();
							if(ys==1)
							{
								System.out.println("Input your extra money: ");
								extra_money=sc.nextInt();
								money += extra_money;
							}
							else
								System.out.println("You got back your money");
							break;
						}
						else{
							
						}
					}
					break;
				}
			case 3:
				changeMoney = money - 6000;
				System.out.println("You bought 7up, you have " + changeMoney + "$ left");
				money = changeMoney;
				break;
			case 4:
				if(money > 11000)
				{
					changeMoney = money - 11000;
					System.out.println("You bought Mirinda, you have " + changeMoney + "$ left");
					money = changeMoney;
					break;
				}
				else
				{
					System.out.println("You don't have enought money to buy this product");
					System.out.println("You only have "+ money+"$");
					while(money < min_cost)
					{
						if(money < min_cost)
						{
							System.out.println("Press 1 to input more money, Press 0 to get back your money");
							int ys = sc.nextInt();
							if(ys==1)
							{
								System.out.println("Input your extra money: ");
								extra_money=sc.nextInt();
								money += extra_money;
							}
							else
								System.out.println("You got back your money");
							break;
						}
						else{
							
						}
					}
					break;
				}
			case 0:
				System.out.println("Welcome back later!");
				break;
			default:
				System.out.println("You should choose number in menu");
				break;
			}
		}
	}	
}
