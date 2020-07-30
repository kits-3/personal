package vendingMachine;

import java.util.Scanner;

public class objVendingMachine implements IFunction {
	
 
	@Override
	public int inputMoney(int money,boolean isNumber, Scanner sc) {
		do {
			System.out.print("input money 10 or 20 or 30 ...:  ");
			if(sc.hasNextInt()) {
				money =  sc.nextInt();
				isNumber = true;
			}else {
				System.out.println("Do you understand?");
				isNumber = false;
				sc.next();
			}
			
		} while (money % 10 != 0 || isNumber == false);
		return money;
	}

	@Override
	public int selectProduct() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int handleMoney() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
