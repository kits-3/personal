package AdminEntity;

public class ProductAdmin {
	
	private int id;
	private int cate_id;
	private String name;
	private int price;
	private String detail;
	
	public ProductAdmin(int id, int cate_id, String name, int price, String detail) {

		this.id = id;
		this.cate_id = cate_id;
		this.name = name;
		this.price = price;
		this.detail = detail;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public ProductAdmin() {

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
