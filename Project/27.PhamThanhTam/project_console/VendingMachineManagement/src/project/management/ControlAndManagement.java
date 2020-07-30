package project.management;

import java.util.Scanner;

import project.management.task.ILoginChoose;
import project.management.task.impl.LoginChoose;

public class ControlAndManagement {
 
	private ILoginChoose loginChoose;

	public ControlAndManagement() {
		this.loginChoose = new LoginChoose();
	}
	public void run() {
		Scanner scan = new Scanner(System.in);
		System.out.println("choose: 1.customer  2.staff 3.Out program");
		System.out.println("input: 1 or 2 or 3");

		String key = scan.next();
		loginChoose.loginOption(key);
		scan.close();
	}

}
