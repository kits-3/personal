package machinevending;

public class Candy extends Product implements IHandle{

	public Candy() {
	}
	
	public Candy(int cost, String name,int count) {
		this.setCost(cost);
		this.setName(name);
		this.setCount(count);
	}
	
	@Override
	public void create() {
		System.out.println("Add a candy");
	}

	@Override
	public void update() {
		System.out.println("Update a candy");
	}

	@Override
	public void delete() {
		System.out.println("Delete a candy");
	}

	@Override
	public void count() {
		if(this.getCount() == 0) {
			System.out.println("Candy is sold");
		}
	}

}
