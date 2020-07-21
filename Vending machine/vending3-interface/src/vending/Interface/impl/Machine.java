package vending.Interface.impl;

import java.util.Scanner;

import vending.Interface.IMachine;

public class Machine implements IMachine{

	@Override
	public void machine_main(boolean checkMore, int PriceA, int PriceB, int PriceC, String[] product) {
		// TODO Auto-generated method stub
		int money = 0;
		while(checkMore) {
			Scanner scan = new Scanner(System.in);
			System.out.println("please input money");
			money += scan.nextInt();
			System.out.println("check your money : "+ money);
			if(money < PriceA && money < PriceB && money < PriceC) {
				System.out.println("want more? please input y or n");
				String checkString = scan.next();
				if(checkString.equals("y")) {

				}else {
					System.out.println("good bye");
					checkMore = false;
				}
			}else {
				while(checkMore) {
					System.out.println("please select product 1."+product[0]+"("+PriceA+") 2."+product[1]+"("+PriceB+") 3."+product[2]+"("+PriceC+")");
					String selectProduct = scan.next();
					if(selectProduct.equals(product[0])) {
						System.out.println("your select :"+product[0]);
						money = money - PriceA; 
					}else if(selectProduct.equals(product[1])) {
						if(PriceB > money) {
							checkMore = true;
							break;
						}
						System.out.println("your select :"+product[1]);
						money = money - PriceB;
					}else if(selectProduct.equals(product[2])) {
						if(PriceC > money) {
							checkMore = true;
							break;
						}
						System.out.println("your select :"+product[2]);
						money = money - PriceC;
					}

					System.out.println("want more select product? y or n");
					String checkMoreString = scan.next();
					if(checkMoreString.equals("y")) {

					}else {
						System.out.println("your change : "+money+ " good bye");
						checkMore = false; 
					}
				}
			}
		}
	}

}
