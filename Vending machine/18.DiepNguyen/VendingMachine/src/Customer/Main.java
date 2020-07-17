package Customer;
import java.util.*;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static Set<Product> productSet = new HashSet<Product>();
	
	private static void enterKindOfProductsQuantity(Scanner scanner){
		
	}
	
	public static void main(String[] args) {
		//import products into vending machine
		int noProductTypes = 0;
		Product product = null;
		ProductProcess pp = null; 
		int insertedMoney = 0;
		boolean enoughMoney = false;
		String cont = "";
		
		System.out.print("Admin: How many kind of products do you want to import: ");
		try{
			noProductTypes = Integer.valueOf(scanner.next());
		}catch(NumberFormatException nfe){
			System.out.println("Accept only number for num of Product Types!!!");
		}
		for(int i=1; i <= noProductTypes; ++i){
			pp = new ProductProcess();
			product = pp.insertProductsIntoVendingMachine(scanner);
			productSet.add(product);
		}
		
		Money money = new Money();
		while(true){
			insertedMoney = money.inputMoney(scanner);
			enoughMoney = money.checkInsertedMoneyWithMinCosProduct(insertedMoney, productSet);
			if(enoughMoney == true){
				break;
			}
			System.out.println("Not enough money. Do you want to continue (Y/N)? ");
			cont = scanner.next().toUpperCase();
			if(cont.equals("N")){
				break;
			}
		}
		
		if(cont.equals("N")){
			money.returnMoney();
		}else{
			pp.selectProduct(scanner, productSet);
		}
		
		
	}
}
