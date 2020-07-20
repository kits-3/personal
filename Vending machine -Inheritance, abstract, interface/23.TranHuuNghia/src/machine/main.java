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
		
		int money = 0;
		int minCost = 0;
		String product;
		boolean checkMore = true;
		String[] drink = {"Coca", "Sprite", "Fanta", "Pepsi"};
		int[] priceDrink = {100, 200, 300, 400};
		// -----------Machine Drink--------------------
		if (vd.SelectMachine() == 1) 
		{
			while (checkMore)
			{
			
				vd.showMenu();
				money = vd.inputmoney();
				minCost = vd.minCost();
				
				if (money < minCost)
				{
					int check;
					check = vd.addMoney(money);
					if (money == check)
						checkMore = false;
					else
						checkMore = true;
				}
				else
				{
					while (checkMore)
					{
						product = vd.chooseProduct();
						for (int i = 0; i < drink.length; i++)
						{
							if (product.equals(drink[i])){
								if (money > priceDrink[i]){
									checkMore = true;
									break;
								}
								System.out.println("your select :" + drink[i]);
								money -= priceDrink[i];
							}
							else {System.out.println("Not in menu");}
						}
						System.out.println("want more select product? y or n");
						String checkMoreString = sc.next();
						if(checkMoreString.equals("y")) {

						}else {
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
			
		}
		

	}

}