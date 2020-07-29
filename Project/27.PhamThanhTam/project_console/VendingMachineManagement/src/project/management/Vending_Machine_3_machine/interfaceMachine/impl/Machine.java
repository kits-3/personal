package project.management.Vending_Machine_3_machine.interfaceMachine.impl;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

import project.management.Vending_Machine_3_machine.Thread2.thread;
import project.management.Vending_Machine_3_machine.interfaceMachine.IMachine;
import project.management.entity.OrderItemEntity;
import project.management.entity.OrderItemProductEntity;
import project.management.entity.ProductEntity;
import project.management.entity.StoreMachineEntity;
import project.management.service.IOrderItemProductService;
import project.management.service.IOrderItemService;
import project.management.service.IProductService;
import project.management.service.IStatisticsService;
import project.management.service.impl.OrderItemProductService;
import project.management.service.impl.OrderItemService;
import project.management.service.impl.ProductService;
import project.management.service.impl.StatisticsService;

public class Machine implements IMachine {
	IOrderItemProductService orderItemProductService = new OrderItemProductService();
	IOrderItemService orderItemService = new OrderItemService();
	IProductService productService = new ProductService();

	@Override
	public boolean test_Product(String selectProduct, String product) {
		return selectProduct.equals(product);
	}

	@Override
	public boolean test_Product_Price(int productPrice, int money) {
		return productPrice > money;
	}

	@Override
	public int information(int productPrice, String product, int money) {
		System.out.println("your select : " + product);
		money -= productPrice;
		return money;
	}

	@Override
	public void order_machine(boolean checkMore, int money, List<ProductEntity> productEntities,
			HashMap<String, Integer> orderProduct, StoreMachineEntity storeMachineEntity, IMachine machine) {
		Scanner scan = new Scanner(System.in);
		IStatisticsService statisticsService1 = new StatisticsService();
		ProductEntity product = statisticsService1.findMinByProductprice(storeMachineEntity.getId());
		int min = product.getPrice();
		while (checkMore) {
			System.out.println(
					"welcome to --- " + storeMachineEntity.getName() + " || at: " + storeMachineEntity.getAddress());
			System.out.println("please input money");
			money += scan.nextInt();
			System.out.println("check your money: " + money);
			if (money < min) {
				System.out.println("want more ? please input y or n");
				String chechString = scan.next();
				if (chechString.equals("y")) {

				} else {
					System.out.println("good bye");
					checkMore = false;
				}
			} else {
				while (checkMore) {
					for (int i = 0; i < productEntities.size(); i++) {
						if (productEntities.get(i).getTotal() > 0) {
							System.out.print("please select product: " + i + ". " + productEntities.get(i).getName()
									+ " (" + productEntities.get(i).getPrice() + " )");
							System.out.print(" || " + productEntities.get(i).getTotal());
							System.out.println(" || input " + i);
						}
					}
					System.out.println("input code product ( input 1 or 2 or ...)");
					String selectProduct = scan.next();
					for (int i = 0; i < productEntities.size(); i++) {
						if (productEntities.get(Integer.parseInt(selectProduct)).getTotal() > 0) {
							int count = 0;
							if (machine.test_Product(selectProduct, Integer.toString(i))) {
								if (machine.test_Product_Price(productEntities.get(i).getPrice(), money)) {
									checkMore = true;
									break;
								}
								count = orderProduct.get(productEntities.get(i).getName()) + 1;
								orderProduct.put(productEntities.get(i).getName(), count);
								money = machine.information(productEntities.get(i).getPrice(),
										productEntities.get(i).getName(), money);
							}
						}
					}
					if (productEntities.get(Integer.parseInt(selectProduct)).getTotal() < 1) {
						System.out.println("-----------------------------------NULL--------------------------------");
						System.out.println("Product have code :" + selectProduct +" is wrong or null so this product which your select be cancel ");
						System.out.println("-------------------------------------------------------------------");
						System.out.println();
					}

					System.out.println("want more select product? y or n");
					String checkMoreString = scan.next();
					if (checkMoreString.equals("y")) {

					} else {
						int moneyTotal = 0;
						int[] count = new int[productEntities.size()];
						System.out.println("your chance: " + money + " good bye");
						System.out.println("product you buy: ");
						for (int i = 0; i < productEntities.size(); i++) {
							if (orderProduct.get(productEntities.get(i).getName()) > 0) {
								if (orderProduct.get(productEntities.get(i).getName()) > 2) {
									/*
									 * thread 2 when customer buy > 2 product have same name
									 */

									thread threads = new thread();
									threads.run();
								}

								System.out.println(productEntities.get(i).getName() + ": "
										+ orderProduct.get(productEntities.get(i).getName()));
								count[i] = orderProduct.get(productEntities.get(i).getName());
								moneyTotal += productEntities.get(i).getPrice()
										* orderProduct.get(productEntities.get(i).getName());
								System.out.println("total: " + moneyTotal);
							}
						}
						saveBill(productEntities, orderProduct);
						saveCountProduct(productEntities, orderProduct);
						recept(productEntities, count, Integer.toString(money));

						checkMore = false;
					}

				}
			}
		}
	}

