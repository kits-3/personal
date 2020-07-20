package Vending_Machine_3_machine.interfaceMachine;

public interface IMachine {
	boolean test_Product(String selectProduct, String product);
	boolean test_Product_Price(int productPrice, int money);
	void information(int productPrice, String product, int money);
}
