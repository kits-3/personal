package parkingSystem.entity;

public class parking {
	private int id;
	private int id_car;
	private int id_park;
	private String position;
	private String price;
	private String date_in;
	private String date_out;
	
	public parking() {
		super();
	}

	public parking(int id, int id_car, int id_park, String position, String price, String date_in, String date_out) {
		super();
		this.id = id;
		this.id_car = id_car;
		this.id_park = id_park;
		this.position = position;
		this.price = price;
		this.date_in = date_in;
		this.date_out = date_out;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_car() {
		return id_car;
	}

	public void setId_car(int id_car) {
		this.id_car = id_car;
	}

	public int getId_park() {
		return id_park;
	}

	public void setId_park(int id_park) {
		this.id_park = id_park;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDate_in() {
		return date_in;
	}

	public void setDate_in(String date_in) {
		this.date_in = date_in;
	}

	public String getDate_out() {
		return date_out;
	}

	public void setDate_out(String date_out) {
		this.date_out = date_out;
	}
	
}
