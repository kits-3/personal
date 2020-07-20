package machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class drink extends machine {
	/*
	 * drink() { super(); }
	 */


public static void main(String[] args) {
	drink d=new drink();
	 //List<String> product = new ArrayList();
	 //List<Integer> productPrice = new ArrayList();
		d.product.add("coca");
		d.product.add("milk");
		d.product.add("coki");
		d.product.add("juice");
			
		d.productPrice.add(600);
		d.productPrice.add(400);
		d.productPrice.add(900);
		d.productPrice.add(100);
	 
		
		money=d.inputMoney(money);	
		int min=0;
		min=d.minMoney(min);
		d.checkMoney();
	
}
	
}

	


