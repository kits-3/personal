package Vending_Machine_3_machine.interfaceMachine;

import java.util.HashMap;

public interface IMachine {
	boolean test_Product(String selectProduct, String product);
	boolean test_Product_Price(int productPrice, int money);
	void information(int productPrice, String product, int money);
	void order_machine(boolean checkMore, int money,String[] product,int[] productPrice,int count1,int count2 , int count3,HashMap<String,Integer> orderProduct );

}
