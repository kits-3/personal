package multiVending;
import java.util.Scanner;

public class FigureVendingMachine extends vending {
	int min_cost = 2000;
	@Override
	public int inputMoney() {
		// TODO Auto-generated method stub
		System.out.print("Input your money: ");
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		return money;
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("Please choose your product");
		System.out.println("1.Type1");
		System.out.println("2.Type2");
		System.out.println("3.Type3");
	}

	@Override
	public String inputProductName() {
		// TODO Auto-generated method stub
		System.out.print("Typing your product name: ");
		Scanner sc = new Scanner(System.in);
		String productName = sc.nextLine();
		return productName;
	}
	@Override
	public boolean checkMore(){
		System.out.println("Do you want to buy more? y or n ");
		Scanner sc = new Scanner(System.in);
		String check = sc.next();
		if(check.equals("y")){
			return true;
		}else if (check.equals("n")){
			System.out.println("Thank you ! Welcome back later !");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkMoney(int money) {
		if(money < min_cost){
			System.out.println("You dont have enough money!");
			return false;
		}
		else{
			return true;
		}
	}

}
