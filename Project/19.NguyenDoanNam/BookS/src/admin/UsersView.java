package admin;

import java.util.Scanner;

import adminDao.UserDao;
import adminDao.UserImpl;
import entity.User;

public class UsersView {
	Scanner scanner = new Scanner(System.in);
	UserDao userdao = new UserImpl();
	User us = new User();
	String gmail;

	public void view() {
		boolean check_userView = true;
		while (check_userView) {
			System.out.println("1.User: ");
			System.out.println("------------------------------------------");
			userdao.findAll();
			System.out.println("------------------------------------------");
			System.out.println("1-1.Create_User");
			System.out.println("1-2.Update_User");
			System.out.println("1-3.Delete_User");
			System.out.println("1-4.Select the function");
			System.out.println("1-5.End");
			String key = scanner.next();
			switch (key) {
			case "1":
				System.out.println("1-1.Create_User");
				System.out.println("------------------------------------------");
				System.out.println("Gmail: ");
				gmail = scanner.next();
				us.setGmail(gmail);
				System.out.println("Password: ");
				Integer pass = scanner.nextInt();
				us.setPassword(pass);
				System.out.println("Role: ");
				String role = scanner.next();
				if (role.equals("admin")) {
					us.setId_role(1);
				} else if (role.equals("customer")) {
					us.setId_role(2);
				}
				userdao.add(us);
				break;
			case "2":
				System.out.println("1-2.Update_User");
				System.out.println("------------------------------------------");
				System.out.println("Gmail: ");
				gmail = scanner.next();
				us.setGmail(gmail);
				System.out.println("Password: ");
				Integer pass1 = scanner.nextInt();
				us.setPassword(pass1);
				System.out.println("Role: ");
				String role1 = scanner.next();
				if (role1.equals("admin")) {
					us.setId_role(1);
				} else if (role1.equals("customer")) {
					us.setId_role(2);
				}
				userdao.update(us);
				break;
			case "3":
				System.out.println("1-3.Delete_User");
				System.out.println("------------------------------------------");
				System.out.println("Gmail: ");
				gmail = scanner.next();
				us.setGmail(gmail);
				userdao.delete(gmail);
				break;
			case "4":
				new Admin().notification();
				check_userView = false;
				break;
			case "5":
				System.out.println("END");
				check_userView = false;
				break;
			default:
				break;
			}
		}
	}
}
