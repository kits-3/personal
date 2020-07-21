
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int money = 0;

	public static void main(String[] args) {
		boolean checkMore = true;
		List<Product> listProduct = new ArrayList<>();
		VendingMachineInterface vendingMachine = new VendingMachine();
		Product selectedProduct = null;
		Scanner scan = new Scanner(System.in);
		List<Product> boughtProduct = new ArrayList<Product>();
		int chooseProduct = 0;
		int chooseMachine = 0;
		ThreadCountDown tcd = new ThreadCountDown();
		Thread thread = new Thread(tcd);
		while (chooseMachine <= 0 || chooseMachine >3) {

			try {
				vendingMachine.showMachine();
				chooseMachine = Integer.parseInt(scan.nextLine());
				listProduct = vendingMachine.chooseMachine(chooseMachine);
				if (chooseMachine > 3 || chooseMachine <=0) throw new InputMismatchException("Please choose 1,2 or 3");
			} catch (InputMismatchException e) {
				System.out.println("Please choose 1,2 or 3");
			} catch (NumberFormatException e) {
				System.out.println("Please choose 1,2 or 3");
			}
		}

		while (checkMore) {
			System.out.println("please input money");
			try {
				money += Integer.parseInt(scan.nextLine());
			} catch (InputMismatchException e) {
				System.out.println("Invalid input money");
			} catch (NumberFormatException e) {
				System.out.println("Invalid input money");
			}
			if (money < vendingMachine.minPrice(listProduct)) {
				System.out.println("Not enough money");
				checkMore = vendingMachine.isContinue(money);
			} else {
				while (checkMore) {
					System.out.println("check your money : " + money);
					vendingMachine.showProduct(listProduct);
					System.out.println("Choose a number!");
					chooseProduct = scan.nextInt();
					for (Product item : listProduct) {
						if (item.getId() == chooseProduct)
							selectedProduct = item;
					}
					if (selectedProduct.getPrice() > money) {
						System.out.println("Not enough money");
						checkMore = vendingMachine.isContinue(money);
						break;
					}
					System.out.println("your select :" + selectedProduct.getName());
					money = money - selectedProduct.getPrice();
					boughtProduct.add(selectedProduct);
					thread.start();
					checkMore = vendingMachine.isContinue(money);
					if (money < vendingMachine.minPrice(listProduct))
						break;
				}
			}
		}

		vendingMachine.printReceipt(boughtProduct, money);
	}

}
