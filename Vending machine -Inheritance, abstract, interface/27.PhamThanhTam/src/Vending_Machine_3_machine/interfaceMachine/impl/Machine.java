package Vending_Machine_3_machine.interfaceMachine.impl;

import Vending_Machine_3_machine.interfaceMachine.IMachine;

public class Machine implements IMachine{

	@Override
	public boolean test_Product(String selectProduct, String product) {
		return selectProduct.equals(product);
	}

	@Override
	public boolean test_Product_Price(int productPrice, int money) {
		return productPrice > money;
	}

	@Override
	public void information(int productPrice, String product, int money) {
		System.out.println("your select : " + product);
		money -= productPrice;
		
	}

}
