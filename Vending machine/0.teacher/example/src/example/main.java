package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class main {
	static int money = 0;

	public static void main(String[] args) {
		String productA = "beer";
		String productB = "juice";
		String productC = "milk";
		
List<String> list = new ArrayList();
	list.add("111111");
	list.add("222222");
	for(int i=0 ; i < list.size(); i++) {
		list.get(i);
		System.out.println("value = "+list.get(i));
	}
Map<String,Object> map = new HashMap<>();
map.put("name","gwon youngjae" );
map.put("age",27);
System.out.println("value : "+map.get("age"));
String[] array = {"11111","2222","3333"};
for(int i=0 ; i < array.length ; i++) {
	System.out.println("value : "+array[i]);
}
String[][] array2 = {{"1","2"},{"2","3"},{"3","4"}};
array2[0][1] = "2";
for(int i=0 ; i<array2.length; i++) {
	for(int j=0; j<array2[i].length; j++) {
		System.out.println("value : : "+array2[i][j]);
	}
}

		int productAPrice = 1000 ;
		int productBPrice = 200 ;
		int productCPrice = 300 ;
		
		boolean checkMoney = true;
		boolean checkMore = true;
		
		Scanner scan = new Scanner(System.in);
		while(checkMore) {
			System.out.println("please input money");
			money += scan.nextInt();
			System.out.println("check your money : "+ money);
			if(money < productAPrice && money < productBPrice && money < productCPrice) {
				System.out.println("want more? please input y or n");
				String checkString = scan.next();
				if(checkString.equals("y")) {
					
				}else {
					System.out.println("good bye");
					checkMore = false;
				}
			}else {
				while(checkMore) {
					System.out.println("please select product 1."+productA+"("+productAPrice+") 2."+productB+"("+productBPrice+") 3."+productC+"("+productCPrice+")");
					String selectProduct = scan.next();
					if(selectProduct.equals(productA)) {
						System.out.println("your select :"+productA);
						money = money - productAPrice; 
					}else if(selectProduct.equals(productB)) {
						if(productBPrice > money) {
							checkMore = true;
							break;
						}
						System.out.println("your select :"+productB);
						money = money - productBPrice;
					}else if(selectProduct.equals(productC)) {
						if(productCPrice > money) {
							checkMore = true;
							break;
						}
						System.out.println("your select :"+productC);
						money = money - productCPrice;
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
