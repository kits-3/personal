package OOP;

public class RawMilkVendingMachine extends Machine  {

	public RawMilkVendingMachine(Integer id, String name) {


	}
	
	public RawMilkVendingMachine() {	
		this.setId(1);
		this.setName("Raw milk");
	}
	
	public void selectMachine() {
		System.out.println("You selectting raw milk machine");
	}
	
}
