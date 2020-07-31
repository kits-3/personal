package project.management.task.impl;

import java.util.Scanner;

import project.management.controlandmanagement.IAdmin;
import project.management.controlandmanagement.impl.Admin;
import project.management.entity.ProductEntity;
import project.management.service.IProductService;
import project.management.service.impl.ProductService;
import project.management.task.IProduct;

public class Product implements IProduct{
	private Scanner scan;
	private IProductService productService;

	public Product() {
		this.scan = new Scanner(System.in);
		this.productService = new ProductService();

	}
		
	@Override
	public void insertProduct(ProductEntity productEntity, ProductEntity productAlreadyInsertEntity) {
		IAdmin admin = new Admin();
		System.out.println("welcome to insert product!!!");
		System.out.println("please input:");
		System.out.println("product name: ");
		String name = scan.next();
		System.out.println("product price:");
		String price = scan.next();
		System.out.println("product total:");
		String total = scan.next();
		System.out.println("id of Store Machine");
		String storeMachineId = scan.next();
		productEntity.setName(name);
		productEntity.setPrice(Integer.parseInt(price));
		productEntity.setTotal(Integer.parseInt(total));
		productEntity.setStoreMachineId(Integer.parseInt(storeMachineId));
		productAlreadyInsertEntity = productService.addProduct(productEntity);

		System.out.println("product name: " + productAlreadyInsertEntity.getName());
		System.out.println("product price:" + productAlreadyInsertEntity.getPrice());
		System.out.println("product total:" + productAlreadyInsertEntity.getTotal());
		System.out.println("id of Store Machine: " + productAlreadyInsertEntity.getStoreMachineId());
		System.out.println("are you want to insert continues ??? y or n");
		String key = scan.next();
		switch (key) {
		case "y": {
			insertProduct(productEntity, productAlreadyInsertEntity);
			break;
		}
		case "n": {
			
			admin.admin();
			break;
		}
		default:
			System.out.println("you choose wrong out to select option");
			admin.admin();
			break;
		}
		
	}

	@Override
	public void updateProduct(ProductEntity productEntity) {
		IAdmin admin = new Admin();
		System.out.println("welcome to update product!!!");
		System.out.println("please input:");
		System.out.println("product id: ");
		int id = scan.nextInt();
		ProductEntity oldProduct = productService.findOneById(id);
		if (oldProduct == null) {
			System.out.println("id is null out to update product");
			updateProduct(productEntity);
		}
		System.out.println("product name: " + oldProduct.getName());
		System.out.println("product price:" + oldProduct.getPrice());
		System.out.println("product total:" + oldProduct.getTotal());
		System.out.println("id of Store Machine: " + oldProduct.getStoreMachineId());
		System.out.println("are you sure update this product ??? y or n");
		String choose = scan.next();
		switch (choose) {
		case "y": {
			System.out.println("product name: ");
			String name = scan.next();
			System.out.println("product price:");
			int price = scan.nextInt();
			System.out.println("product total:");
			int total = scan.nextInt();
			System.out.println("id of Store Machine");
			int storeMachineId = scan.nextInt();
			productEntity.setId(id);
			productEntity.setName(name);
			productEntity.setPrice(price);
			productEntity.setTotal(total);
			productEntity.setStoreMachineId(storeMachineId);
			productEntity = productService.updateProduct(productEntity);
			System.out.println("product name: " + productEntity.getName());
			System.out.println("product price:" + productEntity.getPrice());
			System.out.println("product total:" + productEntity.getTotal());
			System.out.println("id of Store Machine: " + productEntity.getStoreMachineId());
			System.out.println("are you want to update continues y or n");
			String key = scan.next();
			switch (key) {
			case "y":
				updateProduct(productEntity);
				break;
			case "n":
				admin.admin();
				break;

			default:
				System.out.println("you choose wrong out to select");
				admin.admin();
				break;
			}
			break;
		}
		case "n": {
			String option = "2";
			admin.adminOption(option);
			break;
		}
		default:
			System.out.println("select false ypu return to update");
			updateProduct(productEntity);
			break;
		}

		
	}

	@Override
	public void deleteProduct() {
		IAdmin admin = new Admin();
		System.out.println("welcome to delete Product !!!");
		System.out.println("please input id:");
		String id = scan.next();
		productService.deleteProduct(Integer.parseInt(id));
		System.out.println("do you want to delete continues ??? y or n");
		String key = scan.next();
		switch (key) {
		case "y":
			deleteProduct();
			break;
		case "n":
			admin.admin();
			break;

		default:
			System.out.println("you choose wrong!!!  out to select");
			admin.admin();
			break;
		}
	}

}
