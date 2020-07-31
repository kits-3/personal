package admin;

import java.util.Scanner;

import adminDao.BillImpl;

public class Billview {
	Scanner scanner = new Scanner(System.in);

	public void view() {
		boolean check_bill = true;
		while (check_bill) {
			System.out.println("1.Bill: ");
			System.out.println("------------------------------------------");
			new BillImpl().findAll();
			System.out.println("------------------------------------------");
			System.out.println("1-1.Select the function");
			System.out.println("1-2.End");
			String key = scanner.next();
			scanner.nextLine();
			switch (key) {
			case "1":
				new Admin().notification();
				check_bill = false;
				break;
			case "2":
				System.out.println("END");
				check_bill = false;
				break;
			default:
				break;
			}
		}
	}
}
