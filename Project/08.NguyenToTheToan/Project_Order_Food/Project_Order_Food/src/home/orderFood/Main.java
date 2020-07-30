package home.orderFood;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import home.orderFood.entity.CustomerEntity;
import home.orderFood.entity.UserEntity;
import home.orderFood.repository.AdminRepository;
import home.orderFood.repository.AdminRepositorylmpl;
import home.orderFood.repository.CustomerRepository;
import home.orderFood.repository.CustomerRepositorylmpl;
import home.orderFood.repository.UserRepository;
import home.orderFood.repository.UserRepositorylmpl;

public class Main {
	
	static Scanner sc =new Scanner(System.in);
	
//	 Registration User
	public static int  registrationUs() {	
		
	/*-------REGISTER USER NAME--------*/
		UserRepository user= new UserRepositorylmpl();
		System.out.println("Please enter the Registration form\r\n");
		System.out.println("Please enter your username:");
		String UserName =sc.nextLine();
		
		
		System.out.println("Please enter your password:");
		String PassWordUser= sc.nextLine();
		
		
		System.out.println("Please enter your email:");
		String EmailUser= sc.nextLine();
		
		
		System.out.println("Please enter your Phone:");
		String PhoneUser= sc.nextLine();
		
		
		System.out.println("Please enter your full Name:");
		String FullNameUser= sc.nextLine();
		
		//user.add(UserName, PassWordUser, EmailUser, PhoneUser,FullNameUser);
		return 0;
	/*----------/REGISTER USER NAME -------*/
	}
	
	public static int  login() {
		System.out.println("Please login your account");
		Scanner sc= new Scanner(System.in);
		//Lấy User nhập từ bàn phím
		System.out.println("Username:");
		String user = sc.nextLine();
		//lấy password nhap từ bàn phím
		System.out.print("Password:");
		String pass= sc.nextLine();
		try {
			if(user.contentEquals("")|| pass.contentEquals("")) {
				
			}else {
				
				
				
			}
		}catch(Exception e) {
			System.out.println("Connection failed!");
			
		}
		return 0;
	}
	
	public static void main(String[] args) {
//		System.out.println("Welcome to join our family.");
//		System.out.println("Do you already have an account(Yes/No)?");
//		String register = sc.nextLine();
//		if(register.equals("yes")) {
//			login();
//		}else {
//			registrationUs();
//		}
		System.out.println("test");
		List<UserEntity> ls = new ArrayList<UserEntity>();
		UserRepository userRepo = new UserRepositorylmpl();
		ls = userRepo.findAll();
		
		for (int i =0; i < ls.size(); i++) {
			System.out.println(ls.get(i).getUserName());
		}
		
	}

}
