package AdminAction;

import java.util.Scanner;

import Admin.ProductManageDao;
import Admin.ProductManageImpl;
import AdminEntity.CategoryAdmin;
import AdminEntity.ProductAdmin;

public class ProdAction {
	
	String name="";
	int cate_id = 0;
	int price = 0;
	String detail="";
	int id = 0;
	
	Scanner scan = new Scanner(System.in);
	int proAction = 0;
	
	ProductAdmin pro = new ProductAdmin();
	ProductManageDao proD = new ProductManageImpl();
	
	
	public void ProdAction(boolean checkMore) {
		
		while(checkMore) {
			System.out.println("|---------------------------|");
			System.out.println("|- Product Manager ---------|");
			System.out.println("|              -            |");
			System.out.println("| 1.Product add             |");
			System.out.println("| 2.Product delete          |");
			System.out.println("| 3.Product update          |");
			System.out.println("| 4.Product find all        |");
			System.out.println("|              -            |");
			System.out.println("| 0.Exit                    |");
			System.out.println("|---------------------------|");
		
			System.out.print("Choose your action: ");
			proAction = scan.nextInt();
			
		
			switch(proAction) {
				case 1: 
					System.out.print("Cate_id: ");
					cate_id = scan.nextInt();
					pro.setCate_id(cate_id);
					scan.nextLine();
				
					System.out.print("Prod_name: ");
					name = scan.nextLine();
					pro.setName(name);
					
					
					System.out.print("Prod_price: ");
					price = scan.nextInt();
					pro.setPrice(price);
					scan.nextLine();
					
					System.out.print("Prod_detail: ");
					detail = scan.nextLine();
					pro.setDetail(detail);
					proD.add(pro);
					
					break;
				case 2:
					System.out.print("Cate_id: ");
					id = scan.nextInt();
					proD.delete(id);
					break;
				case 3:
					System.out.print("Prod_id: ");
					id = scan.nextInt();
					pro.setId(id);
					
					System.out.print("Prod_cate_id: ");
					id = scan.nextInt();
					pro.setCate_id(id);
					scan.nextLine();
					
					System.out.print("Name: ");
					name = scan.nextLine();
					pro.setName(name);
					
					System.out.print("Price: ");
					price = scan.nextInt();
					pro.setPrice(price);
					scan.nextLine();
					
					System.out.print("Detail: ");
					detail = scan.nextLine();
					pro.setDetail(detail);
					
					proD.update(pro);
					break;
				case 4:
					System.out.println("All product: ");
					proD.findAll();
					break;
				case 0:
					checkMore=false;
					break;
				default:
					break;
			}
		}
	}




}
