package Customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VendingMachine {

	public VendingMachine() {
	}

	public boolean checkEnoughMoney(int currentMoney, int price){
		
		return true;
	}
	
	public boolean enoughMoneyWithSelectedProductPrice(int option, Set<Product> productSet) {
		List<Product> productList = new ArrayList<>(productSet);
		int selectedProductPrice = productList.get(option - 1).getProductPrice();
		if (selectedProductPrice > Money.customerMoney) {
			return false;
		}
		return true;
	}

	public boolean checkInsertedMoneyWithMinCosProduct(int currentMoney, Set<Product> productSet) {
		Iterator<Product> productIterator = productSet.iterator();
		List<Integer> priceList = new ArrayList<Integer>();
		while (productIterator.hasNext()) {
			Product currentProduct = productIterator.next();
			priceList.add(currentProduct.getProductPrice());
		}
		if (currentMoney >= getMinPrice(priceList)) {
			return true;
		} else {
			return false;
		}
	}

	private int getMinPrice(List<Integer> priceList) {
		int min = priceList.get(0);
		for (int i = 1; i < priceList.size(); ++i) {
			int currentPrice = priceList.get(i);
			if (currentPrice < min) {
				min = currentPrice;
			}
		}
		return min;
	}
	
	public void returnMoney(Customer customer) {
		System.out.println("Your change is: " + customer.getTotalMoney());
		System.out.println("Thank for using our service. See you again later.");
	}

}
