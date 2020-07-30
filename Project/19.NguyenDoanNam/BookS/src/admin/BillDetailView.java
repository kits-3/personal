package admin;

import java.util.Scanner;

import adminDao.BillDetailImpl;


public class BillDetailView {
	Scanner scanner = new Scanner(System.in);

	public void view() {
		boolean check_billdetail = true;
		while (check_billdetail) {
			System.out.println("1.Bill Detail: ");
			System.out.println("------------------------------------------");
			new BillDetailImpl().findAll();
			System.out.println("------------------------------------------");
			System.out.println("1-1.Select the function");
			System.out.println("1-2.End");
			String key = scanner.next();
			scanner.nextLine();
			switch (key) {
			case "1":
				new Admin().notification();
				check_billdetail = false;
				break;
			case "2":
				System.out.println("END");
				check_billdetail = false;
				break;
			default:
				break;
			}
		}
	}
}
