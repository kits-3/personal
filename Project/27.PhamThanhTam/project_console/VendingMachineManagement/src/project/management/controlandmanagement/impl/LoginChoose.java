package project.management.controlandmanagement.impl;

import java.util.Scanner;

import project.management.ControlAndManagement;
import project.management.Vending_Machine_3_machine.machine_drink_food__computer;
import project.management.controlandmanagement.IProduct;
import project.management.controlandmanagement.IStatistics;
import project.management.service.ILoginService;
import project.management.service.impl.LoginService;

public class LoginChoose {
	public void loginChooses(String key) {
		ILoginService loginService = new LoginService();
		IProduct product = new Product();
		Scanner scan = new Scanner(System.in);
		switch (key) {
		case "1": {
			int money = 0;
			new machine_drink_food__computer(money);
			break;
		}
		case "2": {
			System.out.println("input username");
			String username = scan.next();
			System.out.println("input password");
			String password = scan.next();
			String role = loginService.login(username, password);
			System.out.println("status: login " + role);
			switch (role) {
			case "ADMIN": {
				/* get product option */
				product.product();
				break;
			}
			case "NORMALSTAFF": {
				IStatistics statistics = new Statistic();
				statistics.statistics();
				break;
			}
			default:
				System.out.println("Please select again");
				new ControlAndManagement();
				break;
			}

			break;
		}
		case "3": {
			/* out program */
			break;
		}
		default:
			System.out.println("you choose false please choose again");
			new ControlAndManagement();
		}
	}
}