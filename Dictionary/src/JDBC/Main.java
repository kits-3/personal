package JDBC;

import java.util.Scanner;

import Dao.UserDao;
import Dao.roleDao;
import model.roleDto;
import model.userDto;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);
	static userDto userDto = new userDto();
	static roleDto roleDto = new roleDto();
	static roleDao roleDao = new roleDao();
	static UserDao userDao = new UserDao();

	public static void main(String[] args) {

////		role.setId();
////		role.setName("admin");
////		dto.setUserName("Thanh Thinh");
////		dto.setPassWord("123456");
////		dto.setRoleId(1);
//

////		roleDao.add(role);
////		roleDao.findAll();
//		int id ;
//		UserDao dao = new UserDao();
////		dao.findAll();
//		for (int i = 0; i < dao.findAll().size(); i++) {
//			System.out.println(dao.findAll().get(i).getRoleId());
//			id = dao.findAll().get(i).getRoleId();
//			roleDao.findOne(id);
//		}
////		dao.add(dto);
////		dao.delete("Thanh Thinh");
		String choose = null;
		boolean exit = false;
		
		while (true) {
			showHome();
			choose = scanner.nextLine();
			switch (choose) {
			case "1":
				System.out.println("choose login");
				showLogin();
				break;
			case "2":
				System.out.println("choose Rigister");
				break;
			case "3":
				System.out.println("Forgot password");
				break;
            case "0":
                System.out.println("exited!");
                exit = true;
                break;

			default:
				System.out.println("invalid! please choose action in below menu:");
				break;
			}
			if(exit) {
				break;
			}
		}

	}

	public static void showHome() {
		System.out.println("Dictionary System Demo Version 0.001");
		System.out.println(" ----------------------------------");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Forgot password");
		System.out.println("0. Exits");
		System.out.println(" ----------------------------------");
		System.out.print("Please choose: ");

	}
	
	public static void showLogin () {
		System.out.println("Plese enter your username");
		String userName = scanner.nextLine();
		System.out.println("Plese enter your password");
		String password = scanner.nextLine();
		userDto dto = userDao.checkLogin(userName, password);
		if (dto != null ) {
			userDao.checkRole(dto.getRoleId());
		}
		
	}

}
