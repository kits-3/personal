package VendingMachine;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Product {
	static int money = 0;
	static ArrayList<Integer> productPriceList = new ArrayList<Integer>();
	static ArrayList<String> productNameList = new ArrayList<String>();
	public static boolean checkMoney(String selectProduct)
	{
		for(int i=0; i<productNameList.size(); i++)
		{
			if(selectProduct.equals(productNameList))
			{
				if(productPriceList.get(i)>money)
				{
					return false;
				}
				System.out.println("your product: " + productNameList.get(i));
				money -= productPriceList.get(i);
				
			}
			
		}
		return false;
		
	}
	public static void main(String[] args) {
		productPriceList.add(100);
		productPriceList.add(200);
		
		productNameList.add("soju");
		productNameList.add("lemon");
		productNameList.add("apple");
		
		boolean checkMoney = true;
		boolean checkMore = true;
		
		Scanner scan = new Scanner(System.in);
		while(checkMore) {
			System.out.println("please input money");
			money += scan.nextInt();
			System.out.println("check your money : "+ money);
			if(checkMoney==true) {
				System.out.println("want more? please input y or n");
				String checkString = scan.next();
				if(checkString.equals("y")) {
					
				}else {
					System.out.println("good bye");
					checkMore = false;
				}
			}else {
//				while(checkMore) {
//					System.out.println("please select product 1."+productA+"("+productAPrice+") 2."+productB+"("+productBPrice+") 3."+productC+"("+productCPrice+")");
//					String selectProduct = scan.next();
//					if(selectProduct.equals(productA)) {
//						System.out.println("your select :"+productA);
//						money = money - productAPrice; 
//					}else if(selectProduct.equals(productB)) {
//						if(productBPrice > money) {
//							checkMore = true;
//							break;
//						}
//						System.out.println("your select :"+productB);
//						money = money - productBPrice;
//					}else if(selectProduct.equals(productC)) {
//						if(productCPrice > money) {
//							checkMore = true;
//							break;
//						}
//						System.out.println("your select :"+productC);
//						money = money - productCPrice;
//					}
//					
//					System.out.println("want more select product? y or n");
//					String checkMoreString = scan.next();
//					if(checkMoreString.equals("y")) {
//						
//					}else {
//						System.out.println("your change : "+money+ " good bye");
//						checkMore = false; 
					}
				}
			}
		

		
		
	}





