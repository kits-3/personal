package shoeshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import shoeshop.entity.UserEntity;
import shoeshop.entity.orderEntity;
import shoeshop.entity.orderItemEntity;
import shoeshop.entity.ProductEntity;
import shoeshop.repository.UserRepository;
import shoeshop.repository.UserRepositoryImpl;
import shoeshop.repository.OrderItemRepository;
import shoeshop.repository.OrderItemRepositoryImpl;
import shoeshop.repository.OrderReposistoryImpl;
import shoeshop.repository.OrderRepository;
import shoeshop.repository.ProductRepository;
import shoeshop.repository.ProductRepositoryImpl;

public class Main {

	public static void main(String[] args) {
		String id = "";
		String pwd = ""; 
		Scanner sc = new Scanner(System.in);
		UserRepository userRepo = new UserRepositoryImpl();
		ProductRepository productRepo = new ProductRepositoryImpl();
		OrderRepository orderRepo = new OrderReposistoryImpl();
		OrderItemRepository orderItemRepo = new OrderItemRepositoryImpl();
		List<orderItemEntity> lsOrderItem = new ArrayList();
		
		
		
		orderItemEntity oE = new orderItemEntity();
		int productCount = 0;
		int countOrder = orderItemRepo.getMaxID(oE);
		
		
		orderEntity order = new orderEntity();
		
		List<ProductEntity> list_product = new ArrayList();
		List<UserEntity> list_user = new ArrayList();
		
		ProductEntity pe = new ProductEntity();
		UserEntity user = new UserEntity();
		
		list_user = userRepo.findAll();
		list_product = productRepo.findProduct();
		
		String choose = "1";
		boolean signed = false;
		while(choose.equals("0")==false){
			System.out.println(" ----------------------------------------");
			System.out.println("|          Welcome to shoes shop!        |");
			System.out.println("| 1.Login                                |");
			System.out.println("| 2.Sign up                              |");
			System.out.println("| 0.Exit                                 |");
			System.out.println("| Press any number to choose your option |");
			System.out.println(" ----------------------------------------");
			choose = sc.next();
			boolean success= false;
			UserEntity user2 = new UserEntity();
			int checkSign = 0;
			switch(choose){
			case "1":
				while(success==false){
					System.out.println("------LOGIN------");
					user2 = userRepo.login(id, pwd);
					if(user2.getRole()==null){
						System.out.println("Your id or password is not correct!");
						System.out.println("Create new account(y or n)?");
						String create = sc.next();
						if(create.equals("y")&& signed==false){
							userRepo.signUp(user, list_user, userRepo);
							signed=true;
						}else{
							System.out.println("You can try again !");
						}
					}else{
						success=true;
					}
				}
				String role = "";
				role = user2.getRole();
				boolean newCart = false;
				if (role.equals("user")){
					int total = 0;
					String user_choose = "-1";
					System.out.println("Welcome User "+user2.getUserLoginID());
					System.out.println("You have "+user2.getMoneyleft()+ "$ in your account");
					while(user_choose.equals("0")==false){
						int productQuantity = 0;
						System.out.println(" ----------------------------------------");
						System.out.println("|                User Menu               |");
						System.out.println("| 1.View products                        |");
						System.out.println("| 2.Find products                        |");
						System.out.println("| 3.Add products to cart                 |");
						System.out.println("| 4.Show Cart and pay                    |");
						System.out.println("| 0.Exit                                 |");
						System.out.println("| Press any number to choose your option |");
						System.out.println(" ----------------------------------------");
						user_choose = sc.next();
						switch(user_choose){
						case "1":
							System.out.printf("%35s %n","Shoes list");
							list_product = productRepo.findProduct();
							productRepo.showProductU(list_product);
							break;
						case "2":
							List<ProductEntity> ls_product_find = new ArrayList();
							System.out.println("Input name of product you want to find");
							String productName = "";
							//here
							sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
							productName = sc.nextLine();
							ls_product_find = productRepo.findByNameM(productName);
							if(productRepo.findByName(productName).getProductName()!=null) {
								productRepo.showProduct(ls_product_find);
							}else {
								System.out.println("We don't have this product!");
							}
							
							break;
						case "3":
						{
							orderItemEntity order_item = new orderItemEntity();
							ProductEntity product_buy = new ProductEntity();
							int buyID = -1;
							//HERE
							while(product_buy.getProductName()==null){
								System.out.print("Input ID of product you want to buy: ");
								buyID=sc.nextInt();
								product_buy = productRepo.findById(buyID);
								if (product_buy.getProductName()==null){
									System.out.println("ID is not valid");
								}
							}
							System.out.print("The amount "+ product_buy.getProductName()+" do you want to buy: " );
							productQuantity = sc.nextInt();
							order_item.setProduct(product_buy);
							order_item.setQuantity(productQuantity);
							lsOrderItem.add(productCount, order_item);
							order.setItems(lsOrderItem);
							order.setUser(user2);
							productCount++;
							newCart = true;
							break;
						}
						case "4":
						{
							 
							System.out.println("-------------Your Cart------------");
							System.out.printf("%-25s","ProductName");
							System.out.printf("%-10s","Price");
							System.out.printf("%5s %n","Quantity");
							for(int i = 0 ; i<lsOrderItem.size();i++){
								int price = order.getItems().get(i).getProduct().getProductPrice();
								int quantity = order.getItems().get(i).getQuantity();
								System.out.printf("%-25s",order.getItems().get(i).getProduct().getProductName());
								System.out.printf("%-10s",price);
								System.out.printf("%-5s %n",quantity);
								if(newCart== true){
									int tmt = price*quantity;
									total+=tmt;
								}
							}
							newCart=false;
							System.out.println("Total: "+total);
							int inputMore = 0;
							int tmt = 0;
							boolean stop = false;
							while (user2.getMoneyleft()<total) {
								String chooseInput;
								System.out.println("You only have "+user2.getMoneyleft()+"$");
								System.out.println("Insert more money?(y or n)");
								chooseInput = sc.next();
								if(chooseInput.equals("y")){
									System.out.println("Insert money: ");
									inputMore = sc.nextInt();
									tmt = user2.getMoneyleft();
									inputMore+= tmt;
									user2.setMoneyleft(inputMore);
									userRepo.updateMoney(user2);
								}else{
									stop = true;
									break;
								}	
							}
							if(stop==true){
								break;
							}else{
								String choosePay = "";
								System.out.println("Do you want to pay bill now(y or n)?");
								order.setTotalPrice(total);
								choosePay = sc.next();
								if(choosePay.equals("y")){
									countOrder++;
									int changeMoney = user2.getMoneyleft()-total;
									user2.setMoneyleft(changeMoney);
									userRepo.updateMoney(user2);
									for(int j = 0 ; j < lsOrderItem.size() ; j++) {
										order.getItems().get(j).setOrderItemID(countOrder);
										orderItemRepo.addOderItem(order.getItems().get(j).getProduct(),order.getItems().get(j),user2);
									}
									orderRepo.addOrder(lsOrderItem, user2,order);
									System.out.println("Your bill has been paid!");
									System.out.println("Your have "+ user2.getMoneyleft()+"$ in account");
								}else if(choosePay.equals("n")){
									System.out.println("Back to user menu!");
									break;
								}
							}
							break;
						}
						case "0":
							System.out.println("Welcome back later!!");
							break;
						default:
							System.out.println("Service not served");
							break;
						}
					}
				}else if(role.equals("admin")){
					System.out.println("Welcome Admin "+user2.getUserLoginID());
					String admin_choose = "1";
					while(admin_choose.equals("0")==false){
						System.out.println(" ----------------------------------------");
						System.out.println("|                Admin Menu              |");
						System.out.println("| 1.View products                        |");
						System.out.println("| 2.View user                            |");
						System.out.println("| 3.Add new products                     |");
						System.out.println("| 4.Delete products                      |");
						System.out.println("| 5.Update products                      |");
						System.out.println("| 6.Show Order Detail                    |");
						System.out.println("| 7.Print Order Detail                   |");
						System.out.println("| 0.Exit                                 |");
						System.out.println("| Press any number to choose your option |");
						System.out.println(" ----------------------------------------");
						admin_choose = sc.next();
						switch(admin_choose){
						case "1":
							System.out.printf("%40s %n","Shoes list");
							list_product = productRepo.findProduct();
							productRepo.showProduct(list_product);
							break;
						case "2":
							userRepo.showUser(list_user);
							break;
						case "3":
						{
							System.out.print("Input product Name: ");
							sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
							pe.setProductName(sc.nextLine());
							int productPrice = -1;
							int productQuantity = -1;
							while(productPrice < 0){
								System.out.print("Input product Price: ");
								productPrice = sc.nextInt();
								if(productPrice < 0){
									System.out.println("Price is not valid");
								}
							}
							pe.setProductPrice(productPrice);
							while(productQuantity < 0){
								System.out.print("Input product Quantity: ");
								productQuantity = sc.nextInt();
								if(productQuantity < 0){
									System.out.println("Price is not valid");
								}
							}
							pe.setProductQuantity(productQuantity);
							productRepo.addProduct(pe);
							System.out.println("Add new item: "+pe.getProductName()+" to DB");
							break;
						}
						case "4":
						{
							int productID = -1;
							while(productID < 0){
								System.out.println("Input product ID you want to delete: ");
								productID=sc.nextInt();
								if (productID < 0){
									System.out.println("ID is not valid");
								}
							}
							productRepo.deleteProduct(productID);
							System.out.println("Deleted!!");
							break;
						}
							
						case "5":
						{
							ProductEntity updateProduct = new ProductEntity();
							int productID = -1;
							while(updateProduct.getProductName() == null){
								System.out.println("Input product ID you want to update: ");
								productID=sc.nextInt();
								updateProduct = productRepo.findById(productID);
								if (updateProduct.getProductName() == null){
									System.out.println("ID is not valid");
								}
							}
							updateProduct.setProductID(productID);
							System.out.print("Input product Name: ");
							updateProduct.setProductName(sc.next());
							int productPrice = -1;
							int productQuantity = -1;
							while(productPrice < 0){
								System.out.print("Input product Price: ");
								productPrice = sc.nextInt();
								if(productPrice < 0){
									System.out.println("Price is not valid");
								}
							}
							updateProduct.setProductPrice(productPrice);
							while(productQuantity < 0){
								System.out.print("Input product Quantity: ");
								productQuantity = sc.nextInt();
								if(productQuantity < 0){
									System.out.println("Price is not valid");
								}
							}
							updateProduct.setProductQuantity(productQuantity);
							productRepo.updateProduct(updateProduct);
							System.out.println("Update new item: "+updateProduct.getProductName()+" to DB");
							break;
						}
						case "6":
							System.out.printf("%40s %n", "Order list");
							List<orderItemEntity> lsOrder = new ArrayList();
							lsOrder=orderItemRepo.findOrderItem();
							orderItemRepo.showOrderItem(lsOrder);
							break;
						case "7":
							orderEntity order7 = new orderEntity();
							order7.getTotalPrice();
							List<orderItemEntity> PrintLsOrder = new ArrayList();
							PrintLsOrder=orderItemRepo.findOrderItem();
							 try {
								 
								FileOutputStream fo = new FileOutputStream("../ShoesShop/Order.txt");
								PrintWriter pw = new PrintWriter(fo);
								pw.printf("%-5s","ID");
								pw.printf("%-30s","Customer login name");
								pw.printf("%-30s","Product name");
								pw.printf("%-3s %n","Quantity");
								for(int i = 0 ; i< PrintLsOrder.size() ;i++) {
									pw.printf("%-5s",PrintLsOrder.get(i).getOrderItemID());
									pw.printf("%-30s",PrintLsOrder.get(i).getCustomerLoginID());
									pw.printf("%-30s",PrintLsOrder.get(i).getProductName());
									pw.printf("%-3s %n",PrintLsOrder.get(i).getQuantity());
								}
								pw.println("Total Income: "+ orderRepo.getTotal(order7)+"$");
								pw.close();
								fo.close();
								System.out.println("Print success!!");
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						case "0":
							System.out.println("Goodbye Admin "+ user2.getUserLoginID() +"!!");
							System.out.println("Back to main menu now!");
							break;
						default:
							System.out.println("Please choose the right numer!");
							break;
						}
					}
				}
				break;	
			case "2":
				if(signed==false){
					userRepo.signUp(user, list_user, userRepo);
					signed=true;
				}else{
					System.out.println("You have already signed an account recently , try login");
				}
				break;
			case "0":
				System.out.println("Welcome back later!");
				break;
			default:
				System.out.println("Service not served ! Try again !");
				break;
			}
		}
	}
}





















