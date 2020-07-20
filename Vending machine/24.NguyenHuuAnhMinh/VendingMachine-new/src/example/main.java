package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class main {
	static int money = 0;

	public static void main(String[] args) {
		String[] product = {"beer", "juice" , "milk"}; 
//		String productA = "beer";
//		String productB = "juice";
//		String productC = "milk";
		
//List<String> list = new ArrayList();
//	list.add("111111");
//	list.add("222222");
//	for(int i=0 ; i < list.size(); i++) {
//		list.get(i);
//		System.out.println("value = "+list.get(i));
//	}
//Map<String,Object> map = new HashMap<>();
//map.put("name","gwon youngjae" );
//map.put("age",27);
//System.out.println("value : "+map.get("age"));
//String[] array = {"11111","2222","3333"};
//for(int i=0 ; i < array.length ; i++) {
//	System.out.println("value : "+array[i]);
//}
//String[][] array2 = {{"1","2"},{"2","3"},{"3","4"}};
//array2[0][1] = "2";
//for(int i=0 ; i<array2.length; i++) {
//	for(int j=0; j<array2[i].length; j++) {
//		System.out.println("value : : "+array2[i][j]);
//	}
//}

		int productAPrice = 1000 ;
		int productBPrice = 200 ;
		int productCPrice = 300 ;
		
		boolean checkMoney = true;
		boolean checkMore = true;
		
		Scanner scan = new Scanner(System.in);
		while(checkMore) {
			System.out.print("please input money: ");
			money += scan.nextInt();
			System.out.println("check your money : "+ money);
			if(money < productAPrice && money < productBPrice && money < productCPrice) {
				System.out.print("want more? please input y or n: \n");
				String checkString = scan.next();
				if(checkString.equals("y")) {
					
				}else {
					System.out.println("good bye");
					checkMore = false;
				}
			}else {
				boolean checkMoreProduct = true;
				while(checkMoreProduct) {
					System.out.println("please select product 1."+product[0]+"("+productAPrice+") 2."+product[1]+"("+productBPrice+") 3."+product[2]+"("+productCPrice+")");
					String selectProduct = scan.next();
					if(selectProduct.equals(product[0])) {
						if(productAPrice <= money) {
							checkMoreProduct = true;
						}else{
							System.out.println("You don't have enough money");
							checkMoreProduct = false;
							break;
						}
						System.out.println("your select :"+product[0]);
						money = money - productAPrice; 
						System.out.println("You now have "+ money + "$ left" );
					}else if(selectProduct.equals(product[1])) {
						if(productBPrice <= money) {
							checkMoreProduct = true;
						}
						else{
							System.out.println("You don't have enough money");
							checkMoreProduct = false;
							break;
						}
						System.out.println("your select :"+product[1]);
						money = money - productBPrice;
						System.out.println("You now have "+ money + "$ left" );
					}else if(selectProduct.equals(product[2])) {
						if(productCPrice <= money) {
							checkMoreProduct = true;
						}
						else{
							System.out.println("You don't have enough money");
							checkMoreProduct = false;
							break;
						}
						System.out.println("your select :"+product[2]);
						money = money - productCPrice;
						System.out.println("You now have "+ money + "$ left" );
					}else{
						System.out.println("Product not serve");
					}
					
					System.out.println("want more select product? y or n");
					String checkMoreString = scan.next();
					if(checkMoreString.equals("y")) {
						checkMore = true;
					}else if(checkMoreString.equals("n")){
						System.out.println("your change : "+money+ " good bye");
						checkMore = false; 
						break;
					}
				}
			}
		}

	}

}
