package Main;
import java.util.Scanner;

import Admin.AdminDao;
import Admin.AdminImpl;
import AdminAction.BillAction;
import AdminAction.CateAction;
import AdminAction.ProdAction;

public class Admin {
	CateAction cateAct = new CateAction();
	ProdAction prodAct = new ProdAction();
	BillAction billAct = new BillAction();
	AdminDao adDao = new AdminImpl();
	AdminEntity.Admin adE = new AdminEntity.Admin(); 
	String name ="";
	String pass="";
	
	Scanner scan = new Scanner(System.in);
	int action = 0;
	
	public void Login(boolean check) {
		System.out.printf("Admin name: ");
		name = scan.next();
		System.out.printf("Password: ");
		pass = scan.next();
		adE = adDao.login(name, pass);
		if(adE.getName() != null) {
			System.out.println(" ");
			System.out.println("  Admin Login Success!!!  ");
			System.out.println(" ");
			while(check) {	
				System.out.println("|--------------------|");
				System.out.println("|- Manager ----------|");
				System.out.println("|          -         |");
				System.out.println("| 1.Category Manage  |");
				System.out.println("| 2.Product Manage   |");
				System.out.println("| 3.Bill Manage      |");
				System.out.println("|          -         |");
				System.out.println("| 0.Logout           |");		
				System.out.println("|--------------------|");
			
				System.out.print("Choose your action: ");
				action = scan.nextInt();
				System.out.println(" ");
			
				switch(action) {
					case 1:
						cateAct.CateAction(check);
						break;
					case 2:
						prodAct.ProdAction(check);
						break;
					case 3:
						billAct.BillManage(check);
						break;
					case 0: 
						System.out.println("Logout success!!!");
						check=false;
						break;
					default: break;
				}
			}
		}else {
			System.out.println("Incorrect username or password!");
		}
		
		
	}
}
