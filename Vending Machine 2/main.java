
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class main {
	static int money = 0;

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("coke", 100);
		map.put("beer", 200);
		map.put("juice", 300);
		boolean checkMoney = true;
		boolean checkMore = true;
		Integer minPrice = map.values().stream().min(Integer::compare).get();
		Scanner scan = new Scanner(System.in);
		Object[] keys = map.keySet().toArray();
		while(checkMore) {
			System.out.println("please input money");
			money += scan.nextInt();
			System.out.println("check your money : "+ money);
			// kiem tra tien du mua toi thieu 1 sp. Neu ko du thi nhap nap them
			if(money < minPrice ) {
				System.out.println("want more? please input y or n");
				String checkString = scan.next();
				if(checkString.equals("y")) {
					System.out.println("vua nhan y");
				}else {
					System.out.println("good bye");
					checkMore = false;
				}
			}
			
			// tien hanh nhap ten sp mun mua va kiem ra tien nhap du mua sp hay ko. Neu ko du thi nhap nap them
			else {
				while(checkMore) {
					//in tat ca ten sp co trong db => in ra tat ca key
					System.out.println("===========================");
					int num = 1;
					for ( String key : map.keySet() ) {
					    System.out.println(num+"." + key + " price :" +map.get(keys[0]) );
					    num++ ;
					    
					}
					System.out.println("===========================");
					
					// nhap ten san pham muon mua
					System.out.println("Please choose your product: ");
					String selectProduct = scan.next();
					
				
					if(selectProduct.equals("coke")) {
						System.out.println("your select :"+ "coke");
						money = money - map.get("coke"); 
					}else if(selectProduct.equals("coke")){
						if(map.get("coke") > money) {
							checkMore = true;
							break;
						}
						System.out.println("your select :"+ "beer");
						money = money -  map.get("beer");
					}else if(selectProduct.equals("juice")) {
						if(map.get("juice") > money) {
							checkMore = true;
							break;
						}
						System.out.println("your select :" + "juice");
						money = money -  map.get("juice");
					}
					
					System.out.println("want more select product? y or n");
					String checkMoreString = scan.next();
					if(checkMoreString.equals("y")) {
						
					}else {
						System.out.println("your change : "+money+ " good bye");
						checkMore = false; 
					}
					break;
				}
			}
		}

	}

}