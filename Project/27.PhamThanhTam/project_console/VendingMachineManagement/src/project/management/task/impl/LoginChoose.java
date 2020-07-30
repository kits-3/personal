package project.management.task.impl;

import java.util.Scanner;

import project.management.ControlAndManagement;
import project.management.VendingMachine.MachineComputer;
import project.management.controlandmanagement.IAdmin;
import project.management.controlandmanagement.IUser;
import project.management.controlandmanagement.impl.Admin;
import project.management.controlandmanagement.impl.User;
import project.management.service.ILoginService;
import project.management.service.impl.LoginService;
import project.management.task.ILoginChoose;

public class LoginChoose implements ILoginChoose {
	private IUser user;
	private ILoginService loginService;
	private Scanner scan;
	private MachineComputer machineComputer;
	public LoginChoose() {
		this.loginService = new LoginService();
		this.scan = new Scanner(System.in);// create intance not use where call method
		this.user = new User();
		this.machineComputer = new MachineComputer();
	}

	@Override
	public void loginOption(String key) {
		IAdmin admin = new Admin();
		switch (key) {
		case "1": {
			int money = 0;
			machineComputer.choiceMachine(money);
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
				/* get admin option */
				admin.admin();
			}
			case "NORMALSTAFF": {
				/* get normal staff option */
				user.statistics();
			}
			default:
				loginOption(key);
				System.out.println("Please select again");
			}
		}
		case "3": {
			/* out program */
			break;
		}
		default:
			/* select wrong */
			System.out.println("you choose false please choose again");
			ControlAndManagement controlAndManagement = new ControlAndManagement();
			controlAndManagement.run();
		}
	}

}
