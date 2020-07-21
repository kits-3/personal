package VendingMaChineOOP2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineHN extends VendingMachine {

	final static double MIN_COST = 15000;

	private List<Product> listProduct;
	private List<Product> listProductChoose;

	public VendingMachineHN(int id, String nameMachine) {
//		super();
		super.id = id;
		super.nameMachine = nameMachine;

		listProductChoose = new ArrayList<Product>();

		listProduct = new ArrayList<Product>();
		Product product31 = new Product("Meal", 2500);
		Product product32 = new Product("Chicken", 3500);
		Product product33 = new Product("Orange juice", 4500);
		Product product34 = new Product("Hamburge", 5500);
		Product product35 = new Product("Sochu", 6000);
		listProduct.add(product31);
		listProduct.add(product32);
		listProduct.add(product33);
		listProduct.add(product34);
		listProduct.add(product35);

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

	@Override
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
					System.out.println("Exception is : " + ex);
				}
			}

			System.out.println("Not enough minimum money! Do you like to insert more money? Yes/No");
			String str2 = sc.nextLine();
			if (isWantContinue(str2)) {
				// Insert more money ...
				continue;

			} else {

				// payback
				System.out.printf("Mininum monney should be %.2f . \nMoney payback: %.2f", MIN_COST, soTien);
				isExist = true;
			}

		} while (!isExist);
		
		// Print Receipt
		super.printReceipt(listProductChoose);
	}

}
