package entity;

public class Category_book {

	private int Category_id;
	private String Catogory_name;
	private int Status;
	
	public Category_book() {
	}

	public Category_book(int category_id, String catogory_name, int status) {
		Category_id = category_id;
		Catogory_name = catogory_name;
		Status = status;
	}

	public int getCategory_id() {
		return Category_id;
	}

	public void setCategory_id(int category_id) {
		Category_id = category_id;
	}

	public String getCatogory_name() {
		return Catogory_name;
	}

	public void setCatogory_name(String catogory_name) {
		Catogory_name = catogory_name;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}
	
	
	
	
	
	
	
	
}
