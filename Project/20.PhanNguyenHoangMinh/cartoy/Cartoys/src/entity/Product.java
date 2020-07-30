package entity;

public class Product {
	
	private int id;
	private int cate_id;
	private String name;
	private int price;
	
	public Product(int id, int cate_id, String name, int price, int brand_id) {

		this.id = id;
		this.cate_id = cate_id;
		this.name = name;
		this.price = price;

	}

	public Product() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
}
