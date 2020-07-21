package VendingMaChineOOP2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineHCM extends VendingMachine {

	final static double MIN_COST = 5000;

	private List<Product> listProduct;
	private List<Product> listProductChoose;

	public VendingMachineHCM(int id, String nameMachine) {
//		super();
		super.id = id;
		super.nameMachine = nameMachine;

		listProductChoose = new ArrayList<Product>();

		listProduct = new ArrayList<Product>();
		Product product1 = new Product("Coca", 2000);
		Product product2 = new Product("Pepsi", 3000);
		Product product3 = new Product("Orange juice", 4000);
		Product product4 = new Product("7Up", 5000);
		Product product5 = new Product("Sochu", 6000);
		Product product6 = new Product("Sochu", 7000);
		Product product7 = new Product("Sochu", 8000);
		Product product8 = new Product("Sochu", 9000);
		listProduct.add(product1);
		listProduct.add(product2);
		listProduct.add(product3);
		listProduct.add(product4);
		listProduct.add(product5);
		listProduct.add(product6);
		listProduct.add(product7);
		listProduct.add(product8);

	}

	// check Money Min Cost Product
	public boolean checkMoneyMinCostProduct(double soTien) {
		return super.checkMoneyMinCostProduct(soTien);
	}

	// User insert money
	public double insertMoney() {
		return super.insertMoney();
	}

	// Choose product
	public int chooseProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Choose product (plz input from %d -> %d): ", 1, listProduct.size());
		int indexProduct = sc.nextInt() - 1;
//		if(indexProduct<0|| indexProduct>listProduct.size()) {
//			 throw new InvalidException("Invalid product. Plz choose again!");
//		}

		return indexProduct;
	}

	// get element from array list
	public Product getProductList(int index_Product) {
		return listProduct.get(index_Product);
	}

	//
	public boolean isWantContinue(String str) {
		return (str.equalsIgnoreCase("Yes")) ? true : false;
	}

	@Override
	public void displayCurrentProductInCart(List<Product> listProductChoose) {
		super.displayCurrentProductInCart(listProductChoose);
	}

	@Override
	public void addProductInCart(double moneyCurrent, Product product) {
		if (moneyCurrent > 0) {
			// add product to choose list
			listProductChoose.add(product);
			displayCurrentProductInCart(listProductChoose);
		}

	}
	
	public void threadDelay(String s) {
		super.threadDelay(s);	
	}
	

	// Run machine ...
	public void run() throws InvalidException {
//		super.run();
		Scanner sc = new Scanner(System.in);

		double moneyCurrent = 0;
		boolean isExist;

		System.out.println("==============    List product    ===============");
		for (Product pro : listProduct) {
			System.out.printf("Name: %s, Price: %s\n", pro.getName(), pro.getPrice());
		}
		System.out.println("Starting ...");

		do {

			isExist = false;
			double soTien = insertMoney() + moneyCurrent;
			
			boolean isEnough = checkMoneyMinCostProduct(soTien);

			// Check is enough monney
			while (isEnough) {

				boolean isOn = true;
				// Choose product if money is enough
				int indexProduct = chooseProduct();

				//

				// check exception
				try {
					if (indexProduct < 0 || indexProduct > listProduct.size()) {
						throw new InvalidException("Invalid product. Plz choose again!");
					} else {
						Product product = getProductList(indexProduct);

						double price_Product = product.getPrice();

						if (soTien >= price_Product) {

							// calculate moneyCurrent
							moneyCurrent = soTien - price_Product;

							// add product to cart
							addProductInCart(moneyCurrent, product);

							soTien = moneyCurrent;

							threadDelay("..You can get product");
							isEnough = checkMoneyMinCostProduct(soTien);

							// continue?
							System.out.println("Do you want to continue? Plz input Yes/No");
							String getMessage = sc.nextLine();

							if (!isWantContinue(getMessage)) {
								System.out.println("Payback Monney : " + moneyCurrent);
//								return;
								isExist = true;
								break;

							} else {
								System.out.println("Current Monney : " + moneyCurrent + "\n");
								//
								continue;
							}

						} else {

							// If money < price_Product => moneyCurrent = money
							moneyCurrent = soTien;
							System.out.println("Product price is higher than money add");
							// return?
							System.out.println("Do you want to return money? Plz input Yes/No");
							String getMessage = sc.nextLine();

							if (isWantContinue(getMessage)) {
								System.out.println("Payback Monney : " + moneyCurrent);
								return;
							} else {
								System.out.println("Current Monney : " + moneyCurrent + "\n");
								//
								continue;

							}
						}
					}
				} catch (Exception ex) {
					System.out.println("Exception: " + ex);
				}

			}

			System.out.println("Not enough minimum money! Do you like to insert more money? Yes/No");
			String str2 = sc.nextLine();
			if (isWantContinue(str2)) {
				// Insert more money ...
				continue;

			} else {

				// payback
				System.out.printf("Mininum monney should be %.2f . \nMoney payback: %.2f \n", MIN_COST, soTien);
				isExist = true;
			}

		} while (!isExist);

		// =============== Print Recepit =================
		super.printReceipt(listProductChoose);
	}

	
}
