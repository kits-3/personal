package atm.main;

import atm.entity.User;
import atm.service.impl.PanelServiceImpl;

public class Panel {
		
	public boolean getPanel() {
		PanelServiceImpl us = new PanelServiceImpl();
		
		boolean check = us.getMenuLogin();

		while(check) {
			
			PanelServiceImpl pa = new PanelServiceImpl();
			
			String usname = User.session_user; 
			System.out.println("------------------------------");
			System.out.println("User: " + usname);
			
			int menu = pa.getMenu();
			if(menu == 1) {
				check = pa.getMenuAdmin();
			}else if(menu == 2) {
				check = pa.getMenuAccount();
			}else if(menu == 3) {
				check = pa.getMenuHistory();
			}else if(menu == 4) {
				check = pa.banking();
			}else if(menu == 5) {
				break;
			}
		}
		System.out.println("------------------------------");
		System.out.println("Exit success!!");
		return true;
	}
}