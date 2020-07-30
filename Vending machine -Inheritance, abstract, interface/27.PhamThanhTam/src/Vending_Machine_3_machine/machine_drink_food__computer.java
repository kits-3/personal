package Vending_Machine_3_machine;

import java.util.HashMap;

import Vending_Machine_3_machine.interfaceMachine.IMachine;
import Vending_Machine_3_machine.interfaceMachine.impl.Machine;

public class machine_drink_food__computer {
	machine_drink_food__computer(String a,String b, String c, int d, int e, int f,int money) {
		
		String[] product = {a,b,c};
		int[] productPrice = {d, e, f};
		HashMap<String, Integer> orderProduct = new HashMap<>();
		orderProduct.put(product[0], 0);
		orderProduct.put(product[1], 0);
		orderProduct.put(product[2], 0);	
		boolean checkMore = true;
		IMachine machine = new Machine();
		machine.order_machine(checkMore,money,product,productPrice,orderProduct.get(product[0]),orderProduct.get(product[1]),orderProduct.get(product[2]),orderProduct);
	}
	
}
