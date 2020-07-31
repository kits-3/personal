package home.bike.service;

import java.util.Scanner;

import home.bike.entity.UserEntity;
import home.bike.repository.UserImpl;
import home.bike.repository.UserRepository;

public class Service {
	UserRepository userRepository = new UserImpl();

	Scanner scanner = new Scanner(System.in);

	public void options() {
		Scanner scan = new Scanner(System.in);
		System.out.println("please choose options (admin/customer):");
		String choosen = scan.nextLine();
		System.out.println("do you have account(y/n):");
		String choosen1 = scan.nextLine();
		if (choosen1.equals("y")) {
			switch (choosen) {
			case "admin":
				System.out.println(" please login admin");
				break;
			case "customer":
				System.out.println(" please login user");
				;
				break;
			default:
				break;
			}
		} else if (choosen1.equals("n")) {
			System.out.println("please create account");
			System.out.println("please fill  your name:");
			String name = scan.nextLine();
			System.out.println("please fill  your id_card:");
			int id = scan.nextInt();
			System.out.println("please fill  your add:");
			String add = scan.nextLine();
			System.out.println("please fill  your phone munber:");
			int phone = scan.nextInt();
			System.out.println("please fill  your user:");
			String user = scan.nextLine();
			System.out.println("please fill  your password:");
			String password = scan.nextLine();
			int role_id = 2;
		}
	}

	public String login() {

		System.out.println(" insert user:");
		String username = scanner.nextLine();
		System.out.println("insert password:");
		String password = scanner.nextLine();

		try {
			if (username.equals("") && password.equals("")) {
				System.out.println("please input information \n  please login again");
				return login();
			} else if (username.equals("")) {
				System.out.println("please input user \n  please login again");
				return login();
			} else if (password.equals("")) {
				System.out.println("please input password\\n  please login again");
				return login();
			}

			UserEntity userEntity = userRepository.findByUserName(username);

			if (userEntity.getPassword().equals(password) && userEntity.getName().equals(username)) {
				System.out.println(" login success");

			}

			else if (!userEntity.getName().equals(username)) {
				System.out.println(" user fail please login again");
				return login();
			} else if (!userEntity.getPassword().equals(password)) {
				System.out.println(" password fail please login again");
				return login();
			}

		} catch (Exception e) {
			System.out.println(" login fail please login again");
			return login();
		}

		return null;
	}

}
