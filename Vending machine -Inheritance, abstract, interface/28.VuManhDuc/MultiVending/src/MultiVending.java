
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.entity.Drink;
import com.impl.DrinkVendingImpl;

public class MultiVending {
	static int money = 0;

	public static void main(String[] args) {
		DrinkVendingImpl drinkVendingImpl = new DrinkVendingImpl();
		drinkVendingImpl.getListDrink();
		int[] arrMoney = {drinkVendingImpl.getLowestMoney(money)};
		int lowestMoney = arrMoney[0];
		for (int i = 0; i < arrMoney.length; i++) {
			if(lowestMoney > arrMoney[i]) {
				lowestMoney = arrMoney[i];
			}
		}
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Nhap vao so tien: ");
			money = scanner.nextInt();
		} while (money < lowestMoney);
		boolean transaction = true;
		while (transaction) {

			System.out.println("1. Drink ------- 2. Food --------- 3. Sthing");
			System.out.print("Select a compatible transaction number: ");
			int tran = scanner.nextInt();
			switch (tran) {
			case 1:
				drinkVendingImpl.displayDrinks();
				System.out.println("---------------------------------");
				System.out.print("Choose a drink you want to buy:");
				int productNum = scanner.nextInt();
				//money = money - drinkVendingImpl.selectProduct(money, productNum);
				money = money - drinkVendingImpl.selectProduct(money, productNum);
				System.out.println("---------------------------------");
				System.out.print("Your change is: "+money);
				transaction = false;
				break;
			case 2:

				break;
			case 3:

				break;

			default:
				break;
			}
//			if(money >= lowestPrice(arrPrice)){
//                System.out.println("Ban co muon tiep tuc? Y/N");
//                String cont = scanner.next();
//                if(cont.equalsIgnoreCase("Y")){
//                    checkMoney = true;
//                }
//                else{
//                    checkMoney = false;
//                }
//            }
//            else{
//                checkMoney = false;
//            }
		}

//		drinkVendingImpl.displayDrinks();
//		
//		System.out.println(money);

		scanner.close();
	}

}
