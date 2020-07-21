package machinevending;

public class Drink extends Product implements IHandle {
	public Drink() {
	}
	public Drink(int cost, String name, int count) {
		this.setCost(cost);
		this.setName(name);
		this.setCount(count);
	}
	@Override
	public void create() {
		System.out.println("Add a drink");
	}

	@Override
	public void update() {
		System.out.println("Update a drink");
	}

	@Override
	public void delete() {
		System.out.println("Delete a drink");
	}

	@Override
	public void count() {
		if(this.getCount() == 0) {
			System.out.println("Drink is sold");
		}
	}
}
