
public class Drink {
	private String name;
	private int price;
	
	public Drink(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void getName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void getPrice(int price) {
		this.price = price;
	}
	
}
