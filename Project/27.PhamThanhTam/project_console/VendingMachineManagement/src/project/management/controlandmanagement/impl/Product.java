package project.management.controlandmanagement.impl;

import java.util.Scanner;

import project.management.ControlAndManagement;
import project.management.controlandmanagement.IProduct;
import project.management.controlandmanagement.IStatistics;
import project.management.entity.ProductEntity;
import project.management.entity.StoreMachineEntity;
import project.management.service.IProductService;
import project.management.service.IStoreMachineService;
import project.management.service.impl.ProductService;
import project.management.service.impl.StoreMachineService;

public class Product implements IProduct {
	IProductService productService = new ProductService();
	IStoreMachineService storeMachineService = new StoreMachineService();
	Scanner scan = new Scanner(System.in);

	@Override
	public void product() {
		System.out.println("select option:");
		System.out.println("1.add 2.update 3.delete 4.find 5.out to login");
		String option = scan.next();
		productOption(option);

	}

	@Override
	public void productOption(String option) {
		IStatistics statistics = new Statistic();
		ProductEntity productEntity = new ProductEntity();
		ProductEntity productAlreadyInsertEntity = new ProductEntity();
		StoreMachineEntity storeMachineEntity = new StoreMachineEntity();
		StoreMachineEntity storeMachineAlreadyInserEntity = new StoreMachineEntity();
		switch (option) {
		case "1": {
			System.out.println("insert 1.Product 2.StoreMachine 3.out to select option");
			System.out.println("input 1 or 2 or 3");
			String key = scan.next();
			switch (key) {
			case "1": {
				insertProduct(productEntity, productAlreadyInsertEntity);
				break;
			}
			case "2": {
				insertStoreMachine(storeMachineEntity, storeMachineAlreadyInserEntity);
				break;
			}
			case "3": {
				product();
				break;
			}
			default:
				break;
			}

			break;
		}
		case "2": {
			System.out.println("update 1.Product 2.StoreMachine 3.out to select option");
			System.out.println("input 1 or 2 or 3");
			String key = scan.next();
			switch (key) {
			case "1": {
				updateProduct(productEntity);
				break;
			}
			case "2": {
				updateStoreMachine(storeMachineEntity);
				break;
			}
			case "3": {
				product();
				break;
			}
			default:
				break;
			}

			break;
		}
		case "3": {
			System.out.println("delete 1.Product 2.StoreMachine 3.out to select option");
			System.out.println("input 1 or 2 or 3");
			String key = scan.next();
			switch (key) {
			case "1": {
				deleteProduct();
				break;
			}
			case "2": {
				deleteStoreMachine();
				break;
			}
			case "3": {
				product();
				break;
			}
			default:
				System.out.println("you choose wrong out to select");
				product();
				break;
			}
			break;
		}
		case "4": {
			statistics.statistics();
			break;
		}
		case "5": {
			new ControlAndManagement();
			break;
		}
		default:
			System.out.println("select wrong!!! please select again");
			productOption(option);
			break;
		}
	}

	private void updateStoreMachine(StoreMachineEntity storeMachineEntity) {
		System.out.println("welcome to update StoreMachine !!!");
		System.out.println("please input:");
		System.out.println("StoreMachine id: ");
		int id = scan.nextInt();
		StoreMachineEntity oldStoreMachine = storeMachineService.findOneById(id);
		if (oldStoreMachine == null) {
			System.out.println("id is null out to update product");
			updateStoreMachine(storeMachineEntity);
		}
		System.out.println("StoreMachine name: " + oldStoreMachine.getName());
		System.out.println("StoreMachine Address:" + oldStoreMachine.getAddress());
		System.out.println("StoreMachine UserId:" + oldStoreMachine.getUserid());
		System.out.println("are you sure update this StoreMachine ??? y or n");
		String choose = scan.next();
		switch (choose) {
		case "y": {
			
			/* scan.skip("(\\r\\n|[\\n\\r\\u2028\\u2029\\u0085])?"); */
			System.out.println("StoreMachine name: ");
			String name = scan.next();
			System.out.println("StoreMachine Address:");
			String address = scan.next();
			storeMachineEntity.setId(id);
			storeMachineEntity.setName(name);
			storeMachineEntity.setAddress(address);
			storeMachineEntity = storeMachineService.updateStoreMachine(storeMachineEntity);
			System.out.println("StoreMachine name: " + storeMachineEntity.getName());
			System.out.println("StoreMachine Address:" + storeMachineEntity.getAddress());
			System.out.println("id of Store Machine: " + storeMachineEntity.getId());
			System.out.println("are you want to update continues y or n");
			String key = scan.next();
			switch (key) {
			case "y":
				updateStoreMachine(storeMachineEntity);
				break;
			case "n":
				product();
				break;

			default:
				System.out.println("you choose wrong out to select");
				product();
				break;
			}
			break;
		}
		case "n": {
			String option = "2";
			productOption(option);
			break;
		}
		default:
			System.out.println("select false you return to update");
			updateStoreMachine(storeMachineEntity);
			break;
		}
		
	}

