package edu.examination.controller;

import java.util.Scanner;

import edu.examination.dao.impl.InstituationDaoImpl;

public class MainClass {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void displayHomePage(){
		System.out.println("WELCOME ONLINE EXAMINATION MANAGEMENT SYSTEM");
		System.out.println("1. Admin");
		System.out.println("2. Instituation");
		System.out.println("3. User");
		
		outerloop:
		while(true){
			System.out.print("Select role (enter 1 or 2 or 3): ");
			String option = scanner.nextLine();
			switch (option) {
			case "1":
				System.out.println("admin start");
				break outerloop;
			case "2":
				System.out.println("==============INSTITUATION START==============");
				LoginPage login = new LoginPage();
				login.displayLoginPage();
				break outerloop;
			case "3":
				System.out.println("user start");
				break outerloop;
			default:
				System.out.println("WARNING: INCORRECT OPTION. PLEASE ENTER AGAIN!");
			}
		}
	}

	
	public static void main(String[] args) {
		displayHomePage();
	}
}
