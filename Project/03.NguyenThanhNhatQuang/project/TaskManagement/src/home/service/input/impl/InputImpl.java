package home.service.input.impl;

import java.util.InputMismatchException;
import java.util.Scanner;

import home.service.input.IInput;

public class InputImpl implements IInput{

	@Override
	public int userChoose() {
		Scanner scanner;
		int choose = 0;
		while(true) {
			try {
				scanner = new Scanner(System.in);
				choose = scanner.nextInt();
				if (choose >= 0) {
					break;
				} else {
					System.out.print("Number >= 0: ");
				}
			} catch(InputMismatchException ex) {
				System.out.print("Input number: ");
			}
		}
		return choose;
	}

	@Override
	public String userName() {
		Scanner scanner = new Scanner(System.in);
		String userName = "";
		userName = scanner.nextLine();
		return userName;
	}

	@Override
	public String passWord() {
		Scanner scanner = new Scanner(System.in);
		String passWord = "";
		passWord = scanner.nextLine();
		return passWord;
	}

	@Override
	public String email() {
		Scanner scanner = new Scanner(System.in);
		String email = "";
		email = scanner.nextLine();
		return email;
	}

	@Override
	public String lname() {
		Scanner scanner = new Scanner(System.in);
		String lname = "";
		lname = scanner.nextLine();
		return lname;
	}

	@Override
	public String fname() {
		Scanner scanner = new Scanner(System.in);
		String fname = "";
		fname = scanner.nextLine();
		return fname;
	}

	@Override
	public String phone() {
		Scanner scanner = new Scanner(System.in);
		String phone = "";
		phone = scanner.nextLine();
		return phone;
	}

	@Override
	public String headerTask() {
		Scanner scanner = new Scanner(System.in);
		String headerTask = "";
		headerTask = scanner.nextLine();
		return headerTask;
	}

	@Override
	public int status() {
		Scanner scanner = new Scanner(System.in);
		int choose = 0;
		choose = scanner.nextInt();
		return choose;
	}

	@Override
	public int display() {
		Scanner scanner = new Scanner(System.in);
		int choose = 0;
		choose = scanner.nextInt();
		return choose;
	}

	@Override
	public String description() {
		Scanner scanner = new Scanner(System.in);
		String descriptionTask = "";
		descriptionTask = scanner.nextLine();
		return descriptionTask;
	}

	@Override
	public String content() {
		Scanner scanner = new Scanner(System.in);
		String content = "";
		content = scanner.nextLine();
		return content;
	}

}
