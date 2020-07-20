package Vending_Machine_3_machine;

import java.util.HashMap;

import Vending_Machine_3_machine.main.order;

public class machine_1_drink{
	machine_1_drink(String a,String b, String c, int d, int e, int f) {
		int money = 0;
		String[] product = {a,b,c};
		int[] productPrice = {d, e, f};
		HashMap<String, Integer> orderProduct = new HashMap<>();
		orderProduct.put(product[0], 0);
		orderProduct.put(product[1], 0);
		orderProduct.put(product[2], 0);	
		boolean checkMore = true;
		order odOrder = new order();
		odOrder.order_machine(checkMore,money,product,productPrice,orderProduct.get(product[0]),orderProduct.get(product[1]),orderProduct.get(product[2]),orderProduct);
	}
	
}
