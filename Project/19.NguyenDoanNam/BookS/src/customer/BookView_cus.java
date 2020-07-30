package customer;

import java.util.List;
import java.util.Scanner;

import customerDao.BookDaoImpl_cus;
import customerDao.BookDao_cus;
import customerDao.CategoryDao_cus;
import customerDao.CategoryImpl_cus;
import entity.Book;

public class BookView_cus {

	public void view(String gmail, List<Book> list, String category_name) {
		CategoryDao_cus categirydao_cus = new CategoryImpl_cus();
		BookDao_cus bookDao_cus = new BookDaoImpl_cus();
		Scanner scanner = new Scanner(System.in);
		try {
			boolean checkBookView_cus = true;
			while (checkBookView_cus) {
				System.out.println("1.Select the book you want to buy");
				System.out.println("2.Choose category book you want buy");
				System.out.println("3.Log out");
				String key = scanner.next();
				switch (key) {
				case "1":
					categirydao_cus.findBy_category(gmail, category_name, list);
					System.out.println("Select the book you want to buy");
					scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
					String book_name = scanner.nextLine();
					BillView_cus bill = new BillView_cus();
					list = bookDao_cus.findbyBook_name(gmail, book_name, list);
					bill.upBill(gmail, list);
					checkBookView_cus = false;
					break;
				case "2":
					new CategoryView_cus().view(gmail, list);
					checkBookView_cus = false;
					break;
				case "3":
					System.out.println("END");
					checkBookView_cus = false;
					break;
				default:
					System.out.println("Please select 1 -> 3");
					checkBookView_cus = true;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

}
