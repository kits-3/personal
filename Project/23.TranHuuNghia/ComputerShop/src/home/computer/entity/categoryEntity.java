package home.computer.entity;

public class categoryEntity {
	private int id;
	private String CategoryName;
	public categoryEntity() {
		super();
	}
	public categoryEntity(int id, String categoryName) {
		super();
		this.id = id;
		CategoryName = categoryName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	
}
