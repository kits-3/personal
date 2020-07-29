import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine implements VendingMachineInterface {

	@Override
	public boolean isContinue(int money) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Your money is: " + money);
		System.out.println("want more select product? y or n");
		String checkMoreString = scan.next();
		if (checkMoreString.equals("n")) {
			return false;
		}
		return true;
	}

	@Override
	public List<Product> chooseMachine(int choose) {
		List<Product> listProduct = new ArrayList<>();
		switch (choose) {
		case 1:
			listProduct.add(new Product(1, "Beer", 100));
			listProduct.add(new Product(2, "Coke", 200));
			listProduct.add(new Product(3, "Juice", 300));
			break;
		case 2:
			listProduct.add(new Product(1, "Swing", 100));
			listProduct.add(new Product(2, "Lays", 200));
			listProduct.add(new Product(3, "Poca", 300));
			break;
		case 3:
			listProduct.add(new Product(1, "Burger", 100));
			listProduct.add(new Product(2, "Banh Mi", 200));
			listProduct.add(new Product(3, "Toppoki", 300));
			break;
		default:
			break;
		}

		return listProduct;
	}

	@Override
	public void showMachine() {
		System.out.println("Choose machine type");
		System.out.println("1. Drink Vending Machine ");
		System.out.println("2. Snack Vending Machine");
		System.out.println("3. Food Vending Machine");
	}

	@Override
	public void showProduct(List<Product> listProduct) {

		System.out.println("Please select product");
		for (Product item : listProduct) {
			System.out.println(
					"ID: " + item.getId() + ", " + "Name: " + item.getName() + ", " + "Price: " + item.getPrice());
		}
	}

	@Override
	public int minPrice(List<Product> listProduct) {
		int result = Integer.MAX_VALUE;
		for (Product item : listProduct) {
			if (item.getPrice() < result)
				result = item.getPrice();
		}
		return result;
	}

	@Override
	public void printReceipt(List<Product> listProduct , int change) {
		String filedir = "C:/Users/PC12/Desktop/receipt/receipt.txt";

		try {
			FileOutputStream fo = new FileOutputStream(filedir);
			String bill = "------------RECEIPT------------\nProduct\t\t\tPrice \n\n";
			String billDetail = "";
			int money = change;
			byte[] bytes = bill.getBytes();
			fo.write(bytes);
			for(Product item : listProduct) {
				billDetail = billDetail + item.getName()+ "\t\t\t" + item.getPrice() + "\n";
				money += item.getPrice();
			}
			billDetail = billDetail +"-------------------------------\n" + "Money give:\t\t"+money+"\n"+ "Change:\t\t\t"+change;
			bytes = billDetail.getBytes();			
			fo.write(bytes);
			fo.close();
			System.out.println(bill);
			System.out.println(billDetail);
		} catch (FileNotFoundException e) {
			System.out.println("Receipt file not found!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
