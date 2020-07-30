package machinevending;

public class Noodle extends Product implements IHandle {
	
	public Noodle() {
	}
	
	public Noodle(int cost, String name, int count) {
		this.setCost(cost);
		this.setName(name);
		this.setCount(count);
	}
	@Override
	public void create() {
		System.out.println("Add a noodle");
	}

	@Override
	public void update() {
		System.out.println("Update a noodle");
	}

	@Override
	public void delete() {
		System.out.println("Delete a noodle");
	}

	@Override
	public void count() {
		if(this.getCount() == 0) {
			System.out.println("Noodle is sold");
		}
	}
}
