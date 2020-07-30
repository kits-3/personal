package dung.main;

import java.util.List;
import java.util.Scanner;

import dung.connect.Dao;
import dung.connect.LogIn;
import dung.dto.Product;
import dung.dto.User;
import dung.function.Register;

public class Program {
	static Dao dao = new Dao();
	static Scanner scan = new Scanner(System.in);
	public void program() {
		List<Product> ls = dao.findProduct();
		dao.printProduct(ls);
		System.out.println("_____________________________________________________________________________________________\n");
		boolean checkLogFalse;

		do {
			checkLogFalse = false;
			try {
				String traLoi = null;
				do {
					System.out.println("Do you have an account? (y/n?)");
					System.out.print("Answer: ");
					traLoi = scan.next();
					if (traLoi.equalsIgnoreCase("y") == false && traLoi.equalsIgnoreCase("n") == false) {
						System.out.println("answer false");
					}
					switch (traLoi) {
					case "n": {
						Register regis = new Register();
						User newUser = new User();
						newUser = regis.register();
						dao.addUser(newUser);
						regis.addInfo(newUser);
						break;
					}
					case "y":
						break;
					}
				} while (traLoi.equalsIgnoreCase("y") == false && traLoi.equalsIgnoreCase("n") == false);
				System.out.println("_____________________________________________________________________________________________\n");
			} catch (Exception e) {
			}

// -----------------------------------LogIn-----------------------------------------

			System.out.println("--------------------Login !--------------------");
			System.out.print("Input user: ");
			String ID = scan.next(); 
			System.out.print("Input password: ");
			String pWd = scan.next();
			User user = new User();
			user.setUser(ID);
			user.setPassword(pWd);
			LogIn login = new LogIn();
			if (login.checkLogIn(user) == true) {
		
				user = dao.findUser(user.getUser());
				int Permmis = login.checkPermission(user);
				System.out.println("_____________________________________________________________________________________________\n");
				if (Permmis == 1) {
					Admin admin = new Admin();
					admin.amin(user);


				} else if (Permmis == 2) {
					Client Cl = new Client();
					Cl.client(user);
				} else {
					Person person = new Person();
					person.person(user);
				}
			}
			if (checkLogFalse == false) {
				System.out.println("Are you End? (y/n)");
				System.out.print("input choice: ");
				String Log = scan.next(); 
				if (Log.equalsIgnoreCase("y")) {
					checkLogFalse = true;
				}
			}
		} while (checkLogFalse == false);
		System.out.println("Thank you!!! \nGood bye!");
	}
}
