package AdminAction;

import java.util.Scanner;

import Admin.CategoryManageDao;
import Admin.CategoryManageImpl;
import AdminEntity.CategoryAdmin;
import entity.Category;

public class CateAction {
	
	String name ="";
	int id = 0;
	Scanner scan = new Scanner(System.in);
	int cateAction = 0;
	CategoryAdmin cate = new CategoryAdmin();
	CategoryManageDao cateD = new CategoryManageImpl();
	
	public void CateAction(boolean checkMore) {
		while(checkMore) {
			System.out.println("|----------------------------|");
			System.out.println("|- Category Manager ---------|");
			System.out.println("|              -             |");
			System.out.println("| 1.Category add             |");
			System.out.println("| 2.Category delete          |");
			System.out.println("| 3.Category update          |");
			System.out.println("| 4.Category find all        |");
			System.out.println("|              -             |");
			System.out.println("| 0.Exit                     |");
			System.out.println("|----------------------------|");
		
			System.out.print("Choose your action: ");
			cateAction = scan.nextInt();
			scan.nextLine();
		
			switch(cateAction) {
				case 1: 
					System.out.print("Cate_name: ");
					name = scan.nextLine();
					cateD.addName(name);
					break;
				case 2:
					System.out.print("Cate_id: ");
					id = scan.nextInt();
					cateD.delete(id);
					break;
				case 3:
					CategoryAdmin ct = new CategoryAdmin();
					System.out.print("Cate_id: ");
					id = scan.nextInt();
					scan.nextLine();
					ct.setId(id);
					
					System.out.print("Name: ");
					name = scan.nextLine();
					ct.setName(name);
					
					cateD.update(ct);
					break;
				case 4:
					System.out.println("All product: ");
					cateD.findAll();
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
