package vendingMachine;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vendingMachine {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int money;
		int tienbandau;
		String cf;
		List<String> arrDrink = new ArrayList<>();
		do {
			System.out.print("please input money: ");
			money = sc.nextInt();
		} while (money % 10 != 0);
		
		do {
			System.out.print("Moi ban lua loai nuoc muon mua: 1.coca(10VND) / 2.pessi(20VND) / 3.milk(30VND): ");
			int lc = sc.nextInt();
			if(lc == 1) {
				tienbandau = money;
				money = money - 10;
				 arrDrink.add("coca");
				if(money >= 0) {
					System.out.println("So tien du la: " + money + "VND");
				}else if(money < 0) {
					arrDrink.remove(arrDrink.size() - 1);
					System.out.println("So tien con thieu la: " + money + "VND" + " vui long nap them tien de mua");
					System.out.println("vui long nhan lai so tien: " + tienbandau + "VND" );
					for (int i = 0; i < arrDrink.size(); i++) {
							System.out.println("Ban da mua: " + arrDrink.get(i));
						}
					return;
				}
			}else if(lc == 2) {
				tienbandau = money;
				money -= 20;
				 arrDrink.add("pessi");
				if(money >= 0) {
					System.out.println("So tien du la: " + money + "VND");
				}else if(money < 0) {
					arrDrink.remove(arrDrink.size() - 1);
					System.out.println("So tien con thieu la: " + money + "VND" + " vui long nap them tien de mua");
					System.out.println("vui long nhan lai so tien: " + tienbandau + "VND" );
					for (int i = 0; i < arrDrink.size(); i++) {
							System.out.println("Ban da mua: " + arrDrink.get(i));
						}
					return;
				}
			}else if(lc == 3) {
				tienbandau = money;
				money -=30;
				 arrDrink.add("milk");
				if(money >= 0) {
					System.out.println("So tien du la: " + money + "VND");
				}else if(money < 0) {
					arrDrink.remove(arrDrink.size() - 1);
					System.out.println("So tien con thieu la: " + money + "VND" + " vui long nap them tien de mua");
					System.out.println("vui long nhan lai so tien: " + tienbandau + "VND" );
					for (int i = 0; i < arrDrink.size(); i++) {
							System.out.println("Ban da mua: " + arrDrink.get(i));
						}
					return;
				}
			}else {
				System.out.println("Chung toi khong co loa thuc uong nay !");
				break;
			}
			System.out.println("Ban co tiep tuc mua yes/no ?");
			cf = sc.next();
		} while (cf.equalsIgnoreCase("yes"));
		if(money > 0) {
			System.out.println("So tien con du la: " + money + "VND" +" vui long nhan lai tien");
			 if(arrDrink.size() > 0) {
				 for (int i = 0; i < arrDrink.size(); i++) {
					System.out.println("Ban da mua: " + arrDrink.get(i));
				}
				 return;
			 }else {
				 return;
			 }
		}else {
			 if(arrDrink.size() > 0) {
				 for (int i = 0; i < arrDrink.size(); i++) {
					System.out.println("Ban da mua: " + arrDrink.get(i));
				}
				 return;
			 }else {
				 System.out.print("Hen gap lai!");
				 return;
			 }
		}
	}
	 

}
