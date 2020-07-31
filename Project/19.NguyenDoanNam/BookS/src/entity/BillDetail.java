package entity;

public class BillDetail {
	private int BillDetail_id;
	private int Book_id;
	private int Number;
	private int Bill_id;

	public BillDetail() {

	}

	public BillDetail(int billDetail_id, String gmail, int book_id, int number, int bill_id) {
		BillDetail_id = billDetail_id;
		Book_id = book_id;
		Number = number;
		Bill_id = bill_id;
	}

	public int getBillDetail_id() {
		return BillDetail_id;
	}

	public void setBillDetail_id(int billDetail_id) {
		BillDetail_id = billDetail_id;
	}
	public int getBook_id() {
		return Book_id;
	}

	public void setBook_id(int book_id) {
		Book_id = book_id;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public int getBill_id() {
		return Bill_id;
	}

	public void setBill_id(int bill_id) {
		Bill_id = bill_id;
	}

}
