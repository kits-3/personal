package home.computer.entity;

public class productEntity {
	
	private int id;
	private String id_category;
	private String ProductName;
	private int UnitPrice;
	private int UnitInStock;
	
	public productEntity() {
		super();
	}

	public productEntity(int id, String id_category, String productName, int unitPrice, int unitInStock) {
		super();
		this.id = id;
		this.id_category = id_category;
		ProductName = productName;
		UnitPrice = unitPrice;
		UnitInStock = unitInStock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId_category() {
		return id_category;
	}

	public void setId_category(String id_category) {
		this.id_category = id_category;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		UnitPrice = unitPrice;
	}

	public int getUnitInStock() {
		return UnitInStock;
	}

	public void setUnitInStock(int unitInStock) {
		UnitInStock = unitInStock;
	}
		
	
}
