
import java.util.Scanner;

import com.impl.DrinkVendingImpl;

public class MultiVending {
	static int money = 0;
	public static void main(String[] args) {
		DrinkVendingImpl drinkVendingImpl = new DrinkVendingImpl();
		drinkVendingImpl.getListDrink();
		int[] arrMoney = {drinkVendingImpl.getLowestMoney(money)};
		Thread thread = new Thread(drinkVendingImpl);
		
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
				money =  drinkVendingImpl.selectProduct(money, productNum);
				drinkVendingImpl.printReceipt();
				thread.start();
				System.out.println("---------------------------------");
				System.out.println("Your change is: "+money);
				transaction = false;
				break;
			case 2:

				break;
			case 3:

				break;

			default:
				break;
			}
			if(money >= lowestMoney){
                System.out.println("Ban co muon tiep tuc? Y/N");
                String cont = scanner.next();
                if(cont.equalsIgnoreCase("Y")){
                	transaction = true;
                }
                else{
                	transaction = false;
                }
            }
            else{
            	transaction = false;
            }
		}


		scanner.close();
	}

}
