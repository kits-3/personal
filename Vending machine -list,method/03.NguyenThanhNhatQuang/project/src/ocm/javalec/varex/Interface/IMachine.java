package ocm.javalec.varex.Interface;

import java.util.List;

public interface IMachine {
	int inputMoney ();
	void outputMoney (int yourMoney);
	void currentMoney (int yourMoney);
	int findProductMinPrice (List<String> productName, List<String> price);
	void showMenu (int yourMoney,List<String> productName, List<String> price);
	boolean checkMoney (int yourMoney, int productMoney);
	boolean isUserContinue (String choose);
	boolean isYourMoneyMoreThanProductSelect(int yourMoney, int yourProduct, List<String> productName, List<String> price);
	void alertMoneyLessMinProductCost (int yourMoney, int minCost);
	void alertMoneyLessSelectProductCost (int yourMoney, int yourProduct, List<String> productName, List<String> price);
	void alertBuyProductSuccess(int yourProduct, List<String> productName, List<String> price); 
	int theAmountMoneyYouNeed(int yourMoney, int yourProduct, List<String> productName, List<String> price);
	String ynQuestion ();
	int chooseProduct(List<String> productName, List<String> price) ;
	void machine_main (List<String> productName, List<String> price, int yourMoney, boolean status);
}
