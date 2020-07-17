package Customer;

import java.util.HashSet;
import java.util.Set;

public class Store {

	private static Set<Product> productSet;
	
	public Store(){
		productSet = new HashSet<Product>();
	}
	
	public void addNewProduct(Product product){
		productSet.add(product);
	}
	
	
}
