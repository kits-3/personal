package customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import adminDao.CategoryDao;
import adminDao.CategoryImpl;
import customerDao.UserDao_cus;
import customerDao.UserImpl_cus;
import entity.Book;
import entity.User;

public class Customer {
	Scanner scanner = new Scanner(System.in);
	CategoryDao categorydao_us = new CategoryImpl();
	UserDao_cus userdao_us = new UserImpl_cus();
	CategoryView_cus categoryView_cus = new CategoryView_cus();
	User us = new User();
	List<Book> list = new ArrayList<Book>();
	public void notification(String gmail) {
		System.out.println("You are logged in as customer: " + gmail);
		System.out.println("1.Information");
		System.out.println("2.Buy product");
		System.out.println("3.Log out");
		int key = scanner.nextInt();
		switch (key) {
		case 1:
			userdao_us.findById(gmail);
			System.out.println("1. Changle password");
			System.out.println("2. Exit");
			int keyy = scanner.nextInt();
			if(keyy==1) {
				System.out.println("New password:");
				int new_pass = scanner.nextInt();
				us.setPassword(new_pass);
				us.setGmail(gmail);
				userdao_us.update(us);
				new Customer().notification(gmail);
			} else if(keyy==2)
			{
				new Customer().notification(gmail);
			}
			break;
		case 2:
			categoryView_cus.view(gmail, list);
			break;
		case 3:
			System.out.println("End");
			break;
		default:
			break;
		}
}}
