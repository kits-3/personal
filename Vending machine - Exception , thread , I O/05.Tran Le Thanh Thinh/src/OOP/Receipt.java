package OOP;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
	public static List<Products> addReceipt (Products product) {
		List<Products> listReceipt = new ArrayList<Products>();
		listReceipt.add(product);
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		return listReceipt;
	}
}
