package ocm.javalec.varex.vendingmachine;

import java.util.ArrayList;
import java.util.List;

import ocm.javalec.varex.Interface.IMachine;
import ocm.javalec.varex.Interface.impl.Machine;

public class VendingMachineSecond {
	VendingMachineSecond(){
		List<String> productName = new ArrayList<String>();
		productName.add("Fizz");
		productName.add("Rice");
		List<String> price = new ArrayList<String>();
		price.add("10000");
		price.add("12000");
		int yourMoney = 0;
		boolean status = true;
		IMachine ma = new Machine();
		ma.machine_main(productName, price, yourMoney, status);
	}
}