	@Override
	public void recept(List<ProductEntity> product, int[] count, String chance) {
		/*
		 * try{ FileInputStream fin=new
		 * FileInputStream("src/Vending_Machine_3_machine/fileBill/bill.txt");
		 * FileOutputStream fo = new
		 * FileOutputStream("src/Vending_Machine_3_machine/fileBill/bill.txt"); int
		 * readByteNum; byte[] bytes = new byte[300]; StringBuffer buffer = new
		 * StringBuffer(); while((readByteNum = fin.read(bytes)) != -1){
		 * fo.write(bytes,0, readByteNum); buffer.append(new
		 * String(bytes,0,readByteNum)); } String str = buffer.toString();
		 * System.out.println("result = " + str); fo.flush(); fo.close(); fin.close(); }
		 * catch(Exception e){ System.out.println(e); }
		 */
		try {

			StringBuffer buffer = new StringBuffer();
			buffer.append("Your Bill \r");
			for (int i = 0; i < count.length; i++) {
				if (count[i] > 0) {
					buffer.append("your order: " + product.get(i).getName() + "\r");
					buffer.append(product.get(i).getName() + "-count: " + count[i] + "\r");
				}
			}

			buffer.append("your chance: " + chance);

			FileOutputStream outputStream = new FileOutputStream(
					"src/project/management/Vending_Machine_3_machine/fileBill/bill.txt");
			byte[] strToBytes = buffer.toString().getBytes();
			outputStream.write(strToBytes);
			outputStream.close();
			System.out.println();
			System.out.println(buffer.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void saveBill(List<ProductEntity> productEntities, HashMap<String, Integer> orderProduct) {
		int moneyTotal = 0;

		OrderItemEntity orderItemEntity = new OrderItemEntity();
		OrderItemProductEntity orderItemProductEntity = new OrderItemProductEntity();
		for (int i = 0; i < productEntities.size(); i++) {
			if (orderProduct.get(productEntities.get(i).getName()) > 0) {
				moneyTotal += productEntities.get(i).getPrice() * orderProduct.get(productEntities.get(i).getName());
			}
		}
		orderItemEntity.setMoneytotal(moneyTotal);
		orderItemEntity.setStatus(1);
		orderItemEntity.setStoremachineid(productEntities.get(0).getStoreMachineId());

		int orderItemId = orderItemService.addOrderItem(orderItemEntity).getId();
		for (int i = 0; i < productEntities.size(); i++) {
			orderItemProductEntity.setCountOrdered(orderProduct.get(productEntities.get(i).getName()));
			orderItemProductEntity.setOrderid(orderItemId);
			orderItemProductEntity.setProductid(productEntities.get(i).getId());
			if (orderItemProductEntity.getCountOrdered() != 0) {
				orderItemProductService.addOrderItemProduct(orderItemProductEntity);
			}

		}
	}

	@Override
	public void saveCountProduct(List<ProductEntity> productEntities, HashMap<String, Integer> orderProduct) {
		for (int i = 0; i < productEntities.size(); i++) {
			ProductEntity product = new ProductEntity();
			product = productService.findOneByIdAndStoremachineid(productEntities.get(i).getId(),
					productEntities.get(i).getStoreMachineId());
			product.setTotal(product.getTotal() - orderProduct.get(product.getName()));
			productService.updateProduct(product);
		}
	}

}
