package home.bike.entity;

public class ProductEntity {
	private int id_product;
	private String trademark;
	private String color;
	private Float  pirce;
	public ProductEntity() {};
	public ProductEntity(int id_product, String trademark, String color, Float pirce) {
		super();
		this.id_product = id_product;
		this.trademark = trademark;
		this.color = color;
		this.pirce = pirce;
		
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public String getTrademark() {
		return trademark;
	}
	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Float getPirce() {
		return pirce;
	}
	public void setPirce(Float pirce) {
		this.pirce = pirce;
	}
	
}
