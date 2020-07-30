package atm.main;

import atm.entity.Session;
import atm.service.impl.AccountServiceImpl;

public class ATM {
	
	public boolean getATM() {

		AccountServiceImpl acc = new AccountServiceImpl();
		
		boolean check = acc.getMenuLogin();
		while(check) {
			
			int id = Session.id;
			System.out.println("------------------------------");
			System.out.println("Account: " + Session.name);
			int menu = acc.getMenu();
			if(menu == 1) {
				check = acc.check(id);
			} else if(menu == 2) {
				check = acc.change(id);
			} else if(menu == 3) {
				check = acc.withraw(id);
			} else if(menu == 4) {
				check = acc.deposit(id);
			}else if(menu == 5) {
				check = acc.transfer(id);
			} else if(menu == 6) {
				break;
			}
			
		}
		System.out.println("------------------------------");
		System.out.println("Exit success!!");
		return true;
	}
}
