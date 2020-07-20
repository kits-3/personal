package Customer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class VendingMachine{
	
	public VendingMachine(){
	}
	
	public boolean enoughMoneyWithSelectedProductPrice(int option, Set<Product> productSet){
		List<Product> productList = new ArrayList<>(productSet);
		int selectedProductPrice = productList.get(option-1).getProductPrice();
		if(selectedProductPrice > Money.customerMoney){
			return false;
		}
		return true;
	}
	
}
