package AdminAction;

import java.util.Scanner;

import Admin.ProductManageDao;
import Admin.ProductManageImpl;
import AdminEntity.ProductAdmin;
import Dao.CustomerDao;
import Dao.CustomerImpl;


public class BillAction {
	int id=0;
	
	Scanner scan = new Scanner(System.in);
	int billAct = 0;
	
	ProductAdmin pro = new ProductAdmin();
	ProductManageDao proD = new ProductManageImpl();
	CustomerDao cusD = new CustomerImpl();
	
	public void BillManage(boolean check) {
		while(check) {
			System.out.println("|------------------------|");
			System.out.println("|- Bill Manager ---------|");
			System.out.println("|            -           |");
			System.out.println("| 1.Show bill            |");
			System.out.println("| 2.Delete bill          |");
			System.out.println("|            -           |");
			System.out.println("| 0.Exit                 |");
			System.out.println("|------------------------|");
			
			System.out.printf("Choose your action: ");
			billAct = scan.nextInt();
			
			switch(billAct) {
			case 1: 	
				System.out.println("Detail bill: ");
				System.out.println("|------------------------------------------------------------------------------|");
				proD.selectBill(pro);
				System.out.println("|------------------------------------------------------------------------------|");
				break;
			case 2:
				System.out.printf("Delete id bill: ");
				id = scan.nextInt();
				cusD.delete(id);
				break;
			case 0:
				check=false;
				break;
			default:
				break;
			}
		}
	}

}
