package home.computer.entity;

public class orderDetailEntity {
	private int id, Quantity;
	private int idOrder;
	private String  id_productName;
	
	public orderDetailEntity() {
		super();
	}

	public orderDetailEntity(int id, int quantity, int idOrder, String id_productName) {
		super();
		this.id = id;
		Quantity = quantity;
		this.idOrder = idOrder;
		this.id_productName = id_productName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public String getId_productName() {
		return id_productName;
	}

	public void setId_productName(String id_productName) {
		this.id_productName = id_productName;
	}

	
	
}
