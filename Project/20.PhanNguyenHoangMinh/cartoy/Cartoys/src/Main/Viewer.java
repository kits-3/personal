package Main;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Dao.CategoryDao;
import Dao.CategoryImpl;
import Dao.CustomerDao;
import Dao.CustomerImpl;
import Dao.ProductDao;
import Dao.ProductImpl;
import entity.Customer;
import entity.Product;

public class Viewer {
	
	Scanner scan = new Scanner(System.in);
	CategoryDao cate = new CategoryImpl();
	ProductDao pro = new ProductImpl();
	CustomerDao cus = new CustomerImpl();
	Product product = new Product();
	Customer cust = new Customer();
	List<Integer> tongtien = new ArrayList<>();
	ArrayList<String> tongxe = new ArrayList<>();
	
	
	
	public void Viewer(boolean checkMore) {
		String name="";
		String address="";
		String phone="";
		int count;
		int pror = 0;
		String stop;
		int tong=0;
		String xe;
		String order_item="";
		while (checkMore) {
			int cat = 0;
			
			//select category
			System.out.printf("Select category (1.sedan/2.SUV): ");
			cat = scan.nextInt();
			
			//View cars
			System.out.println("No Name\t\t\tPrice");
			System.out.println("-------------------------------------");
			cate.findCategory(cat);
			System.out.println("-------------------------------------");
			
			String buy="";
			System.out.printf("Buy a car? Rechoice? Exit? (b/r/e): ");
			buy = scan.next();
			if(buy.equalsIgnoreCase("b")) {
				//Pick cars
				System.out.print("Which cars do you want? (input the number): ");
				pror = scan.nextInt();
				product = pro.findById1(pror);
				tongtien.add(product.getPrice());	//List money
				tongxe.add(product.getName());	//List cars
				System.out.printf("Do you want to stop? (y/n): ");
				stop = scan.next();
				if(stop.equalsIgnoreCase("y")) {
					checkMore = false;
					
					//SUM
					for (int i = 0; i < tongtien.size(); i++) {
						tong += tongtien.get(i);
					}
					for (int i = 0; i < tongxe.size(); i++) {
						order_item += " - "+ tongxe.get(i);
					}
					
					String pay ="";
					System.out.println("Total: "+tong+" $");
					System.out.printf("Do you want to order? (y/n):  ");
					pay = scan.next();
					scan.nextLine();
					if(pay.equalsIgnoreCase("y")) {
						//INSERT INFO
						System.out.println("|--------------------------------|");
						System.out.println("|          Customer Info         |");
						System.out.println("|--------------------------------|");
						System.out.print("| Name: ");
						name = scan.nextLine();
//						scan.nextLine();
						cust.setName(name);
						
						
						System.out.print("| Address: ");
						scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
						address = scan.nextLine();
						
						cust.setAddress(address);
						
						System.out.print("| Phone: ");
						phone = scan.next();
						scan.nextLine();
						cust.setPhone(phone);
						System.out.println("|--------------------------------|");
						
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
						Date date = new Date();
						cust.setOrder_date(String.valueOf(formatter.format(date)));
						
						cust.setOrder_item(order_item);
						cust.setTotal(tong);
						cus.add(cust);
						System.out.println("Order success!");
						
						System.out.println("|---------------------------------------|");
						System.out.println("|                  Bill                 |");
						System.out.println("| ------------------------------------- |");
						System.out.println("| Customer Name: "+name);
						System.out.println("| Customer Address: "+address);
						System.out.println("| Customer Phone: "+phone);
						System.out.println("| Product order: "+tongxe);
						System.out.println("| Total price: "+tong+" $");
						System.out.println("| Order day: "+formatter.format(date));
						System.out.println("| ------------------------------------- |");
					}
					else {
						checkMore = false;
					}
									
				}else {
					checkMore = true;
				}
				
			} else if(buy.equalsIgnoreCase("r")) {
				checkMore = true;
			} else {
				checkMore = false;
			}
			
		}
		
	}
	
}
