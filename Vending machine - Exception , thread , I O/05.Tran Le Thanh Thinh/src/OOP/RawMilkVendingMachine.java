package OOP;

import java.util.ArrayList;
import java.util.List;

public class RawMilkVendingMachine extends Machine {
	private List<Products> listProducts;

	public RawMilkVendingMachine(Integer id, String name) {

	}

	public RawMilkVendingMachine() {
		super();
		this.setId(1);
		this.setName("Raw milk");
		listProducts = new ArrayList<Products>();
		Products products1 = new Products(1, "Snickers", 5, 50);
		Products products2 = new Products(1, "Kit Kat", 5, 100);
		Products products3 = new Products(1, "Skittles", 5, 200);
		listProducts.add(products1);
		listProducts.add(products2);
		listProducts.add(products3);
	}

	public List<Products> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Products> listProducts) {
		this.listProducts = listProducts;
	}





}
