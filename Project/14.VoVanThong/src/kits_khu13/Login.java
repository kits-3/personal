package kits_khu13;

import java.util.Scanner;

import khu13entity.AccountEntity;
import khu13respository.Khu13RepositoryImpl;

public class Login {
	static Scanner scan = new Scanner(System.in);
	AccountEntity acc = new AccountEntity();
	String name;
	String pw;
	Khu13RepositoryImpl khu13repimpl = new Khu13RepositoryImpl();
	public void creat() {
		
		System.out.println("What's your name?");
		String username = scan.next();
		acc.setName(username);
		System.out.println("What's your password?");
		String pass = scan.next();
		acc.setPassword(pass);
		System.out.println("How much?");
		int money = scan.nextInt();
		acc.setMoney(money);
		System.out.println("What's your numberphone: ");
		String phone = scan.next();
		acc.setPhone(phone);
		khu13repimpl.add(acc);
	}
	public void login() {
		System.out.println("Your Name: ");
		name = scan.next();
		acc.setName(name);
		System.out.println("Your Password: ");
		pw = scan.next();
		acc.setPassword(pw);
		name = acc.getName();
		pw = acc.getPassword();
//		acc = khu13repimpl.checklog(name,pw);
		
//		AccountEntity meo = new AccountEntity();
		
		
//		acc.setAccess(acc.getAccess());
//		System.out.println(acc.getAccess());
//		System.out.println(acc.getName());
//		if(meo.getName().equals(logname)) {
//			System.out.println(meo.getName());
//		}
//		else {
//			System.out.println("no");
//		}
	}
}
