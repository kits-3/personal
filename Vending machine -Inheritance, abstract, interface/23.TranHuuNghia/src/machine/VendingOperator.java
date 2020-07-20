package machine;

import java.util.Scanner;

public abstract class VendingOperator{
	int money = 0;
	Scanner sc = new Scanner(System.in);
	
	public int SelectMachine() {
		int choose;
		System.out.println("----------Select Machine-------------");
		System.out.println("1.Machine Drink");
		System.out.println("2.Machine food");
		System.out.println("-------------------------------------");
		System.out.print("Please input 1 or 2: ");
		choose = sc.nextInt();
		return choose;
		
	}
	public abstract int minCost();
	public abstract void showMenu();
	public abstract int inputmoney();
	public abstract String chooseProduct();
	public abstract int checkMoney();
	public abstract String checkProduct();
	public abstract int addMoney(int money);


}


