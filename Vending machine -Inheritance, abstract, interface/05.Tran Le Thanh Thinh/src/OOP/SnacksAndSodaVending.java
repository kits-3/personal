package OOP;

public class SnacksAndSodaVending extends Machine {
	

	public SnacksAndSodaVending() {
		this.setId(3);
		this.setName("Snacks And Soda Vending");
	}

	public SnacksAndSodaVending(Integer id, String name) {

	}

	@Override
	public void selectMachine() {
		System.out.println("You selectting Snacks And Soda Vending");
	}
	

}
