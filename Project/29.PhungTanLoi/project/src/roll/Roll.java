package roll;

public class Roll {
	private int id;
	private String rollname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRollname() {
		return rollname;
	}

	public void setRollname(String rollname) {
		this.rollname = rollname;
	}

	public Roll(int id, String rollname) {
		super();
		this.id = id;
		this.rollname = rollname;
	}

	public Roll() {
		super();
	}

}
