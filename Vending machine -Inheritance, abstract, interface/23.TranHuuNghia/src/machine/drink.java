package machine;

import java.util.ArrayList;
import java.util.List;

public class drink extends VendingOperator {
	
	public drink() {}
	

	
	@Override
	public void showMenu() {
		System.out.println("----------Select Menu-------------");
		System.out.println("1.Coca 100$");
		System.out.println("2.Sprite 200$");
		System.out.println("3.Fanta 300$");
		System.out.println("4.Pepsi 400$");
		System.out.println("-------------------------------------");
	}
	
	@Override
	public int inputmoney() {
		System.out.println("please input money: ");
		money = sc.nextInt();
		System.out.println("your money : " + money + "$");
		return money; 
	}
	
	@Override
	public int minCost (){
		int minCost =100;
		return minCost;
	}
	@Override
	public String chooseProduct() {
		String product;
		System.out.println("please select product");
		product = sc.next();
		return product;
	}
	
	@Override
	public int addMoney(int money) {
		System.out.println("want more money? please input y or n");
		String checkString = sc.next();
		if(checkString.equals("y")) {
			System.out.print("Plese input money change > 100: ");
			int moneyc = sc.nextInt();
			money += moneyc;
			System.out.println("money change: " + money);
			return money;
		}else {
			System.out.println("good bye and your money: " + money);
			return money;
		}
	}

	@Override
	public int checkMoney() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String checkProduct() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
