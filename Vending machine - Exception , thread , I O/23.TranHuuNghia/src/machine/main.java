package machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class main {
	static int money = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		VendingOperator vd = new drink();
		VendingOperator f = new food();
		
		int money = 0;
		int minCost = 0;
		String product = "";
		String receipt = " ";
		
		boolean checkMore = true;
		String[] drink = {"Coca","Sprite","Fanta","Pepsi"};
		String[] food = {"Rice","Bread","Fish","Hamburger"};
		int[] priceDrink = {100, 200, 300, 400};
		int[] priceFood = {100, 200, 300, 400};
		// -----------Machine Drink--------------------
		if (vd.SelectMachine() == 1) 
		{
			money = vd.inputmoney();
			while (checkMore)
			{
				minCost = vd.minCost();
				
				if (money < minCost)
				{
					int check;
					check = vd.addMoney(money);
					if (money == check)
						checkMore = false;
					else{
						checkMore = true;
						money = check;
					}
				}
				else
				{
					while (checkMore)
					{
						vd.showMenu();
						product = vd.chooseProduct();
						for (int i = 0; i < drink.length; i++)
						{
							if (product.equals(drink[i])){
								if (money >= priceDrink[i]){
									
									System.out.println("your select :" + drink[i]);
									money -= priceDrink[i];
									receipt = receipt  + " " + drink[i] + ": " + priceDrink[i] + "$ ";
									System.out.println();
								}
								break;
							}
						}
						System.out.println("want more select product? y or n");
						String checkMoreString = sc.next();
						if(checkMoreString.equals("y")) {
							checkMore = true;
						}else {
							vd.Receipt(receipt);
							System.out.println("your change : "+money+ " good bye");
							checkMore = false; 
						}
					}
				}
			}
		}
		
		//-----------Machine Food-------------------
		else
		{
			money = f.inputmoney();
			while (checkMore)
			{	
				minCost = f.minCost();
				
				if (money < minCost)
				{
					int check;
					check = f.addMoney(money);
					if (money == check)
						checkMore = false;
					else{
						checkMore = true;
						money = check;
					}
				}
				else
				{
					while (checkMore)
					{
						f.showMenu();
						product = f.chooseProduct();
						for (int i = 0; i < food.length; i++)
						{
							if (product.equals(food[i])){
								if (money >= priceFood[i]){	
									System.out.println("your select :" + food[i]);
									money -= priceFood[i];
									receipt = receipt  + " " + food[i] + ": " + priceFood[i] + "$ ";
									System.out.println();
								}
								break;
							}
						}
						System.out.println("want more select product? y or n");
						String checkMoreString = sc.next();
						if(checkMoreString.equals("y")) {
							checkMore = true;
						}else {
							f.Receipt(receipt);
							System.out.println("your change : "+money+ " good bye");
							checkMore = false; 
						}
					}
				}
			}
		}
		

	}

}