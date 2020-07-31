package kits_khu13;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import khu13entity.AccountEntity;
import khu13entity.MenuEntity;
import khu13entity.SiteEntity;
import khu13respository.Khu13Repository;
import khu13respository.Khu13RepositoryImpl;

public class Khu13Main {
	static Scanner scan = new Scanner(System.in);
	static Khu13RepositoryImpl khu13Repository = new Khu13RepositoryImpl();
	static AccountEntity acc = new AccountEntity();
	static SiteEntity siteE = new SiteEntity();
	
public static void main(String[] args) {
	String name;
	String pw;
	List<String> order = new ArrayList<>();
	List<Integer> bill = new ArrayList();
	
	//--start--
	System.out.println("****Welcome KHU13****");
	System.out.println("Do you have an account? y/n");
	String answer = scan.next();
	String more;
	Login log = new Login();
	
	if(answer.equals("n")) {
		log.creat();
		log.login();
	}
	else {
		
		log.login();
	}
//	---admin or user
	acc = khu13Repository.checklog(log.name,log.pw);
	int totalmoney =acc.getMoney();
	if(acc.getAccess().equalsIgnoreCase("admin")) {
		Admin ad = new Admin();
		ad.showSite();
		ad.changeMenu();
		ad.deleteUser();
	}else {
		User user = new User();
		user.showSite();
		siteE = khu13Repository.update(siteE);
//		siteE.setId(user.selectSite());
		siteE = khu13Repository.findById(siteE.getId());
		System.out.print("Your Site: "+ siteE.getSite()+". ");
		System.out.println("Please choose menu");
		do {
		List<MenuEntity> listmenu = new ArrayList();
		listmenu =khu13Repository.findMenu();
		MenuEntity menuE = new MenuEntity();
		
		for(int i=0;i<listmenu.size();i++){
				System.out.println(listmenu.get(i).getId()+
						"."+listmenu.get(i).getName() + ": "
						+listmenu.get(i).getPrice()+"$");
			}
			
			
			int selectM = scan.nextInt();
			menuE = khu13Repository.checkprice(selectM);
			totalmoney= totalmoney-menuE.getPrice();
			order.add(String.valueOf(menuE.getName() +" "+menuE.getPrice()+"$"));
			bill.add(menuE.getPrice());
			menuE = khu13Repository.updatemoney(totalmoney,log.name);
			System.out.println("Your money: " +totalmoney +"$");
			System.out.println("Do you want more? y/n");
			more =scan.next();
		}while(more.equals("y"));
		int billcode=0;
		if(more.equals("n")) {
			for (int i = 0; i < order.size(); i++) {
				System.out.println("ban da mua " + order.get(i));
			}
			for (int i = 0; i < bill.size(); i++) {
				billcode += bill.get(i);
			}
			System.out.println("total bill: "+billcode +"$");
			System.out.println("See you again, tonight!!!");
		}

	}
	
}
}
