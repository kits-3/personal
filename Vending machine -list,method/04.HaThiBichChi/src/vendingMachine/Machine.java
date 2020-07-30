package vendingMachine;

import java.util.ArrayList;
import java.util.Scanner;

public  class Machine implements IFunction {
	
	private int id;
	private String name;
	@Override
	public int selectName(Scanner sc, int machineSl, boolean isSl) {
		for (int i = 0; i < machine.length; i++) {
			System.out.println("machine: " + i + " " + machine[i] );
		}
		do {
			System.out.print("You select machine number: ");
			if(sc.hasNextInt()) {
				machineSl = sc.nextInt();
				if(machineSl != 0 && machineSl != 1 && machineSl != 2) {
					System.out.println("Do you select number before machine?");
					isSl = false;
				}else {
					isSl = true;
				}
				
			}else {
				System.out.println("Do you understand?");
				sc.next();
			}
		} while (isSl == false);
		return machineSl;
		 
	}
	
	
	@Override
	public int inputMoney(int money, boolean isNumber, Scanner sc) {
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
	public void showProduct() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public ArrayList<String> selectProduct(String product, ArrayList<String> products) {
		// TODO Auto-generated method stub
		products.add(product);
		return products;
	}

	@Override
	public int handleMoney(ArrayList<String> products, int money, int moneyStart) {
		// TODO Auto-generated method stub
		for (int i = 0; i < products.size(); i++) {
			 
		}
		return 0;
	}
	
}
//private int id;
//private String name;
//
//IFunction Machine = new Machine();
//
//public int getId() {
//	return id;
//}
//public void setId(int id) {
//	this.id = id;
//}
//public String getName() {
//	return name;
//}
//public void setName(String name) {
//	this.name = name;
//}
//
//public Machine() {
//	this.id = 0;
//	this.name = "Machine";
//}
//@Override
//public void selectName() {
//	// TODO Auto-generated method stub
//	
//}
//
 
//
//
//@Override
//public int selectProduct() {
//	// TODO Auto-generated method stub
//	return 0;
//}
//@Override
//public int handleMoney() {
//	// TODO Auto-generated method stub
//	return 0;
//}
//@Override
//public void showProduct() {
//	// TODO Auto-generated method stub
//	for (int i = 0; i < fruit.length; i++) {
//		System.out.println("you select products: " + fruit[i]);
//	}
//}
//
//@Override
//public String checkSelectMachine(Machine,Scaner sc) {
//	// TODO Auto-generated method stub
//	
//	
//	return null;
//}
