package home.orderFood.entity;




public class storeEntity {
	private int id;
	private String nameStore;
	private String nameProduct;
	public storeEntity(){
		
	}
	public storeEntity(int id,String nameStore,String nameProduct) {
		this.id=id;
		this.nameStore=nameStore;
		this.nameProduct=nameProduct;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameStore() {
		return nameStore;
	}
	public void setNameStore(String nameStore) {
		this.nameStore = nameStore;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	
	
	
}
