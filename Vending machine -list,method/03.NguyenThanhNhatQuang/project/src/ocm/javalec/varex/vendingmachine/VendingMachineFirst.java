package ocm.javalec.varex.vendingmachine;

import java.util.ArrayList;
import java.util.List;

import ocm.javalec.varex.Interface.IMachine;
import ocm.javalec.varex.Interface.impl.Machine;

public class VendingMachineFirst {
	VendingMachineFirst(){
		List<String> productName = new ArrayList<String>();
		productName.add("Coca");
		productName.add("Pepsi");
		productName.add("Milk");
		List<String> price = new ArrayList<String>();
		price.add("10000");
		price.add("12000");
		price.add("15000");
		int yourMoney = 0;
		boolean status = true;
		IMachine ma = new Machine();
		ma.machine_main(productName, price, yourMoney, status);
	}
}
