package project;

import java.util.Scanner;

import dao.UserDao;
import dto.User;

public class AdminBranch {
 public static void Admin() {
	 Scanner scanner = new Scanner(System.in);
	 UserDao userDao= new UserDao();
	 User user = new User();
	 int choose1;
		do {
			showMenuUser();
			choose1 = scanner.nextInt();
			switch (choose1) {
			case 1:
				user.input1();
				userDao.updateRoll(user);
				break;
			case 2:
				System.out.print("Input Id To Delete: ");
				int id = scanner.nextInt();
				userDao.delete(id);
				break;
			case 3:
				userDao.view();
				break;
			case 4:
				System.out.println("Input Name To Search:");
				String idString = scanner.next();
				userDao.getUserByName(idString);
				break;
			case 5:
				userDao.outPut();
				break;
			case 6:
				System.out.println("Exit!!!");
				break;
			default:
				System.err.println("Fail!!!");
				break;
			}
		} while (choose1 != 6);
 }
 public static void showMenuUser() {
		System.out.println("1.Update Rollname User------2.Delete User------3.View User");
		System.out.println("4.Search User By Name------5.Print to txt------6.Exit");
		System.out.print("Choose:  ");
	}
}
