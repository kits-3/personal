package vending;

public interface Vending {
	int inputMoney(int money); 
	void showProduct();
	boolean checkMore();
	boolean checkMoney(int money);
}
