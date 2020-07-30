package kits_khu13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import khu13entity.AccountEntity;
import khu13entity.MenuEntity;
import khu13entity.SiteEntity;
import khu13respository.Khu13RepositoryImpl;
 
public class User {
//	SiteEntity st = new SiteEntity();
	static Scanner scan = new Scanner(System.in);
	public void showSite() {
		Khu13RepositoryImpl khu13RepositoryImpl = new Khu13RepositoryImpl();
		List<SiteEntity> list = new ArrayList();
		list =khu13RepositoryImpl.findAll();
		System.out.println("Please select your seat!");
		for(int i=0;i<list.size();i++){
			if(!list.get(i).getStatus().equalsIgnoreCase("full")) {
				System.out.println(list.get(i).getId()+"."+list.get(i).getSite() + ": "+list.get(i).getStatus());
			}
			
		}
	}
	public int selectSite() {
		int selectS = scan.nextInt();
//		st.setId(selectS);		
		return selectS; 
	}
}