	@Override
	public void insertProduct(ProductEntity productEntity, ProductEntity productAlreadyInsertEntity) {

		System.out.println("welcome to insert product!!!");
		System.out.println("please input:");
		System.out.println("product name: ");
		String name = scan.next();
		System.out.println("product price:");
		int price = scan.nextInt();
		System.out.println("product total:");
		int total = scan.nextInt();
		System.out.println("id of Store Machine");
		int storeMachineId = scan.nextInt();
		productEntity.setName(name);
		productEntity.setPrice(price);
		productEntity.setTotal(total);
		productEntity.setStoreMachineId(storeMachineId);
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
			product();
			break;
		}
		default:
			System.out.println("you choose wrong out to select option");
			product();
			break;
		}
	}

	@Override
	public void updateProduct(ProductEntity productEntity) {
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
				product();
				break;

			default:
				System.out.println("you choose wrong out to select");
				product();
				break;
			}
			break;
		}
		case "n": {
			String option = "2";
			productOption(option);
			break;
		}
		default:
			System.out.println("select false ypu return to update");
			updateProduct(productEntity);
			break;
		}

	}

	@Override
	public void deleteStoreMachine() {
		System.out.println("welcome to delete StoreMachine !!!");
		System.out.println("please input id:");
		String id = scan.next();
		storeMachineService.deleteStoreMachine(Integer.parseInt(id));
		System.out.println("do you want to delete continues ??? y or n");
		String key = scan.next();
		switch (key) {
		case "y":
			deleteStoreMachine();
			break;
		case "n":
			product();
			break;

		default:
			System.out.println("you choose wrong!!!  out to select");
			product();
			break;
		}
	}

	@Override
	public void insertStoreMachine(StoreMachineEntity storeMachineEntity,
			StoreMachineEntity storeMachineAlreadyInserEntity) {
		System.out.println("welcome to insert StoreMachine !!!");
		System.out.println("please input:");
		System.out.println("StoreMachine name: ");
		String name = scan.next();
		System.out.println("StoreMachine address: ");
		String address = scan.next();
		storeMachineEntity.setName(name);
		storeMachineEntity.setUserid(1);
		storeMachineEntity.setAddress(address);
		storeMachineEntity.setStatus(1);;
		storeMachineAlreadyInserEntity = storeMachineService.addStoreMachine(storeMachineEntity);

		System.out.println("StoreMachine name: " + storeMachineAlreadyInserEntity.getName());
		System.out.println("StoreMachine address: " + storeMachineAlreadyInserEntity.getAddress());
		System.out.println("StoreMachine userid:" + storeMachineAlreadyInserEntity.getUserid());
		System.out.println("are you want to insert continues ??? y or n");
		String key = scan.next();
		switch (key) {
		case "y": {
			insertStoreMachine(storeMachineEntity, storeMachineAlreadyInserEntity);
			break;
		}
		case "n": {
			product();
			break;
		}
		default:
			System.out.println("you choose wrong out to select option");
			product();
			break;
		}
	}

	@Override
	public void deleteProduct() {
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
			product();
			break;

		default:
			System.out.println("you choose wrong!!!  out to select");
			product();
			break;
		}
		
	}
}
