package admin;

import java.util.Scanner;

import adminDao.LoginDao;
import adminDao.LoginImpl;
import entity.User;

public class Login {
	Scanner scanner = new Scanner(System.in);
	LoginDao logindao = new LoginImpl();
	User us = new User();

	public boolean login(String Gmail, Integer pass) {
		boolean result = true;	
		try {
			logindao.login(Gmail, pass); 
			result = false; 
		} catch (Exception e) {
			result = true;
			System.out.println("Please enter complete the information");
		}
		return result;
	}

	public void sign() {
		try {
			System.out.println("Gmail: ");
			String gmail = scanner.next();
			us.setGmail(gmail);
			System.out.println("Password: ");
			Integer pass = scanner.nextInt();
			us.setPassword(pass);
			logindao.add(us);
		} catch (Exception e) {
			System.out.println("Please enter complete the information");
			new Login().sign();
		}
		

	}
	public void forget_pw()
	{
		try {
			System.out.println("Gmail: ");
			String gmail = scanner.next();
			logindao.forget_pw(gmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
