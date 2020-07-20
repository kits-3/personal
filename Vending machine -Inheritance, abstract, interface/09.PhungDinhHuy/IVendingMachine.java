package VendingMaChineOOP2;

public interface IVendingMachine {

	double insertMoney();
	
	int chooseProduct();
	
	Product getProductList(int index_Product);
	
	boolean isWantContinue(String str);
	
	void run();
	
	
}
