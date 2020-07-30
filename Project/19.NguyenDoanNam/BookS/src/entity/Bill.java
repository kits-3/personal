package entity;

public class Bill {
	private int Bill_id;
	private String Gmail;
	private int Total;

	public Bill() {

	}

	public Bill(int bill_id, String gmail, int total) {
		Bill_id = bill_id;
		Gmail = gmail;
		Total = total;
	}

	public int getBill_id() {
		return Bill_id;
	}

	public void setBill_id(int bill_id) {
		Bill_id = bill_id;
	}

	public String getGmail() {
		return Gmail;
	}

	public void setGmail(String gmail) {
		Gmail = gmail;
	}

	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		Total = total;
	}

	
	
	}
