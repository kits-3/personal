package OOP;

import java.util.ArrayList;
import java.util.List;

public class SnacksAndSodaVending extends Machine {

	private List<Products> listProducts;

	public SnacksAndSodaVending() {
		super();
		this.setId(3);
		this.setName("Snacks And Soda Vending");
		listProducts = new ArrayList<Products>();
		Products products1 = new Products(1, "Cookies", 5 , 50);
		Products products2 = new Products(1, "Cheese", 5 , 100);
		Products products3 = new Products(1, "Pop corn", 5 , 200);
		listProducts.add(products1);
		listProducts.add(products2);
		listProducts.add(products3);
		
	}

	public SnacksAndSodaVending(Integer id, String name) {

	}

	public List<Products> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Products> listProducts) {
		this.listProducts = listProducts;
	}


}
