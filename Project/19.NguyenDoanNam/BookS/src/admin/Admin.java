package admin;

import java.util.Scanner;

public class Admin {
	Scanner scanner = new Scanner(System.in);
	UsersView userview = new UsersView();
	CategoryView categoryview = new CategoryView();
	BookView bookview = new BookView();
	Billview bill_view = new Billview();
	BillDetailView billDetailView = new BillDetailView();
	public void notification() {
		boolean check_ad = true;
		while (check_ad) {
			
			System.out.println("You are logged in as an administrator");
			System.out.println("Select the function");
			System.out.println("1.User");
			System.out.println("2.Category_book");
			System.out.println("3.Book");
			System.out.println("4.Bill");
			System.out.println("5.Bill_detail");
			System.out.println("6.End");
			String check = scanner.next();
			switch (check) {
			case "1":
				check_ad = false;
				userview.view();
				break;
			case "2":
				check_ad = false;
				categoryview.view();
				break;
			case "3":
				bookview.view();
				check_ad = false;
				break;
			case "4":
				bill_view.view();
				check_ad = false;
				break;
			case "5":
				billDetailView.view();
				check_ad = false;
				break;
			case "6":
				System.out.println("END");
				check_ad = false;
				break;
			default:
				System.out.println("PLEASE SELECT 1-6");
				check_ad = true;
				break;
			}

		}

	}
}
