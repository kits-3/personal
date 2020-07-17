package vendingMachine;

import java.util.Scanner;

public class vendingMachine {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int money;
		int tienbandau;
		String cf;
		do {
			System.out.print("Nhap So tien cua ban la so chan % 10 = 0: ");
			money = sc.nextInt();
		} while (money % 10 != 0);
		
		do {
			System.out.print("Moi ban lua loai nuoc muon mua: 1.coca(10VND) / 2.pessi(20VND) / 3.milk(30VND): ");
			int lc = sc.nextInt();
			if(lc == 1) {
				tienbandau = money;
				money = money - 10;
				if(money >= 0) {
					System.out.println("So tien du la: " + money + "VND");
				}else if(money < 0) {
					System.out.println("So tien con thieu la: " + money + "VND" + " vui long nap them tien de mua");
					System.out.println("vui long nhan lai so tien: " + tienbandau + "VND" );
					return;
				}
			}else if(lc == 2) {
				tienbandau = money;
				money -= 20;
				if(money >= 0) {
					System.out.println("So tien du la: " + money + "VND");
				}else if(money < 0) {
					System.out.println("So tien con thieu la: " + money + "VND" + " vui long nap them tien de mua");
					System.out.println("vui long nhan lai so tien: " + tienbandau + "VND" );
					return;
				}
			}else if(lc == 3) {
				tienbandau = money;
				money -=30;
				if(money >= 0) {
					System.out.println("So tien du la: " + money + "VND");
				}else if(money < 0) {
					System.out.println("So tien con thieu la: " + money + "VND" + " vui long nap them tien de mua");
					System.out.println("vui long nhan lai so tien: " + tienbandau + "VND" );
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
			return;
		}else {
			System.out.print("Hen gap lai!");
			return;
		}
	}
	 

}
