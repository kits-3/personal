package OOP;

public class CandyVendingMachine extends Machine {

	public CandyVendingMachine() {
		this.setId(2);
		this.setName("Candy Vending Machine");
	}

	public CandyVendingMachine(Integer id, String name) {

	}

	@Override
	public void selectMachine() {

		System.out.println("You selectting Candy Vending Machine");
	}

}