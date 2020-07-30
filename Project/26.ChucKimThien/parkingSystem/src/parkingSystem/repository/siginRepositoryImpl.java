package parkingSystem.repository;

import java.util.Scanner;

import parkingSystem.entity.user;

public class siginRepositoryImpl implements signinRepository {
	public void signin() {
		userRepository userRepo = new userRepositoryImpl();
		boolean b =true;
		user a = new user();
		Scanner scan = new Scanner(System.in);
		System.out.println("----------------Create account----------------");
		System.out.println("firt name:");
		String fname = scan.next();
		a.setFname(fname);
		System.out.println("Last name:");
		String lname = scan.next();
		a.setLname(lname);
		System.out.println("Phone:");
		String phone = scan.next();
		a.setPhone(phone);
		while(b)
		{
			System.out.println("Username:");
			String username = scan.next();
			if(userRepo.checkLoop(username)==true)
			{
			System.out.println("username has used!");
			System.out.println("Please enter again");
			}
			else {
				b=false;
			}
			a.setUsername(username);
		}
		System.out.println("Pass:");
		String pass = scan.next();
		a.setPass(pass);
		String role = "user";
		a.setRole(role);
		userRepo.creatAccount(a);
	}
}
