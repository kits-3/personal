package edu.examination.controller;

import java.util.List;
import java.util.Scanner;

import edu.examination.dao.InstituationDao;
import edu.examination.dao.impl.InstituationDaoImpl;
import edu.examination.entity.InstituationEntity;

public class LoginPage {

	private Scanner scanner = new Scanner(System.in);
	private String email;
	private String password;
	private InstituationDao instituation;

	public void displayLoginPage() {
		System.out.println("==============LOGIN PAGE==============");
		System.out.println("1. Login");
		System.out.println("2. Register");

		outerloop: while (true) {
			System.out.print("Select option (enter 1 or 2): ");
			String option = scanner.nextLine();
			switch (option) {
			case "1":
				login();
				break outerloop;
			case "2":
				RegisterPage register = new RegisterPage();
				register.registerInstituation();
				break outerloop;
			default:
				System.out.println("WARNING: INCORRECT OPTION. PLEASE ENTER AGAIN!");
			}
		}
	}

	public boolean login() {
		

		

		instituation = new InstituationDaoImpl();

		List<InstituationEntity> instituationList = instituation.getAllInstituations();
		for (InstituationEntity currentInstitute : instituationList) {
			String currentInstiEmail = currentInstitute.getInstiEmailAddress();
			if (currentInstiEmail.equals(email)) {
				String currentInstiPassword = currentInstitute.getInstiPassword();
				if (currentInstiPassword.equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

	private void enterEmail(){
		while (true) {
			System.out.print("Enter email: ");
			email = scanner.nextLine();
			if (email.isEmpty()) {
				System.out.println("EMAIL CAN NOT BLANK");
				continue;
			}
			break;
		}
	}
	
	private void enterPassword(){
		while (true) {
			System.out.print("Enter password: ");
			password = scanner.nextLine();
			if (password.isEmpty()) {
				System.out.println("PASSWORD CAN NOT BLANK");
				continue;
			}
			break;
		}
	}
}
