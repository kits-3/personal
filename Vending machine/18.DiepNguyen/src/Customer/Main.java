package Customer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static Set<Product> productSet = new HashSet<Product>();
	
	private static int enterKindOfProductsQuantity(Scanner scanner){
		int noProductTypes = 0;
		
		while(true){
			try{
				System.out.print("Admin: How many kind of products do you want to import: ");
				noProductTypes = Integer.valueOf(scanner.next());
			}catch(NumberFormatException nfe){
				System.out.println("Accept only number for num of Product Types!!!");
				continue;
			}
			break;
		}
		
		return noProductTypes;
	}
	
	public static void main(String[] args) {
		
		int noProductTypes = 0;
		Product product = null;
		VendingMachine machine = null; 
		int insertedMoney = 0;
		boolean enoughMoney = false;
		String cont = "";
		int option = 0;
		machine = new VendingMachine();
		Admin admin = null;
		Money money = new Money();
		
		//Admin import products into vending machine
		noProductTypes = enterKindOfProductsQuantity(scanner);
		for(int i=1; i <= noProductTypes; ++i){
			admin = new Admin();
			product = admin.insertProductsIntoVendingMachine(scanner);
			productSet.add(product);
		}
		
		//Customer
		Customer customer = new Customer();
		while(true){
			insertedMoney = customer.inputMoney(scanner);
			customer.setTotalMoney(insertedMoney);
			enoughMoney = money.checkInsertedMoneyWithMinCosProduct(insertedMoney, productSet);
			if(enoughMoney == true){
				break;
			}
			System.out.println("Warning: Not enough money.");
			System.out.print("Do you want to continue (Y/N)? ");
			cont = scanner.next().toUpperCase();
			if(cont.equals("N")){
				break;
			}
		}
		
		if(cont.equals("N")){
			money.returnMoney();
		}else{
			option = customer.selectProduct(scanner, productSet);
			loop1:
			while(true){
				enoughMoney = machine.enoughMoneyWithSelectedProductPrice(option, productSet);
				if (enoughMoney){
					//get product
					System.out.println("Please accept the product in the slot below");
					
					break loop1;
				}else{
					loop2:
					while(true){
						System.out.println("Warning: Not enough money.");
						System.out.print("Do you want to continue (Y/N)? ");
						cont = scanner.next().toUpperCase();
						if(cont.equals("N")){
							break loop1;
						}
						insertedMoney = customer.inputMoney(scanner);
						continue loop1;
					}
				}
			}
		}	
	}
}
