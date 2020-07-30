package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.net.ssl.SSLEngineResult.Status;

import dao.StudentDao;
import dao.UserDao;
import dto.Student;
import dto.User;

public class Main {

	public static void main(String[] args) {
		Student student = new Student();
		StudentDao studentDao = new StudentDao();
		UserDao userDao = new UserDao();
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Do You Have An Account?");
			System.out.println("1.Yes------2.No");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
				System.out.print("Username: ");
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				String users = scanner.nextLine();
				System.out.print("Password: ");
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				String pass = scanner.nextLine();
				System.out.println(
						"----------------------------------------------------------------------------------------------------------------");
				boolean status = userDao.validate(users, pass);
				if (status == true) {
					System.out.println("Login Sucess!!!");
					boolean roll = userDao.roll(users);
					if (roll == true) {
						System.out.println("You Are Admin!!!");
						System.out.println("1.User Management-------2.Student Management");
						System.out.println(
								"----------------------------------------------------------------------------------------------------------------");
						int choose4 = scanner.nextInt();
						switch (choose4) {
						case 1:
							AdminBranch.Admin();
							break;
						case 2:
							UserBranch.Student();
							break;
						default:
							System.err.println("Again!!!");
							break;
						}
					} else {
						System.out.println("You Are User!!!");
						System.out.println("---------Student Management---------");
						System.out.println(
								"----------------------------------------------------------------------------------------------------------------");
						UserBranch.Student();
					}
				} else {
					System.err.println("Username Or Password Wrong!!!");
					System.err.println("Please Input Again!!!");
				}
				break;
			case 2:
				System.out.println("Register, Please!!!"); // REGISTER ACCOUNT
				System.out.println(
						"----------------------------------------------------------------------------------------------------------------");
				user.input();
				userDao.add(user);
				System.out.println("------------------------");
				System.out.println("Register Successfull!!!");
				break;
			default:
				System.err.println("Fail!!!");
				break;
			}

		}
	}

	


}
