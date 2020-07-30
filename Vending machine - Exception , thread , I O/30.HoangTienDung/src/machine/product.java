package machine;

public class product {
	private String name;
	private int price;
	public product(String name, int price) {
		this.name=name;
		this.price=price;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
