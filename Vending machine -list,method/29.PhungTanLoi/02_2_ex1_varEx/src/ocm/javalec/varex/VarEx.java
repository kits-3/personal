package ocm.javalec.varex;

import java.util.ArrayList;
import java.util.Scanner;

public class VarEx {
	static int money = 0;
	public static boolean check(int a, int b) {
		return a > b;
	}
	public static boolean testProduct(String a, String b) {
		return a.equals(b);
	}
	public static void changed(String a, int b)
	{
		System.out.println("your select :"+a);
		money -= b;
	}
	public static void main(String[] args) {
		ArrayList<String> name = new ArrayList<String>();
		name.add("coca");
		name.add("juice");
		name.add("milk");
		ArrayList<Integer> price = new ArrayList<Integer>();
		price.add(1000);
		price.add(2000);
		price.add(3000);
 		boolean checkMoney = true;
		boolean checkMore = true;
		Scanner scan = new Scanner(System.in);
		while(checkMore) {
			System.out.println("please input money");
			money += scan.nextInt();
			System.out.println("check your money : "+ money);
			if(money < price.get(0) && money < price.get(1) && money < price.get(2)) {
				System.out.println("want more? please input y or n");
				String checkString = scan.next();
				if(checkString.equals("y")) {
					
				}else {
					System.out.println("good bye");
					checkMore = false;
				}
			}else {
				while(checkMore) {
					System.out.println("please select product 1."+name.get(0)+"("+price.get(0)+") 2."+name.get(1)+"("+price.get(1)+") 3."+name.get(2)+"("+price.get(2)+")");
					String selectProduct = scan.next();
					if(testProduct(selectProduct, name.get(0))) {
						if(check(price.get(0), money)) {
							checkMore = true;
							break;
						}
						changed(name.get(0),price.get(0));
					}else if(testProduct(selectProduct, name.get(1))) {
						if(check(price.get(1), money)) {
							checkMore = true;
							break;
						}
						changed(name.get(1),price.get(1));
					}else if(testProduct(selectProduct, name.get(2))) {
						if(check(price.get(2), money)) {
							checkMore = true;
							break;
						}
						changed(name.get(2),price.get(2));
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
