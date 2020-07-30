package parkingSystem.entity;

public class car {
	private int id;
	private int id_user;
	private String brand;
	private String color;
	
	public car() {
		super();
	}

	public car(int id, int id_user, String brand, String color) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.brand = brand;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
