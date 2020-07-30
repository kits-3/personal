package home.orderFood.entity;

public class ProductEntity {
	private int id;
	private String nameProduct;
	private String CodeProduct;
	private String priceProduct;
	private String speciesProduct;
	private String amountProduct;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public String getCodeProduct() {
		return CodeProduct;
	}
	public void setCodeProduct(String codeProduct) {
		CodeProduct = codeProduct;
	}
	public String getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(String priceProduct) {
		this.priceProduct = priceProduct;
	}
	public String getSpeciesProduct() {
		return speciesProduct;
	}
	public void setSpeciesProduct(String speciesProduct) {
		this.speciesProduct = speciesProduct;
	}
	public String getAmountProduct() {
		return amountProduct;
	}
	public void setAmountProduct(String amountProduct) {
		this.amountProduct = amountProduct;
	}
	
}
