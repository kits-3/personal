package vending;

import java.util.HashMap;
import java.util.Scanner;

import vending.Interface.IMachine;
import vending.Interface.impl.Machine;

public class vending3 {
	vending3(){

		String[] product = { "chikendog", "pizagog", "riceogo" };
		int[] productPrice = { 1000, 2000, 3000 };


		HashMap<String, Integer> orderProduct = new HashMap<>();

		orderProduct.put(product[0], 0);
		orderProduct.put(product[1], 0);
		orderProduct.put(product[2], 0);

	int PriceA = 100 ;
	int PriceB = 200 ;
	int PriceC = 300 ;

	boolean checkMoney = true;
	boolean checkMore = true;

	IMachine ma = new Machine();
	ma.machine_main(checkMore, PriceA, PriceB, PriceC, product);
	}
}
