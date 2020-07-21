package VendingMachine_OOP;

import java.util.List;
import java.util.Map;

public interface VendingMachine {
	
	long selectItemAndGetPrice(Item item);
	
	void insertCoin(Coin coin);
	
	List<Coin> refund();
	
	Map<Bucket, List<Coin>> colectitemAndChange();
	
	void reset();

}
