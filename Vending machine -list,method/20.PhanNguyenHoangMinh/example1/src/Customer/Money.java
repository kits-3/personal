package Customer;
import java.security.GeneralSecurityException;
import java.util.*;

public class Money {
	
	public static int customerMoney;

	public Money(){
		
	}
	
	
	
	
	public int reCalculateChangeMoney(int givenProductPrice){
		customerMoney -= givenProductPrice;
		return customerMoney;
	}
	
	public boolean checkInsertedMoneyWithMinCosProduct(int insertedMoney, Set<Product> productSet){
		Iterator<Product> productIterator = productSet.iterator();
		List<Integer> priceList = new ArrayList<Integer>();
		while(productIterator.hasNext()){
			Product currentProduct = productIterator.next();
			priceList.add(currentProduct.getProductPrice());
		}
		if (insertedMoney >= getMinPrice(priceList)){
			return true;
		}else {
			return false;
		}
	}
	
	private int getMinPrice(List<Integer> priceList){
		int min = priceList.get(0);
		for(int i=1; i < priceList.size(); ++i){
			int currentPrice = priceList.get(i);
			if(currentPrice < min){
				min = currentPrice;
			}
		}
		return min;
	}

	public void returnMoney(){
		
	}
	
	
}
