package home.bike.service;

import java.util.List;
import java.util.Scanner;

import home.bike.entity.ProductEntity;
import home.bike.repository.ProductImpl;
import home.bike.repository.ProductRepository;

public class Product {
	ProductRepository productRepository = new ProductImpl();
	Scanner scan = new Scanner(System.in);
	double price;

	public void showproduct() {
		List<ProductEntity> productEntity = productRepository.findAll();
		for (ProductEntity x : productEntity) {
			System.out.println(x.getId_product() + "  " + x.getTrademark() + "  " + x.getColor() + "  " + x.getPirce());
		}
	}

	public int chooseproduct() {
		System.out.println(" please choose id_product:");
		int id_product = scan.nextInt();
		ProductEntity productEntity = productRepository.findById(id_product);
		if (productEntity == null) {
			System.out.println(" id_product null please choose id_product again");
			return chooseproduct();

		}
		if (productEntity.getId_product() == id_product) {
			System.out.println(productEntity.getTrademark() + " " + productEntity.getColor() + " "
					+ productEntity.getPirce() + " ");
		}
		price = productEntity.getPirce();
		return id_product;
	}

	double money;
	int date_rent;

	public void money() {
		System.out.println(" please input your rent date number:");
		int date = scan.nextInt();
		date_rent = date;
		System.out.println(" The money you must pay :");
		money = price * date;
		System.out.println(money + " usd");
	}

	public double checkmoney() {
		System.out.println(" pleases input money:");
		double checkmoney = scan.nextDouble();
		if (money == checkmoney) {
			System.out.println(" unlock product  ");

			System.out.println(" end time for date" + date_rent);
			System.out.println("please reciveived product");
		} else if (money > checkmoney) {
			System.out.println(" do you want rent continue(y/n):");
			scan.nextLine();
			String cont = scan.nextLine();
			if (cont.equals("y")) {
				double money_more;
				money_more = money - checkmoney;
				System.out.println("please inpput more money \n " + "\n your money input more is" + money_more);
				return checkmoney;
			} else if (cont.equals("n")) {
				System.out.println(" take back  your money" + checkmoney + "\n see you again.");
			}
		}
	 
	 System.out.println(" do you want rent again(y/n)");
	 String rent_again = scan.nextLine();
	 if (rent_again.equals("y")) {
		 System.out.println("go to insert id product"); 
	 }
	 else if (rent_again.equals("n")) {
		 System.out.println(" see you again");
	 }
	return checkmoney;
	}
}