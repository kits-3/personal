package ocm.javalec.varex.vendingmachine;

import java.util.ArrayList;
import java.util.List;

import ocm.javalec.varex.Interface.IMachine;
import ocm.javalec.varex.Interface.impl.Machine;

public class VendingMachineThird {
	VendingMachineThird(){
		List<String> productName = new ArrayList<String>();
		productName.add("Snake");
		productName.add("Cake");
		productName.add("Cookie");
		List<String> price = new ArrayList<String>();
		price.add("700");
		price.add("800");
		price.add("2000");
		int yourMoney = 0;
		boolean status = true;
		IMachine ma = new Machine();
		ma.machine_main(productName, price, yourMoney, status);
	}
}
