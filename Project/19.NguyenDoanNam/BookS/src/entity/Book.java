package entity;

public class Book {

	private int Book_id;
	private String Book_name;
	private String Athor;
	private int Price;
	private int Amount;
	private int Category_id;
	private int Status;
	
	public Book() {
		
	}
	public Book(int book_id, String book_name, String athor, int price, int amount, int category_id, int status) {
		Book_id = book_id;
		Book_name = book_name;
		Athor = athor;
		Price = price;
		Amount = amount;
		Category_id = category_id;
		Status = status;
	}
	
	public int getBook_id() {
		return Book_id;
	}
	public void setBook_id(int book_id) {
		Book_id = book_id;
	}
	public String getBook_name() {
		return Book_name;
	}
	public void setBook_name(String book_name) {
		Book_name = book_name;
	}
	public String getAthor() {
		return Athor;
	}
	public void setAthor(String athor) {
		Athor = athor;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public int getCategory_id() {
		return Category_id;
	}
	public void setCategory_id(int category_id) {
		Category_id = category_id;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	
	
	
	
	
	
}
